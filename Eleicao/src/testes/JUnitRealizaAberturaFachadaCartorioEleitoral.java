package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelo.FachadaCartorioEleitoral;


public class JUnitRealizaAberturaFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraZonaEleitoral(102, "jose");
		cartorio.cadastraSecao(101);//sessao 1
		cartorio.cadastraSecao(101);//sessao 2		
		cartorio.cadastraEleitor(123, "ele mesmo", 1234, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(234, "ele mesmo", 2344, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(567, "ele mesmo", 5674, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastroPartido("PT", "Puta treta");
		cartorio.cadastroCandidatoVereador(12, cartorio.getEleitorPorTitulo(1234), cartorio.getPartido("PT"));
		cartorio.cadastroPrefeito(55, cartorio.getEleitorPorTitulo(2344), cartorio.getPartido("PT"));
		cartorio.cadastroCandidatoVereador(22, cartorio.getEleitorPorTitulo(5674), cartorio.getPartido("PT"));
		cartorio.abreEleicao();
	}

	@Test
	public void realizaVoto() {
				
		cartorio.realizaVoto(cartorio.getEleitorPorCpf(123), cartorio.getCandidatoPrefeitoPorNumero(55), cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorCpf(234), cartorio.getCandidatoPrefeitoPorNumero(55), cartorio.getCandidatoVereadorPorNumero(22));
		System.out.println(cartorio.getCandidatoPrefeitoPorNumero(55).getNumDeVotos());
		System.out.println(cartorio.getCandidatoVereadorPorNumero(22).getNumDeVotos());
	}	

}
