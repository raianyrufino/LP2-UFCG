package lab03;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Raiany Rufino - 118110466
 *
 */
class AgendaTest {
	Agenda agenda, outraAgenda;

	@BeforeEach
	public void criaAgenda() {
		agenda = new Agenda();
		outraAgenda = new Agenda();
	}
	
	@Test
	public void testBuscaContato() {
		agenda.cadastraContato("Alasca", "Young", "083 93282335", 2);
		assertEquals(("Alasca Young - 083 93282335"), agenda.buscaContato(2));
	}

	@Test
	public void testCadastroValido() {
		assertEquals("Cadastro realizado com sucesso!", agenda.cadastraContato("Imortal", "punho de ferro", "99002078", 1));
		assertEquals("Cadastro realizado com sucesso!", agenda.cadastraContato("Matthew", "Murdock", "98019843", 10));
	}

	@Test
	public void testCadastraPosiçãoInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.cadastraContato("Gomu gomu", "no mi", "4002-8922", -50));
		assertEquals("POSIÇÃO INVÁLIDA!", agenda.cadastraContato("Gomu gomu", "no mi", "4002-8922", 500));
	}

	@Test
	public void testListaContatos() {
		agenda.cadastraContato("aaa", "bbb", "0800 1111 1111", 2);
		assertEquals("2 - aaa bbb\n", agenda.listaContatos());
		agenda.cadastraContato("Boku", "no Hero", "9 9999-9999", 3);
		assertEquals("2 - aaa bbb\n3 - Boku no Hero\n", agenda.listaContatos());
	}

	@Test
	public void testAgendasIguais() {
		agenda.cadastraContato("Doutora", "Edelly", "0800 777 7000", 2);
		outraAgenda.cadastraContato("Doutora", "Edelly", "0800 777 7001", 2);
		assertTrue(agenda.equals(outraAgenda));
	}

	@Test
	public void testAgendasDiferentes() {
		agenda.cadastraContato("Quelzinha", "Quel", "0800 0000 0000", 2);
		outraAgenda.cadastraContato("Que", "Quel", "0800 0000 0000", 2);
		assertFalse(agenda.equals(outraAgenda));
	}

	@Test
	public void testHashCodeIgual() {
		agenda.cadastraContato("abc", "def", "123", 2);
		outraAgenda.cadastraContato("abc", "def", "789", 2);
		assertEquals(agenda.hashCode(), outraAgenda.hashCode());
	}

	@Test
	public void testHashCodeDiferente() {
		agenda.cadastraContato("Haha", "Hehe", "000111000", 2);
		outraAgenda.cadastraContato("Hihi", "Huhu", "0101010101", 2);
		assertNotEquals(agenda.hashCode(), outraAgenda.hashCode());
	}
}