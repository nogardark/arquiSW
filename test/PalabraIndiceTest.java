
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
public class PalabraIndiceTest {

    /**
     * Partiendo de lo mas simple.. que una palabra(String) este asociada a las
     * veces que se repite(indice)
     */
    @Test
    public void nuevaPalabra() {
        String palabra = "palabra";
        PalabraIndice palabraIndice = new PalabraIndice(palabra);
        int esperado = 1;
        int respuesta = palabraIndice.getIndice();
        assertEquals(esperado, respuesta);
    }

    @Test
    public void incrementarIndicePalabra() {
        String palabra = "palabra";
        PalabraIndice palabraIndice = new PalabraIndice(palabra);
        int repetir = 0;
        while (repetir < 5) {
            palabraIndice.incrementarIndice();
            repetir++;
        }
        int esperado = 6;
        int respuesta = palabraIndice.getIndice();
        assertEquals(esperado, respuesta);
    }

    @Test
    public void compararPalabraMinusculasIguales() {
        PalabraIndice palabra1 = new PalabraIndice("palabra");
        String palabra2 = "palabra";
        assertTrue(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMinusculasDistintos() {
        PalabraIndice palabra1 = new PalabraIndice("palabra");
        String palabra2 = "palabra2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMayusculaIguales() {
        PalabraIndice palabra1 = new PalabraIndice("palabra");
        String palabra2 = "PALABRA";
        assertTrue(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraMayusculaDistintos() {
        PalabraIndice palabra1 = new PalabraIndice("palabra");
        String palabra2 = "PALABRA2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabrasMayusculasIguales() {
        PalabraIndice palabra1 = new PalabraIndice("PALABRA");
        String palabra2 = "palabra";
        assertTrue(palabra1.esIgual(palabra2));
    }

    public void compararPalabrasMayusculasDistintos() {
        PalabraIndice palabra1 = new PalabraIndice("PALABRA");
        String palabra2 = "PALABRA2";
        assertFalse(palabra1.esIgual(palabra2));
    }

    @Test
    public void compararPalabraVacia() {
        PalabraIndice palabra1 = new PalabraIndice("PALAbra");
        String palabra2 = "";
        assertFalse(palabra1.esIgual(palabra2));
    }
    /**
     * @Test public void compararPalabrasConAcento(){ PalabraIndice palabra1=new
     * PalabraIndice("palabra"); String palabra2="palabrá";
     * assertTrue(palabra1.esIgual(palabra2)); }
     *
     *
     */
}
