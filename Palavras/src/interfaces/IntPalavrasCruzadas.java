package interfaces;

import java.util.List;

import modelo.Letra;

public interface IntPalavrasCruzadas {
	
	public void adicionaPalavra (List<Letra> listaLetras, int linhaInicial, int colunaInicial, int direcao) throws Exception;
	public List<Letra> letrasDisponiveis();
	public int pontuacao();
	public void encerra();
	public boolean terminou();
	public IntTabuleiroLetras retornaTabuleiro();
}
