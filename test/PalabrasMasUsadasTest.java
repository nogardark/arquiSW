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
    public void textoVacioDosPalabrasMasUsadas(){
        String texto="";
        String [] articulos=new String[15];
        int palabraMasUsadas=2;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        assertNull(palabras);
    }
    
    @Test
    public void ceroPalabrasMasUsadas(){
        String texto="hola mundo";
        String [] articulos=new String[15];
        int palabraMasUsadas=0;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        assertNull(palabras);
    }
    @Test
    public void unaPalabraMasUsadas(){
        String texto="palabra de texto,con Palabra en el mundo;";
        String [] articulos={"de","con","en","el"};
        int palabraMasUsadas=1;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        assertEquals(1,palabras.size());
        assertEquals("palabra",palabras.get(0).getPalabra());
        assertEquals(2,palabras.get(0).getRepetida());
    }
    @Test
    public void tresPalabraMasUsadas(){
        String texto="palabra de texto, con (Palabra) en el mundo; palabra palabra palabra texto, texto texto java java";
        String [] articulos={"de","con","en","el"};
        int palabraMasUsadas=3;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        
        assertEquals(3,palabras.size());
        
        assertEquals("palabra",palabras.get(0).getPalabra());
        assertEquals(5,palabras.get(0).getRepetida());
        assertEquals("texto",palabras.get(1).getPalabra());
        assertEquals(4,palabras.get(1).getRepetida());
        assertEquals("java",palabras.get(2).getPalabra());
        assertEquals(2,palabras.get(2).getRepetida());
    }
    
    @Test
    public void masPalabraMasUsadas(){
        String texto="palabra de texto, con Palabra en el mundo java; palabra palabra palabra texto, texto texto java java";
        String [] articulos={"de","con","en","el"};
        int palabraMasUsadas=6;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        
        assertEquals(4,palabras.size());
        
        assertEquals("palabra",palabras.get(0).getPalabra());
        assertEquals(5,palabras.get(0).getRepetida());
        assertEquals("texto",palabras.get(1).getPalabra());
        assertEquals(4,palabras.get(1).getRepetida());
        assertEquals("java",palabras.get(2).getPalabra());
        assertEquals(3,palabras.get(2).getRepetida());
        assertEquals("mundo",palabras.get(3).getPalabra());
        assertEquals(1,palabras.get(3).getRepetida());
    }
    @Test
    public void palabrasRepetidasIgualesMasUsadas(){
        String texto="palabra de texto, con Palabra en el mundo java; palabra palabra palabra texto, texto texto java java java";
        String [] articulos={"de","con","en","el"};
        int palabraMasUsadas=3;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        
        assertEquals(3,palabras.size());
        
        assertEquals("palabra",palabras.get(0).getPalabra());
        assertEquals(5,palabras.get(0).getRepetida());
        assertEquals("texto",palabras.get(1).getPalabra());
        assertEquals(4,palabras.get(1).getRepetida());
        assertEquals("java",palabras.get(2).getPalabra());
        assertEquals(4,palabras.get(2).getRepetida());
        /**
        assertEquals("mundo",palabras.get(3).getPalabra());
        assertEquals(1,palabras.get(3).getRepetida());
        **/
    }
    
    
    /**
    @Test
    public void incrementarPalabraRepetida(){
        ArrayList<Palabra>palabras=new ArrayList<>();
        palabras.add(new Palabra("texto"));
        palabras.add(new Palabra("palabra"));
        palabras.add(new Palabra("java"));
        PalabrasMasUsadas palabrasMasUsadas=new PalabrasMasUsadas();
        palabrasMasUsadas.incrementarIndice(palabras,0);
        palabrasMasUsadas.incrementarIndice(palabras,0);
        palabrasMasUsadas.incrementarIndice(palabras,0);
        palabrasMasUsadas.incrementarIndice(palabras,0);
        palabrasMasUsadas.incrementarIndice(palabras,1);
        palabrasMasUsadas.incrementarIndice(palabras,1);
        palabrasMasUsadas.incrementarIndice(palabras,1);
        palabrasMasUsadas.incrementarIndice(palabras,2);
        palabrasMasUsadas.incrementarIndice(palabras,2);
        
        assertEquals(5, palabras.get(0).getIndice());
        assertEquals(4, palabras.get(1).getIndice());
        assertEquals(3, palabras.get(2).getIndice());   
    }
    @Test
    public void buscarPalabraListaVacia(){
        ArrayList<Palabra>palabras=new ArrayList<>();
        PalabrasMasUsadas palabrasMasUsadas=new PalabrasMasUsadas();
        int respuesta =palabrasMasUsadas.getIndexPalabra("texto",palabras);
        assertEquals(-1,respuesta);
    }
    
    @Test
    public void buscarPalabraListaNoVacia(){
        ArrayList<Palabra>palabras=new ArrayList<>();
        palabras.add(new Palabra("texto"));
        palabras.add(new Palabra("palabra"));
        palabras.add(new Palabra("java"));
        PalabrasMasUsadas palabrasMasUsadas=new PalabrasMasUsadas();
        int respuesta1 =palabrasMasUsadas.getIndexPalabra("texto",palabras);
        assertEquals(0,respuesta1);
        int respuesta2 =palabrasMasUsadas.getIndexPalabra("palabra",palabras);
        assertEquals(1,respuesta2);
        int respuesta3 =palabrasMasUsadas.getIndexPalabra("java",palabras);
        assertEquals(2,respuesta3);
    }
     @Test
    public void palabraNoExisteListaNoVacia(){
        ArrayList<Palabra>palabras=new ArrayList<>();
        palabras.add(new Palabra("texto"));
        palabras.add(new Palabra("palabra"));
        palabras.add(new Palabra("java"));
        PalabrasMasUsadas palabrasMasUsadas=new PalabrasMasUsadas();
        int respuesta =palabrasMasUsadas.getIndexPalabra("factorizar",palabras);
        assertEquals(-1,respuesta);
     }
     
     **/
    
    /**
    @Test
    public void dosPalabrasMasUsadas(){
        String texto="hola mundo,hola java: los un hola hola mundo mundo. java";
        String [] articulos={"la","los","un","de","el","con"};        
        int palabraMasUsadas=2;
        PalabrasMasUsadas masUsadas=new PalabrasMasUsadas();
        ArrayList<Palabra> palabras=masUsadas.getPalabrasMasUsadas(texto,articulos,palabraMasUsadas);
        assertEquals(palabraMasUsadas, palabras.size());
    }**/

    
}