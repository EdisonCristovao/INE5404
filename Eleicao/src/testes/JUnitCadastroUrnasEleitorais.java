package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;
import modelo.Zona;

public class JUnitCadastroUrnasEleitorais {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
	}

	@Test
	public void testCadastraZonaEleitoral() {
		try {
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}

	}

	@Test
	public void testCadastra2ZonasEleitorais() {
		try {
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		}
	}

	@Test
	public void testCadastra2ZonasEleitoraisComLocaisDiferentes() {
		try {
			cartorio.cadastraZonaEleitoral(101, "Biguaçu");
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			fail();
		} catch (ExcecaoZonaEleitoralExistente e) {
			assertEquals(1, cartorio.numeroDeZonasEleitorais());
		}
	}

	@Test
	public void testCadastra2ZonasEleitoraisComNumeroDiferente() {
		try {
			cartorio.cadastraZonaEleitoral(102, "sao jose");
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			assertEquals(2, cartorio.numeroDeZonasEleitorais());
		} catch (ExcecaoZonaEleitoralExistente e) {
			fail();
		}
	}

}
