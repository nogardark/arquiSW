import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author franko
 */
public class PalabrasMasUsadas {

    /**
     * una coleccion de palabras asociada a las veces q se repite.
     *
     */
   

    public PalabrasMasUsadas() {
        

    }

    private ArrayList<String> discriminarArticulos(String[] palabras, String[] articulos) {
        ArrayList<String> palabrasSinArticulos = new ArrayList<>();
        for (String palabra : palabras) {
            int i = 0;
            boolean esArticulo = false;
            while (!esArticulo && i < articulos.length) {
                esArticulo = palabra.equalsIgnoreCase(articulos[i]);
                i++;
            }
            if (!esArticulo) {
                palabrasSinArticulos.add(palabra);
            }
        }
        return palabrasSinArticulos;
    }

    private String[] getPalabras(String texto) {
        String textoSinPuntuacion = texto.replaceAll("[;:,.()]", "");
        String[] palabrasTexto = textoSinPuntuacion.split("\\s+");
        return palabrasTexto;
    }

    private ArrayList<Palabra> getNPalabras(ArrayList<Palabra>palabras,int masUsadas) {
        ArrayList<Palabra> palabrasMasUsadas = new ArrayList<>();
        if (!palabras.isEmpty() && masUsadas > 0) {
            ArrayList copiaPalabras = (ArrayList) palabras.clone();
            int cantidad = 0;            
            int indexElemento = 0;
            int mayor = 0;
            while (!copiaPalabras.isEmpty() && cantidad < masUsadas) {
                int i = 0;
                
                while (i < copiaPalabras.size()) {
                    Palabra palabra = (Palabra) copiaPalabras.get(i);
                    if (palabra.getRepetida()> mayor) {
                        indexElemento = i;
                        mayor = palabra.getRepetida();
                    }

                    i++;
                }
                palabrasMasUsadas.add((Palabra) copiaPalabras.remove(indexElemento));
                cantidad++;
                mayor = 0;
            }
        }
        return palabrasMasUsadas;
    }
    

    public ArrayList<Palabra> getPalabrasMasUsadas(String texto, String[] articulos, int masUsadas) {
        
        if(!texto.isEmpty()&& masUsadas>0){            
             ArrayList<String>palabras=discriminarArticulos(getPalabras(texto), articulos);
             ArrayList<Palabra>palabrasUsadas=new ArrayList<>();
             procesarPalabras(palabrasUsadas,palabras);             
          return getNPalabras(palabrasUsadas,masUsadas);   
        }else{
            return null;
        }
        
    }
    private int getIndexPalabra(ArrayList<Palabra> palabras,String palabra) {
        int index=-1;
        if(!palabras.isEmpty()){
            boolean encontrado=false;
            int i=0;
            while(!encontrado && i<palabras.size()){
                if(palabras.get(i).esIgual(palabra)){
                    encontrado=true;
                    index=i;
                }
                i++;
            }
        }
        return index;
    }

    private void procesarPalabras(ArrayList<Palabra> palabrasUsadas, ArrayList<String> palabras) {
           while(!palabras.isEmpty()){
                int index=getIndexPalabra(palabrasUsadas,palabras.get(0));
                if(index<0){
                    palabrasUsadas.add(new Palabra(palabras.remove(0)));
                }
                else{
                   palabras.remove(0);
                   palabrasUsadas.get(index).incrementarRepetido();
                }
            }     
    }
}
