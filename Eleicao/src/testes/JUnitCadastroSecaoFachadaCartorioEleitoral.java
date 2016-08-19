package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;

public class JUnitCadastroSecaoFachadaCartorioEleitoral {
	
	FachadaCartorioEleitoral cartorio;
	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraZonaEleitoral(102, "Iguais");
	}

	@Test
	public void testCadastroSecao() {
		try {
			cartorio.cadastroSecao(10, cartorio.getZona(101));
			assertEquals(1, cartorio.getNumeroDeSecoes());	
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}
	}

	@Test
	public void testCadastro2Secoes() {
		try {
			cartorio.cadastroSecao(10, cartorio.getZona(101));
			cartorio.cadastroSecao(11, cartorio.getZona(101));	
			assertEquals(2, cartorio.getNumeroDeSecoes());	
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}
	}
	
	@Test
	public void testCadastro2SecoesIguais() {
		try {
			cartorio.cadastroSecao(10, cartorio.getZona(101));
			cartorio.cadastroSecao(10, cartorio.getZona(101));	
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.getNumeroDeSecoes());
		}
	}
	
	@Test
	public void testCadastro2SecoesIguaisEmZonasDiferentes() {
		try {
			cartorio.cadastroSecao(10, cartorio.getZona(101));
			cartorio.cadastroSecao(10, cartorio.getZona(102));	
			assertEquals(2, cartorio.getNumeroDeSecoes());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
			
		}
	}
}
