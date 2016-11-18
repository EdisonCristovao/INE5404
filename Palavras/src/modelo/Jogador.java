package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	
	private String nome;
	private List<Letra> letras;
	private List<Letra> letrasTabuleiroParaUsar;
	private int pontuacao;
	
	public Jogador(){
		this.nome = "Player 1";
		this.letras = new ArrayList<Letra>();
		this.letrasTabuleiroParaUsar = new ArrayList<Letra>();
		this.pontuacao = 0;
	}
	
	public List<Letra> getLetrasTabuleiroParaUsar() {
		return letrasTabuleiroParaUsar;
	}

	public void setLetrasTabuleiroParaUsar(List<Letra> letrasTabuleiroParaUsar) {
		this.letrasTabuleiroParaUsar = letrasTabuleiroParaUsar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Letra> getLetras() {
		return letras;
	}

	public void setLetras(ArrayList<Letra> letras) {
		this.letras = letras;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	

}
