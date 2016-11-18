package visao;


import modelo.PalavrasCruzadas;

public class OutJogo {
	PalavrasCruzadas jogo;

	public OutJogo(PalavrasCruzadas jogo) {
		this.jogo = jogo;
	}

	public String menuPrincipalJogo() {
		String retorno = "Scrible\n";
		retorno += "1-Iniciar\n";
		retorno += "2-Configuração\n";
		retorno += "9-sair\n";
		return retorno;
	}
	public String mostraTabuleiro() {
		String retorno = jogo.retornaTabuleiro().mostraTabuleiro();
		return retorno;
	}	
	public String interfaceBasicaDoJogo() {
		String retorno = "\nTabuleiro das palavras";
		retorno += jogo.retornaTabuleiro().mostraTabuleiro();
		retorno += "\n\n";
		
		if (jogo.getJ1().getLetras().size() != 0) {
			retorno += "Suas letras\n";
			retorno += jogo.getJ1().getLetras()+"\n";

		}
		retorno += mostraEstatistica();
	
		return retorno;
	}

	public String menuPrincipal() {
		String retorno = "";
		retorno += "1 - Pedir letras\n";

		retorno += "2 - Tentar Palavra\n";
		
		retorno += "9 - Terminar jogo\n";

		return retorno;
	}

	public String mostraErroAdicionarPalavra() {
		String mostraErro = "Erro ao adicionar palavra";
		return mostraErro;
	}
	
	public String mostraEstatistica() {
		String mostraErro = "Nome: "+ jogo.getJ1().getNome()+"\n"
				+ "Pontos: "+ jogo.getJ1().getPontuacao()+"\n";
		return mostraErro;
	}

	public String finalizaJogo() {
		String retorno = mostraEstatistica();
		return retorno;
	}

	public String menuConfig() {
		String retorno = "";
		retorno += "1 - Mudar nome\n";
		retorno += "2 - Mudar dimenção do tabuleiro\n";
		retorno += "3 - Mudar dificuldade\n";
		retorno += "4 - Mudar quantidade de letra\n";

		retorno += "9 - Sair\n";
		return retorno;
	}
	
	public String menuDificuldade() {
		String retorno = "";
		retorno += "1 - normal\n";
		retorno += "2 - Dificil\n";
		return retorno;
	}
	

}
