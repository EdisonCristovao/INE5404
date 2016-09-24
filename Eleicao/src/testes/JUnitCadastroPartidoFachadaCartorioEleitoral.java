package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoPartidoEleitoralExistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroPartidoFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
	}

	@Test
	public void testCadastroPartido() throws ExcecaoPartidoEleitoralExistente {
			cartorio.cadastroPartido("PT", "Puta treta");
			assertEquals(1, cartorio.getNumDePartidos());
	}
	
	@Test
	public void testCadastro2Partido() throws ExcecaoPartidoEleitoralExistente {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PTT", "Puta treta Tretando");
			assertEquals(2, cartorio.getNumDePartidos());
	}
	
	@Test(expected = ExcecaoPartidoEleitoralExistente.class)
	public void testCadastroPartidoComNomeIgual() throws ExcecaoPartidoEleitoralExistente {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PT", "Pixxx");
	}
	
	@Test(expected = ExcecaoPartidoEleitoralExistente.class)
	public void testCadastroPartidosIguais() throws ExcecaoPartidoEleitoralExistente {
			cartorio.cadastroPartido("PT", "Puta treta");
			cartorio.cadastroPartido("PT", "Puta treta");
	}

}
