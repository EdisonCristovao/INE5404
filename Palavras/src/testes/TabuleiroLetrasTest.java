package testes;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoPosForaDoTabuleiro;
import modelo.Letra;
import modelo.TabuleiroLetras;

public class TabuleiroLetrasTest {
	TabuleiroLetras tabu;
	
	@Before
	public void setUp() throws Exception {
	tabu = new TabuleiroLetras(10, 10);
	}

	@Test
	public void mostraTabuleiro() {
		System.out.println(tabu.mostraTabuleiro());
	}

	@Test(expected=ExcecaoPosForaDoTabuleiro.class)
	public void trocaLetraForaDotabuleiro() throws ExcecaoPosForaDoTabuleiro {
		Letra letra1 = new Letra();
		letra1.setLetra('A');
		System.out.println(tabu.numeroColunas());
		tabu.setLetraNoTabuleiro(1, 20, letra1);
	}
	
	@Test
	public void trocaLetra() throws ExcecaoPosForaDoTabuleiro {
		Letra letra = new Letra();
		letra.setLetra('A');
		tabu.setLetraNoTabuleiro(2, 2, letra);
		System.out.println(tabu.mostraTabuleiro());
	}

}
