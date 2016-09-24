package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoEleitorExistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroEleitorFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;
	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraZonaEleitoral(102, "jose");
		cartorio.cadastraSecao(101);
		cartorio.cadastraSecao(102);
	}

	@Test
	public void testCadastraEleitor() throws ExcecaoEleitorExistente {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecao(101, 1), "teste", "poowww");
			assertEquals(1, cartorio.getSecao(101, 1).getEleitores().size());

	}
	@Test
	public void testCadastra2EleitorDiferentes() throws ExcecaoEleitorExistente {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecao(101, 1), "teste", "poowww");
			cartorio.cadastraEleitor(884, "ela mesmo", 123123, cartorio.getSecao(101, 1), "shajd", "Àwwww");
			assertEquals(2, cartorio.getSecao(101, 1).getEleitores().size());

	}
	@Test (expected= ExcecaoEleitorExistente.class)
	public void testCadastra2EleitorApenasCpfIgual() throws ExcecaoEleitorExistente {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecao(101, 1), "teste", "poowww");
			cartorio.cadastraEleitor(888, "ela mesmo", 123123, cartorio.getSecao(101, 1), "shajd", "Àwwww");
			assertEquals(1, cartorio.getSecao(101, 1).getEleitores().size());

	}
}
