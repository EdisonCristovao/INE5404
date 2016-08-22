package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroPartidoFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
	}

	@Test
	public void testCadastroPartido() {
		try {
			cartorio.cadastroPartido("PT", "Puta treta");
			assertEquals(1, cartorio.getNumDePartidos());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}
	}
	
	@Test
	public void testCadastro2Partido() {
		try {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PTT", "Puta treta Tretando");
			assertEquals(2, cartorio.getNumDePartidos());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}
	}
	
	@Test
	public void testCadastroPartidoComNomeIgual() {
		try {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PT", "Pixxx");
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.getNumDePartidos());
		}
	}
	
	@Test
	public void testCadastroPartidosIguais() {
		try {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PT", "Puta treta");
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.getNumDePartidos());
		}
	}

}
