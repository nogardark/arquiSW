import static org.junit.Assert.*;
import org.junit.Test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author franko
 */
public class PalabraTest {

    /**
     * Partiendo de lo mas simple.. que una palabra(String) este asociada a las
     * veces que se repite(indice)
     */
    @Test
    public void nuevaPalabra() {
        String palabra = "palabra";
        Palabra Palabra = new Palabra(palabra);
        int esperado = 1;
        int respuesta = Palabra.getRepetida();
        assertEquals(esperado, respuesta);
    }

    @Test
    public void incrementarIndicePalabra() {
        String palabra = "palabra";
        Palabra Palabra = new Palabra(palabra);
        int repetir = 0;
        while (repetir < 5) {
            Palabra.incrementarRepetido();
            repetir++;
        }
        int esperado = 6;
        int respuesta = Palabra.getRepetida();
        assertEquals(esperado, respuesta);
    }

    @Test
    public void compararPalabraMinusculasIguales() {
        Palabra palabra1 = new Palabra("palabra");
        String palabra2 = "palabra";
        assertTrue(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMinusculasDistintos() {
        Palabra palabra1 = new Palabra("palabra");
        String palabra2 = "palabra2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMayusculaIguales() {
        Palabra palabra1 = new Palabra("palabra");
        String palabra2 = "PALABRA";
        assertTrue(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMayusculaDistintos() {
        Palabra palabra1 = new Palabra("palabra");
        String palabra2 = "PALABRA2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabrasMayusculasIguales() {
        Palabra palabra1 = new Palabra("PALABRA");
        String palabra2 = "palabra";
        assertTrue(palabra1.esIgual(palabra2));
    }

    public void compararPalabrasMayusculasDistintos() {
        Palabra palabra1 = new Palabra("PALABRA");
        String palabra2 = "PALABRA2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraVacia() {
        Palabra palabra1 = new Palabra("PALAbra");
        String palabra2 = "";
        assertFalse(palabra1.esIgual(palabra2));
    }
    /**
     * @Test public void compararPalabrasConAcento(){ Palabra palabra1=new
     * Palabra("palabra"); String palabra2="palabrá";
     * assertTrue(palabra1.esIgual(palabra2)); }
     *
     *
     */
}
