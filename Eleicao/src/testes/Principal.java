package testes;

import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;

public class Principal {

	public static void main(String[] args) {

		FachadaCartorioEleitoral cartorio = new FachadaCartorioEleitoral();
		try {
			cartorio.cadastraZonaEleitoral(101, "sao jose");
			cartorio.cadastraZonaEleitoral(101, "sao jose");//gera erro	
			System.out.println("Numero de zonas eleitorais é " + cartorio.getNumeroDeZonas());
		} catch (ExcecaoZonaEleitoralExistente e) {
			e.printStackTrace();
		}
		// cartorio.cadastraZonaEleitoral(101, "sao jose");
		// System.out.println("Numero de zonas eleitorais é "+
		// cartorio.getNumeroDeZonas());

		//cartorio.cadastroSecao(10, cartorio.getZona(101));
		System.out.println("numero de secoes é :" + cartorio.getNumeroDeSecoes());
		//cartorio.cadastroSecao(10, cartorio.getZona(101));
		System.out.println("numero de secoes é :" + cartorio.getNumeroDeSecoes());
	}

}
