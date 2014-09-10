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
    private ArrayList<PalabraIndice> palabras;

    public PalabrasMasUsadas() {
        palabras = new ArrayList<>();

    }

    public boolean agregarPalabra(String palabra) {
        boolean agrego = false;
        if (!palabra.isEmpty()) {
            PalabraIndice palabraIndice = buscarPalabra(palabra);
            if (palabraIndice == null) {
                //la palabra no existe por tanto se agrega a colleccion dee palabras
                agrego = palabras.add(new PalabraIndice(palabra));
            } else {
                //palabra existe es repetida incrementa 1 su indice
                agrego = incrementarIndice(palabra);
            }
        }
        return agrego; 
    }

    public PalabraIndice buscarPalabra(String palabra) {
        PalabraIndice palabraIndice = null;
        if (!palabras.isEmpty()) {
            int i = 0;
            boolean encontrado = false;
            while (!encontrado && i < palabras.size()) {
                palabraIndice = palabras.get(i);
                if (palabraIndice.esIgual(palabra)) {
                    encontrado = true;
                } else {
                    palabraIndice = null;
                }
                i++;
            }
        }
        return palabraIndice;
    }

    public void procesarTexto(String texto) {
        if (!texto.isEmpty()) {
            String[] palabrasTexto = getPalabras(texto);
            for (String palabraTexto : palabrasTexto) {
                agregarPalabra(palabraTexto);
            }
        }
    }

    public int palabraRepetida(String palabra) {
        int palabraRepetida = 0;
        PalabraIndice palabraIndice = buscarPalabra(palabra);
        if (palabraIndice != null) {
            palabraRepetida = palabraIndice.getIndice();
        }
        return palabraRepetida;
    }

    public boolean incrementarIndice(String palabra) {
        boolean incremento = false;
        int i = 0;
        while (i < palabras.size() && !incremento) {
            if (palabras.get(i).esIgual(palabra)) {
                palabras.get(i).incrementarIndice();
                incremento = true;
            }
            i++;
        }
        return incremento;
    }

    public ArrayList<String> discriminarArticulos(String[] palabras, String[] articulos) {
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

    protected String[] getPalabras(String texto) {


        String textoSinPuntuacion = texto.replaceAll("[;:,.()]", "");
        String[] palabrasTexto = textoSinPuntuacion.split("\\s+");
        return palabrasTexto;
    }

    public ArrayList<PalabraIndice> getNPalabras(int masUsadas) {
        ArrayList<PalabraIndice> palabrasMasUsadas = new ArrayList<>();
        if (!palabras.isEmpty() && masUsadas > 0) {
            ArrayList copiaPalabras = (ArrayList) palabras.clone();
            int cantidad = 0;            
            int indexElemento = 0;
            while (!copiaPalabras.isEmpty() && cantidad < masUsadas) {
                int i = 0;
                int mayor = 0;
                while (i < copiaPalabras.size()) {
                    PalabraIndice palabra = (PalabraIndice) copiaPalabras.get(i);
                    if (palabra.getIndice() > mayor) {
                        indexElemento = i;
                        mayor = palabra.getIndice();
                    }

                    i++;
                }
                palabrasMasUsadas.add((PalabraIndice) copiaPalabras.remove(indexElemento));
                cantidad++;
                mayor = 0;
            }
        }
        return palabrasMasUsadas;
    }
    public ArrayList<PalabraIndice> getListaPalabras() {
        return palabras;
    }
}
