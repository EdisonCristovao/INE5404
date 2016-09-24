package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoZonaEleitoralInezistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroSecaoFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;
	JUnitCadastroZonaFachadaCartorioEleitoral j1;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraZonaEleitoral(102, "Iguais");
	}

	@Test
	public void testCadastroSecao() throws ExcecaoZonaEleitoralInezistente {
			cartorio.cadastraSecao(101);
			assertEquals(1, cartorio.numeroDeSecoes(101));			
	}

	@Test
	public void testCadastro2Secoes() throws ExcecaoZonaEleitoralInezistente {
			cartorio.cadastraSecao(101);
			cartorio.cadastraSecao(101);
			assertEquals(2, cartorio.getZona(101).getSecoes().size());
	}

	@Test
	public void testCadastro2SecoesEmZonasDiferentes() throws ExcecaoZonaEleitoralInezistente {
			cartorio.cadastraSecao(101);
			cartorio.cadastraSecao(102);
			assertEquals(1, cartorio.getZona(101).getSecoes().size());
			assertEquals(1, cartorio.getZona(102).getSecoes().size());

	}

}
