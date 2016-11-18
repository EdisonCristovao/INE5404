package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import modelo.Dicionario;
import modelo.Letra;

public class DicionarioTest {

	Dicionario dicionario;
	@Before
	public void setUp() throws Exception {
		dicionario = new Dicionario();
	}

	@Test
	public void retornaPalavra() {
		List<Letra> lista = new ArrayList<Letra>();
		Letra l1 = new Letra('A', 0);
		Letra l2 = new Letra('B', 0);
		Letra l3 = new Letra('C', 0);
		Letra l4 = new Letra('D', 0);
		lista.add(l1);
		lista.add(l2);
		lista.add(l3);
		lista.add(l4);
		assertEquals("ABCD", dicionario.converteEmPalavra(lista));
	}
	
	@Test
	public void VerificaSeExisteNoDicionario() {
		List<Letra> lista = new ArrayList<Letra>();
		Letra l1 = new Letra('A', 0);
		Letra l2 = new Letra('B', 0);
		Letra l3 = new Letra('C', 0);
		Letra l4 = new Letra('D', 0);
		lista.add(l1);
		lista.add(l2);
		lista.add(l3);
		lista.add(l4);
		assertEquals(true, dicionario.existePalavraNoDicionario(lista));
	}

}
