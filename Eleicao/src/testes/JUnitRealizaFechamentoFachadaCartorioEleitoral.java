package testes;


import org.junit.Before;
import org.junit.Test;

import modelo.FachadaCartorioEleitoral;

public class JUnitRealizaFechamentoFachadaCartorioEleitoral {

	FachadaCartorioEleitoral cartorio;

	@Before
	public void setUp() throws Exception {
		cartorio = new FachadaCartorioEleitoral();
		cartorio.cadastraZonaEleitoral(101, "sao jose");
		cartorio.cadastraZonaEleitoral(102, "jose");
		cartorio.cadastraSecao(101);// sessao 1
		cartorio.cadastraSecao(101);// sessao 2
		cartorio.cadastraEleitor(111, "Nego Drama", 1111, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(222, "Carinha que mora logo ali", 2222, cartorio.getSecao(101, 2), "teste", "poowww");
		cartorio.cadastraEleitor(333, "Tamo junto", 3333, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(444, "Ate que ta dando certo", 4444, cartorio.getSecao(101, 2), "teste", "poowww");
		cartorio.cadastraEleitor(555, "Nossa quanto nome", 5555, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(666, "Mais 1", 6666, cartorio.getSecao(101, 2), "teste", "poowww");
		cartorio.cadastraEleitor(777, "Parece que nao acaba", 7777, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastraEleitor(888, "ele mesmo", 8888, cartorio.getSecao(101, 2), "teste", "poowww");
		cartorio.cadastraEleitor(999, "ele mesmo", 9999, cartorio.getSecao(101, 1), "teste", "poowww");
		cartorio.cadastroPartido("PT", "Puta treta");

		cartorio.cadastroPrefeito(3, cartorio.getEleitorPorTitulo(1111), cartorio.getPartido("PT"));
		cartorio.cadastroPrefeito(5, cartorio.getEleitorPorTitulo(3333), cartorio.getPartido("PT"));
		cartorio.cadastroCandidatoVereador(12, cartorio.getEleitorPorCpf(444), cartorio.getPartido("PT"));
		cartorio.cadastroCandidatoVereador(22, cartorio.getEleitorPorCpf(666), cartorio.getPartido("PT"));
		cartorio.abreEleicao();
	}

	@Test
	public void realizaVoto() {

		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(1111), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(2222), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(3333), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(22));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(4444), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(5555), cartorio.getCandidatoPrefeitoPorNumero(3),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(6666), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(7777), cartorio.getCandidatoPrefeitoPorNumero(3),
				cartorio.getCandidatoVereadorPorNumero(22));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(8888), cartorio.getCandidatoPrefeitoPorNumero(5),
				cartorio.getCandidatoVereadorPorNumero(12));
		cartorio.realizaVoto(cartorio.getEleitorPorTitulo(9999), cartorio.getCandidatoPrefeitoPorNumero(3),
				cartorio.getCandidatoVereadorPorNumero(12));

		cartorio.fechaEleicao();

		
		//ArrayList<CandidatoVereador> candidatos = cartorio.candidatosVereadorresMaisVotados();
		//System.out.println(candidatos.size());
		System.out.println(cartorio.estatisticaPrimeiroTurno());
		
		System.out.println(cartorio.getCandidatoVereadorPorNumero(12).getNumDeVotos());
		System.out.println(cartorio.getCandidatoVereadorPorNumero(22).getNumDeVotos());
		System.out.println(cartorio.getCandidatoPrefeitoPorNumero(5).getNumDeVotos());
		System.out.println(cartorio.getCandidatoPrefeitoPorNumero(3).getNumDeVotos());
	}

}
