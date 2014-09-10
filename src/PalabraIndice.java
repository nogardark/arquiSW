/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author franko
 */
class PalabraIndice implements Comparable<PalabraIndice>{
    // el atributo nombre almacenara la palabra en si

    String nombre;
    // el atributo indice indica las veces que se repite
    int indice;

    public PalabraIndice(String palabra) {
        nombre = palabra;
        indice = 1;
    }

    public int getIndice() {
        return indice;
    }

    public void incrementarIndice() {
        indice++;
    }

    public String getPalabra() {
        return nombre;
    }

    public boolean esIgual(String palabra) {
        return nombre.equalsIgnoreCase(palabra);
    }
    @Override
    public int compareTo(PalabraIndice palabra){
        if(this.indice>palabra.indice){
         return 1;
        }else if(this.indice>palabra.indice){
         return -1;
        }else{
            return 0;
        }
        
    }
}
