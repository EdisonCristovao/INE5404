package visao;

import javax.swing.JOptionPane;

public class InJogo {

	public String pegaNomeDoJogador() {
		return JOptionPane.showInputDialog("Digite seu nome!");
	}

	public int pegaNumeroDeLinhas() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite numero de linhas!"));
	}

	public int pegaNumeroDeColunas() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite numero de colunas!"));
	}

	public int pegaNumeroDaLinhaInicial() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite numero da linha!"));
	}

	public int pegaNumeroDaColunaInicial() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Coluna!"));
	}

	public int pegaDirecao() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite numero da direção \n1-Horizontal\n2-vertical"));
	}

	public int quantidadeDeLetra() {
		return Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de letras que o usuario vai usar!"));
	}

}
