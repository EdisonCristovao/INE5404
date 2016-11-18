package testes;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoJogadorNaoPossuiLetras;
import modelo.PalavrasCruzadas;

public class PalavrasCruzadasTest {

	PalavrasCruzadas palavrasCruzadas;

	@Before
	public void setUp() throws Exception {
		palavrasCruzadas = new PalavrasCruzadas();
	}

	public void adicionaPalavra() throws Exception {
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro());
		palavrasCruzadas.adicionaPalavra(palavrasCruzadas.retornaLetrasDaPalavra("ABC"), 1,1, 1);
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro());
	}

	@Test
	public void escolheLetra() {
		System.out.println(palavrasCruzadas.retornaLetrasDaPalavra("TESTE"));
	}
	
	@Test
	public void tiraLetrasDoSaco() {

		System.out.println(palavrasCruzadas.getJ1().getLetras());
		palavrasCruzadas.pegaLetras();

		System.out.println(palavrasCruzadas.getJ1().getLetras());
	}
	
	@Test
	public void verificaPalavraExiste() throws ExcecaoJogadorNaoPossuiLetras {
		Scanner scan = new Scanner(System.in);
		palavrasCruzadas.pegaLetras();
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro()+palavrasCruzadas.getJ1().getLetras());
		String palavra = scan.nextLine();
		palavrasCruzadas.adicionaPalavra(palavrasCruzadas.retornaLetrasDaPalavra(palavra), 1, 1, 2);
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro()+palavrasCruzadas.getJ1().getLetras());
	}
	public void adicionaPalavraVertical() throws ExcecaoJogadorNaoPossuiLetras {
		Scanner scan = new Scanner(System.in);
		palavrasCruzadas.pegaLetras();
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro()+palavrasCruzadas.getJ1().getLetras());
		String palavra = scan.nextLine();
		palavrasCruzadas.adicionaPalavra(palavrasCruzadas.retornaLetrasDaPalavra(palavra), 1, 1, 2);
		System.out.println(palavrasCruzadas.retornaTabuleiro().mostraTabuleiro()+palavrasCruzadas.getJ1().getLetras());
	}
	
}
