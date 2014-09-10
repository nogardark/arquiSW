/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franko
 */
public class PalabrasMasUsadasTest {

    @Test
    public void agregarPalabra() {
        String palabra = "PALABRA";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        boolean respuesta = palabrasMasUsadas.agregarPalabra(palabra);
        assertTrue(respuesta);
    }

    @Test
    public void noAgregarPalabraVacia() {
        String palabra = "";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        boolean respuesta = palabrasMasUsadas.agregarPalabra(palabra);
        assertFalse(respuesta);
    }

    @Test
    public void palabraNoExisteConListaVacia() {
        String palabra = "nuevo";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        PalabraIndice respuesta = palabrasMasUsadas.buscarPalabra(palabra);
        assertNull(respuesta);
    }

    @Test
    public void palabraNoExisteConListaNoVacia() {
        String palabra = "nuevo";
        String palabra1 = "palabra1";
        String palabra2 = "palabra2";
        String palabra3 = "palabra3";

        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.agregarPalabra(palabra1);
        palabrasMasUsadas.agregarPalabra(palabra2);
        palabrasMasUsadas.agregarPalabra(palabra3);
        PalabraIndice respuesta = palabrasMasUsadas.buscarPalabra(palabra);

        assertNull(respuesta);
    }

    @Test
    public void palabraExisteConListaNoVacia() {
        String palabra = "nuevo";
        String palabra1 = "palabra1";
        String palabra2 = "palabra2";
        String palabra3 = "palabra3";

        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.agregarPalabra(palabra1);
        palabrasMasUsadas.agregarPalabra(palabra2);
        palabrasMasUsadas.agregarPalabra(palabra3);
        palabrasMasUsadas.agregarPalabra(palabra);
        PalabraIndice resultado = palabrasMasUsadas.buscarPalabra(palabra);
        assertNotNull(resultado);
    }

    @Test
    public void incrementarIndicePalabraNoExiste() {
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        boolean respuesta = palabrasMasUsadas.incrementarIndice(palabra);
        assertFalse(respuesta);
    }

    @Test
    public void incrementarIndicePalabraExiste() {
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.agregarPalabra(palabra);
        boolean respuesta = palabrasMasUsadas.incrementarIndice(palabra);
        assertTrue(respuesta);
    }

