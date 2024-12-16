/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Palabras {
    
    private String original;
    private String traduccion;
    
    public Palabras(String original, String traduccion){
        this.original = original;
        this.traduccion = traduccion;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTraduccion() {
        return traduccion;
    }

    public void setTraduccion(String traduccion) {
        this.traduccion = traduccion;
    }
    
    @Override
    public String toString(){
        return original + " " + traduccion;
    }
}
