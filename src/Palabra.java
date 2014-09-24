/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franko
 */
class Palabra {

    private String nombre;
    private int repetida;

    public Palabra(String palabra) {
        nombre = palabra;
        repetida = 1;
    }

    public int getRepetida() {
        return repetida;
    }

    public void incrementarRepetido() {
        repetida++;
    }

    public String getPalabra() {
        return nombre;
    }

    public boolean esIgual(String palabra) {
        return nombre.equalsIgnoreCase(palabra);
    }
}
