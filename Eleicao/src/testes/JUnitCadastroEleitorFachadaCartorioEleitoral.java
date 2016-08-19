package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroEleitorFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;
	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastroSecao(10, cartorio.getZona(101));
	}

	@Test
	public void testCadastraEleitor() {
		try {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecaoPorNumero(10), "teste", "poowww");
			assertEquals(1, cartorio.getNumeroDeEleitores());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}

	}
	@Test
	public void testCadastra2EleitorDiferentes() {
		try {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecaoPorNumero(10), "teste", "poowww");
			cartorio.cadastraEleitor(884, "ela mesmo", 123123, cartorio.getSecaoPorNumero(10), "shajd", "Àwwww");
			assertEquals(2, cartorio.getNumeroDeEleitores());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}

	}
	@Test
	public void testCadastra2EleitorApenasCpfIgual() {
		try {
			cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecaoPorNumero(10), "teste", "poowww");
			cartorio.cadastraEleitor(888, "ela mesmo", 123123, cartorio.getSecaoPorNumero(10), "shajd", "Àwwww");
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.getNumeroDeEleitores());
		}

	}
	
	
	

}
