package modelo;

import excecao.ExcecaoPosForaDoTabuleiro;

public class TabuleiroLetras implements interfaces.IntTabuleiroLetras {

	private Grade<Letra> tabuleiro;

	public TabuleiroLetras(int linhas, int colunas){
		criaTabuleiro(linhas, colunas);
		prencheGrade();
	}
	
	public void prencheGrade(){
		for (int conti = 1; conti <= numeroLinhas(); conti++) {
			for (int contj = 1; contj <= numeroColunas(); contj++) {
				tabuleiro.insere(conti, contj, new Letra());
			}
		}
	}
	public Grade<Letra> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Grade<Letra> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void criaTabuleiro(int linhas, int colunas) {
		tabuleiro = new Grade<Letra>(linhas, colunas);
	}

	@Override
	public Letra retornaLetraNaPosicao(int linha, int coluna) {
		return this.tabuleiro.retorna(linha, coluna);
	}

	@Override
	public int numeroLinhas() {
		return this.tabuleiro.retornaNumLinhas();
	}

	@Override
	public int numeroColunas() {
		return this.tabuleiro.retornaNumColunas();
	}

	public void setLetraNoTabuleiro(int linha, int coluna, Letra letra) throws ExcecaoPosForaDoTabuleiro {
		if (linha <= numeroLinhas() && coluna <= numeroColunas()) {
			// this.tabuleiro.(linha - 1).set(coluna - 1, letra);
		} else {
			throw new ExcecaoPosForaDoTabuleiro();

		}
	}
	

	public String mostraTabuleiro() {
		String tabuleiro = "";
		tabuleiro += getTabuleiro();
		return tabuleiro;
	}



}
