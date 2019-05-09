package lab03;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *  
 * @author Raiany Rufino - 118110466
 *
 */
public class ContatoTest {

    Contato contato, outroContato;

    @Test(expected = IllegalArgumentException.class)
    public void testNomeInvalido() {
        contato = new Contato("", "zoro", "00000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSobrenomeInvalido() {
        contato = new Contato("roronoa", "   ", "000000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTelefoneInvalido() {
        contato = new Contato("roronoa", "zoro", "  ");
    }

    @Test(expected = NullPointerException.class)
    public void testNomeNulo() {
        contato = new Contato(null, "roronoa", "00000000");
    }

    @Test(expected = NullPointerException.class)
    public void testSobrenomeNulo() {
        contato = new Contato("zoro", null, "00000000");
    }

    @Test(expected = NullPointerException.class)
    public void testTelefoneNulo() {
        contato = new Contato("roronoa", "zoro", null);
    }

    @Test
    public void testContatosIguais() {
        contato = new Contato("roronoa", "zoro", "0800");
        outroContato = new Contato("roronoa", "zoro", "0800");
        assertTrue(contato.equals(outroContato));
    }

    @Test
    public void testContatosDiferentes() {
        contato = new Contato("chopper", "hihi", "0800");
        outroContato = new Contato("luffy", "hihi", "0800 777 7000");
        assertFalse(contato.equals(outroContato));
    }

    @Test
    public void testHashCodeIgual() {
        contato = new Contato("Mihawk", "olhos de falcao", "111111111");
        outroContato = new Contato("Mihawk", "olhos de falcao", "111111111");
        assertEquals(contato.hashCode(), outroContato.hashCode());
    }

    @Test
    public void testHashCodeDiferente() {
        contato = new Contato("chapeu", "de palha", "00009");
        outroContato = new Contato("luffy", "chapeu de palha", "00009");
        assertNotEquals(contato.hashCode(), outroContato.hashCode());
    }

    @Test
    public void testToString() {
        contato = new Contato("abc", "def", "123");
        assertEquals("abc def - 123", contato.toString());
}
}