    @Test
    public void agregarPalabraDosVecesListaMantenerSize() {
        String palabra = "nuevo";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();

        palabrasMasUsadas.agregarPalabra(palabra);
        palabrasMasUsadas.agregarPalabra(palabra);

        int respuesta = palabrasMasUsadas.getListaPalabras().size();
        int esperado = 1;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void agregarPalabraDosVeces() {
        String palabra = "nuevo";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();

        palabrasMasUsadas.agregarPalabra(palabra);
        palabrasMasUsadas.agregarPalabra(palabra);

        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 2;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void obtenerPalabraDeTextoVacio() {
        String texto = "";
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.getPalabras(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 0;
        assertEquals(esperado, respuesta);
    }

    public void obtenerPalabraVaciaDeTextoVacio() {
        String texto = "";
        String palabra = "";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.getPalabras(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 0;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void obtenerPalabraDeTextoNoVacio() {
        String texto = "una palabra es cada uno de los segmentos limitados por delimitadores "
                + "en la cadena hablada o escrita.";
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.procesarTexto(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 1;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void tresVecesPalabraDeTextoNoVacio() {
        String texto = "una palabra es cada uno de los segmentos limitados por delimitadores "
                + "en la cadena palabra hablada o escrita y palabra.";
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.procesarTexto(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 3;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void discrinandoPuntuacion() {
        String texto = "texto. palabra, (texto) palabra; texto:";
        String palabra = "texto";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.procesarTexto(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 3;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void discrinandoPuntuacionDos() {
        String texto = "texto palabra, (texto) palabra; texto";
        String palabra = "palabra";
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.procesarTexto(texto);
        int respuesta = palabrasMasUsadas.palabraRepetida(palabra);
        int esperado = 2;
        assertEquals(esperado, respuesta);
    }

    @Test
    public void discrinandoArticulos() {
        String texto = "La arquitectura de software forma la columna vertebral para "
                + "construir un sistema de software, es en gran medida responsable "
                + "de permitir o no ciertos atributos de calidad del sistema entre "
                + "los que se destacan la confiabilidad y el rendimiento del software.";

        String[] articulos = {"la", "el", "las", "los", "no", "de", "del", "en", "para", "que", "se", "un", "o", "y", "gran", "entre"};
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        String[] palabrasConArticulos = palabrasMasUsadas.getPalabras(texto);
        ArrayList<String> palabrasSinArticulos = palabrasMasUsadas.discriminarArticulos(palabrasConArticulos, articulos);
        boolean existeArticulo = false;
        int i = 0;
        int j = 0;
        while (!existeArticulo && i < palabrasSinArticulos.size()) {
            while (!existeArticulo && j < articulos.length) {
                existeArticulo = palabrasSinArticulos.get(i).equalsIgnoreCase(articulos[j]);
                j++;
            }
            i++;
        }
        assertFalse(existeArticulo);

    }

    @Test
    public void nNegativoPalabrasMasUsadas() {
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        palabrasMasUsadas.agregarPalabra("texto");
        ArrayList<PalabraIndice> masUsadas = palabrasMasUsadas.getNPalabras(-4);
        int cantidadEsperado = 0;
        int cantidadObtenido = masUsadas.size();
        assertEquals(cantidadEsperado, cantidadObtenido);
    }

    @Test
    public void nPalabrasMasUsadasListaVacia() {
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        ArrayList<PalabraIndice> masUsadas = palabrasMasUsadas.getNPalabras(4);
        int cantidadEsperado = 0;
        int cantidadObtenido = masUsadas.size();
        assertEquals(cantidadEsperado, cantidadObtenido);
    }

    @Test
    public void dosPalabrasMasUsadas() {

        String texto = "palabra peculiar, es palabra. Peculiar texto; funcion funcion. Funcion; estatica (palabra) "
                + "peculiar estatica funcion de la palabra se toma el texto en la funcion";
        String[] articulos = {"la", "de", "se", "el", "es", "en"};
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        String[] palabrasConArticulos = palabrasMasUsadas.getPalabras(texto);
        ArrayList<String> palabrasSinArticulos = palabrasMasUsadas.discriminarArticulos(palabrasConArticulos, articulos);

        for (Iterator<String> it = palabrasSinArticulos.iterator(); it.hasNext();) {
            String palabra = it.next();
            palabrasMasUsadas.agregarPalabra(palabra);
        }
        /**
         * funcion->5 palabra->4 peculiar->3 texto->2 estatica->2
         *
         */
        ArrayList<PalabraIndice> masUsadas = palabrasMasUsadas.getNPalabras(2);
        int cantidadEsperado = 2;
        int cantidadObtenido = masUsadas.size();

        PalabraIndice p1 = masUsadas.get(0);
        PalabraIndice p2 = masUsadas.get(1);

        boolean esperadoP1 = p1.esIgual("funcion");
        boolean esperadoP2 = p2.esIgual("palabra");
        int repetidoP1 = p1.getIndice();
        int repetidoP2 = p2.getIndice();

        assertEquals(cantidadEsperado, cantidadObtenido);
        assertTrue(esperadoP1);
        assertTrue(esperadoP2);
        assertEquals(5, repetidoP1);
        assertEquals(4, repetidoP2);
    }

    @Test
    public void tresPalabrasMasUsadas() {

        String texto = "palabra peculiar, es palabra. Peculiar texto; funcion funcion. Funcion: estatica (palabra) "
                + "peculiar estatica funcion de la palabra se toma el texto en la funcion";
        String[] articulos = {"la", "de", "se", "el", "es", "en"};
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        String[] palabrasConArticulos = palabrasMasUsadas.getPalabras(texto);
        ArrayList<String> palabrasSinArticulos = palabrasMasUsadas.discriminarArticulos(palabrasConArticulos, articulos);

        for (Iterator<String> it = palabrasSinArticulos.iterator(); it.hasNext();) {
            String palabra = it.next();
            palabrasMasUsadas.agregarPalabra(palabra);
        }
        /**
         * funcion->5 palabra->4 peculiar->3 texto->2 estatica->2
         *
         */
        ArrayList<PalabraIndice> masUsadas = palabrasMasUsadas.getNPalabras(3);
        int cantidadEsperado = 3;
        int cantidadObtenido = masUsadas.size();

        PalabraIndice p1 = masUsadas.get(0);
        PalabraIndice p2 = masUsadas.get(1);
        PalabraIndice p3 = masUsadas.get(2);
        boolean esperadoP1 = p1.esIgual("funcion");
        boolean esperadoP2 = p2.esIgual("palabra");
        boolean esperadoP3 = p3.esIgual("peculiar");

        int repetidoP1 = p1.getIndice();
        int repetidoP2 = p2.getIndice();
        int repetidoP3 = p3.getIndice();

        assertEquals(cantidadEsperado, cantidadObtenido);
        assertTrue(esperadoP1);
        assertTrue(esperadoP2);
        assertTrue(esperadoP3);

        assertEquals(5, repetidoP1);
        assertEquals(4, repetidoP2);
        assertEquals(3, repetidoP3);
    }

    public void esMenorPalabrasMasUsadas() {

        String texto = "palabra peculiar, es palabra. Peculiar texto; funcion funcion. Funcion: (palabra) "
                + "peculiar funcion de la palabra se toma el texto en la funcion estatica";
        String[] articulos = {"la", "de", "se", "el", "es", "en"};
        PalabrasMasUsadas palabrasMasUsadas = new PalabrasMasUsadas();
        String[] palabrasConArticulos = palabrasMasUsadas.getPalabras(texto);
        ArrayList<String> palabrasSinArticulos = palabrasMasUsadas.discriminarArticulos(palabrasConArticulos, articulos);

        for (Iterator<String> it = palabrasSinArticulos.iterator(); it.hasNext();) {
            String palabra = it.next();
            palabrasMasUsadas.agregarPalabra(palabra);
        }
        /**
         * funcion->5 palabra->4 peculiar->3 texto->2 estatica->1
         *
         */
        ArrayList<PalabraIndice> masUsadas = palabrasMasUsadas.getNPalabras(8);
        int cantidadEsperado = 5;
        int cantidadObtenido = masUsadas.size();

        PalabraIndice p1 = masUsadas.get(0);
        PalabraIndice p2 = masUsadas.get(1);
        PalabraIndice p3 = masUsadas.get(2);
        PalabraIndice p4 = masUsadas.get(3);
        PalabraIndice p5 = masUsadas.get(4);

        boolean esperadoP1 = p1.esIgual("funcion");
        boolean esperadoP2 = p2.esIgual("palabra");
        boolean esperadoP3 = p3.esIgual("peculiar");
        boolean esperadoP4 = p4.esIgual("texto");
        boolean esperadoP5 = p5.esIgual("estatica");

        int repetidoP1 = p1.getIndice();
        int repetidoP2 = p2.getIndice();
        int repetidoP3 = p3.getIndice();
        int repetidoP4 = p4.getIndice();
        int repetidoP5 = p5.getIndice();

        assertEquals(cantidadEsperado, cantidadObtenido);

        assertTrue(esperadoP1);
        assertTrue(esperadoP2);
        assertTrue(esperadoP3);
        assertTrue(esperadoP4);
        assertTrue(esperadoP5);

        assertEquals(5, repetidoP1);
        assertEquals(4, repetidoP2);
        assertEquals(3, repetidoP3);
        assertEquals(2, repetidoP3);
        assertEquals(1, repetidoP3);
    }
}