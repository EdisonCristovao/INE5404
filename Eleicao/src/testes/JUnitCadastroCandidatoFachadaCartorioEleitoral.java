package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import excecao.ExcecaoCandidatoVereadorExistente;
import modelo.FachadaCartorioEleitoral;


public class JUnitCadastroCandidatoFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastroPartido("psdb", "essa osta");
		cartorio.cadastroPartido("psdbb", "Porra mesmo");
		
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraSecao(101);
		cartorio.cadastraEleitor(888, "ele mesmo", 82821, cartorio.getSecao(101,1), "teste", "poowww");
		cartorio.cadastraEleitor(881, "ele mesmo", 82821, cartorio.getSecao(101,1), "teste", "poowww");
		
		
	}

	@Test
	public void cadastra2CandidatoVereador() throws ExcecaoCandidatoVereadorExistente {
			cartorio.cadastroCandidatoVereador(1 ,cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdb"));
			assertEquals(1, cartorio.getPartido("psdb").getCandidatosVereadores().size());
			cartorio.cadastroCandidatoVereador(1 ,cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdb"));
			assertEquals(2, cartorio.getPartido("psdb").getCandidatosVereadores().size());
	}	
	@Test
	public void cadastraCandidatoVereador() throws ExcecaoCandidatoVereadorExistente {
			cartorio.cadastroCandidatoVereador(1 ,cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdb"));
			assertEquals(1, cartorio.getPartido("psdb").getCandidatosVereadores().size());
	}	
	
	@Test
	public void cadastraCandidatoVereadorEmPartidosDiferentes() throws ExcecaoCandidatoVereadorExistente {
	//verificar esse caso, mesmo candidato em 2 partidos
			cartorio.cadastroCandidatoVereador(1 ,cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdb"));
			cartorio.cadastroCandidatoVereador(1 ,cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdbb"));
			assertEquals(1, cartorio.getPartido("psdb").getCandidatosVereadores().size());
			assertEquals(1, cartorio.getPartido("psdbb").getCandidatosVereadores().size());
	}	
	
	public void cadastraCandidatoPrefeito(){
			cartorio.cadastroPrefeito(1, cartorio.getEleitorPorCpf(888), cartorio.getPartido("psdb"));
	}

}
