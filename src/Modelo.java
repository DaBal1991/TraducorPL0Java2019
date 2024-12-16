
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Modelo {

    private String usr, psw, tabla, bd, driver, ip, prefijoConexion;
    private String colUno, colDos;
    private Connection conexion;
    private ActionListener listener;

    public Modelo() {
        driver = "com.mysql.cj.jdbc.Driver";
        prefijoConexion = "jdbc:mysql://";
        usr = "";
        psw = "";
        tabla = "palabras";
        bd = "programacion";
        ip = "127.0.0.1";
        conexion = obtenerConexion();
    }

    private ArrayList<Palabras> consulta() {
        conexion = obtenerConexion();
        String q = "SELECT * FROM " + tabla;
        ArrayList<Palabras> tablaPalabras = new ArrayList();

        try {
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(q);

            while (resultSet.next()) {
                tablaPalabras.add(new Palabras(resultSet.getString(1), resultSet.getString(2)));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException ex) {
            reportException(ex.getMessage());
        }

        return tablaPalabras;
    }

    public String traductor(String codigo) {
        String codigoTraducido = null;
        codigo = codigo.replace("\n", "· ");
        String[] desarmador = codigo.split("\\s+|(?=\\W)");
        ArrayList<Palabras> p = consulta();
        ArrayList<String> traduccionIntermedia = new ArrayList();
        //boolean isNecesarioPasarMinuscula = true;

        for (int i = 0; i < desarmador.length; i++) {
/*
            System.out.print(desarmador[i]);

            if (desarmador[i].contains("'")) {
                isNecesarioPasarMinuscula = !isNecesarioPasarMinuscula;
            }

            if (isNecesarioPasarMinuscula) {
                traduccionIntermedia.add(desarmador[i].toLowerCase());
            } else {
                */traduccionIntermedia.add(desarmador[i]);/*
            }
*/
        }

        for (int i = 0; i < traduccionIntermedia.size(); i++) {
            for (int j = 0; j < p.size(); j++) {
                if (traduccionIntermedia.get(i).equalsIgnoreCase(p.get(j).getOriginal())) {
                    traduccionIntermedia.set(i, p.get(j).getTraduccion());
                }
            }
        }

        codigoTraducido = String.join(" ", traduccionIntermedia);
        codigoTraducido = codigoTraducido.replace("· ", "\n");

        return codigoTraducido;
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    private Connection obtenerConexion() {
        if (conexion == null) {
            try {
                Class.forName(driver);
// driver = "com.mysql.cj.jdbc.Driver";
            } catch (ClassNotFoundException ex) {
                reportException(ex.getMessage());
            }
            try {
// prefijoConexion = "jdbc:mysql://";
                conexion
                        = DriverManager.getConnection(prefijoConexion + ip + "/" + bd, usr, psw);
            } catch (Exception ex) {
                reportException(ex.getMessage());
            }
            Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        }
        return conexion;
    }

    private class ShutDownHook extends Thread {

        public void run() {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
    }
}
