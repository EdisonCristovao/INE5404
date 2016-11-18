package modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import excecao.ExcecaoJogadorNaoPossuiLetras;
import interfaces.IntPalavrasCruzadas;

public class PalavrasCruzadas implements IntPalavrasCruzadas {

	private Jogador j1;
	private TabuleiroLetras tabuleiro;
	private SorteaLetras saco;
	private int quantidadeDeLetras = 7;
	private boolean primeiraPalavraExiste = false;
	private boolean terminou;
	private Dicionario dicionario;
	private ArrayList posAdd;

	public PalavrasCruzadas()  {
		j1 = new Jogador();
		tabuleiro = new TabuleiroLetras(10, 10);
		saco = new SorteaLetras();
		terminou = false;
		posAdd = new ArrayList<>();
		try {
			dicionario = new Dicionario();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void adicionaPalavra(List<Letra> listaLetras, int linhaInicial, int colunaInicial, int sentido) throws ExcecaoJogadorNaoPossuiLetras {
		if (listaLetras.size() != 0) {
			if (sentido == 1)
				adicionaPalavraNaHorizontal(listaLetras, linhaInicial, colunaInicial);
			if (sentido == 2)
				adicionaPalavraNaVertical(listaLetras, linhaInicial, colunaInicial);
		} else
			throw new ExcecaoJogadorNaoPossuiLetras();
	}

	public void adicionaPalavraNaVertical(List<Letra> listaLetras, int linhaInicial, int colunaInicial) {

		if (!primeiraPalavraExiste 
				|| (verificaSeExisteLetraNoInvervaloHorizontal(linhaInicial, colunaInicial, listaLetras.size()+1))){
			for (int conti = 0; conti < listaLetras.size(); conti++) {
				if (tabuleiro.getTabuleiro().retorna(linhaInicial, colunaInicial).getCaracter() == '#') {
					tabuleiro.getTabuleiro().insere(linhaInicial++, colunaInicial, listaLetras.get(conti));
					j1.setPontuacao(somarPontos(listaLetras.get(conti)));
					this.primeiraPalavraExiste = true;
				} else {
					linhaInicial++;
					conti--;
				}

			}
		}
	}
	
	public void adicionaPalavraNaHorizontal(List<Letra> listaLetras, int linhaInicial, int colunaInicial) {
		if (!primeiraPalavraExiste
				|| verificaSeExisteLetraNoInvervaloHorizontal(linhaInicial, colunaInicial, listaLetras.size()+1)) {
			for (int conti = 0; conti < listaLetras.size(); conti++) {
				if (tabuleiro.getTabuleiro().retorna(linhaInicial, colunaInicial).getCaracter() == '#') {
					tabuleiro.getTabuleiro().insere(linhaInicial, colunaInicial++, listaLetras.get(conti));
					j1.setPontuacao(somarPontos(listaLetras.get(conti)));
					this.primeiraPalavraExiste = true;
				} else {
					colunaInicial++;
					conti--;
				}
			}
		}
	}
	
	public boolean verificaSeExisteLetraNoInvervaloHorizontal(int linhaInicial, int colunaInicial, int size) {
		for (int conti = 0; conti < size; conti++) {
			if (tabuleiro.getTabuleiro().retorna(linhaInicial, colunaInicial++).getLetra() != '#') {
				return true;
			}
		}
		return false;
	}
	
	public boolean verificaSeExisteLetraNoInvervaloVertical(int linhaInicial, int colunaInicial, int size) {
		for (int conti = 0; conti < size; conti++) {
			if (tabuleiro.getTabuleiro().retorna(linhaInicial++, colunaInicial).getLetra() != '#') {
				return true;
			}
		}
		return false;
	}

	public boolean verificaSeExistePalavraNoDicionarioV(int linhaInicial, int colunaInicial, List<Letra> letras) {
		List<Letra> retornoLetras = new ArrayList<>();
		int pos = 0;
		for (int conti = 0; conti < letras.size(); conti++) {
			if (tabuleiro.getTabuleiro().retorna(linhaInicial, colunaInicial++).getLetra() != '#')
				retornoLetras.add(letras.get(pos++));
			else{
				retornoLetras
						.add(new Letra(tabuleiro.getTabuleiro().retorna(linhaInicial, colunaInicial).getLetra(), 0));
			conti--;
			colunaInicial++;
			}
		}

		return dicionario.existePalavraNoDicionario(retornoLetras);
	}



	public int somarPontos(Letra letra) {

		for (int conti = 0; conti < j1.getLetras().size(); conti++) {
			if (j1.getLetras().get(conti).getLetra().equals(letra.getLetra())) {
				int pontos = j1.getPontuacao() + j1.getLetras().get(conti).getValor();
				removerLetraDoUsuario(conti);
				return pontos;
			}
		}
		return 0;
	}

	public void removerLetraDoUsuario(int pos) {
		j1.getLetras().remove(pos);
	}

	public List<Letra> retornaLetrasDaPalavra(String palavra) {
		char[] letraDaPalavra = palavra.toCharArray();
		List<Letra> letras = new ArrayList<Letra>();
		for (int conti = 0; conti < palavra.length(); conti++)
			letras.add(new Letra((Character) letraDaPalavra[conti], 0));

		for (int conti = 0; conti < letras.size(); conti++) {
			if (!(jogadorPossuiLetra(letras.get(conti)))) {
				return null;
			}
		}
		return letras;
	}

	public boolean jogadorPossuiLetra(Letra letra) {
		for (int conti = 0; conti < j1.getLetras().size(); conti++) {
			if (j1.getLetras().get(conti).getLetra().equals(letra.getLetra()))
				return true;
		}
		return false;
	}

	public void pegaLetras() {
		for (int conti = j1.getLetras().size(); conti < this.quantidadeDeLetras; conti++) {
			j1.getLetras().add(saco.criaEstrategia(saco.getTipo()).tiraLetraDoSaco());
		}
	}

	@Override
	public List<Letra> letrasDisponiveis() {
		return j1.getLetras();
	}

	@Override
	public int pontuacao() {
		return j1.getPontuacao();
	}

	@Override
	public void encerra() {
		this.terminou = true;
	}

	@Override
	public boolean terminou() {
		return this.terminou;
	}

	@Override
	public TabuleiroLetras retornaTabuleiro() {
		return this.tabuleiro;
	}

	public Jogador getJ1() {
		return j1;
	}

	public SorteaLetras getSaco() {
		return this.saco;
	}

	public void setTerminou(boolean terminou) {
		this.terminou = terminou;
	}

	public void novoJogo() {
		j1 = new Jogador();
		tabuleiro = new TabuleiroLetras(10, 10);
		setTerminou(true);
	}

	public void setQuantidadeDeLetras(int quantidadeDeLetras) {
		this.quantidadeDeLetras = quantidadeDeLetras;

	}

	public void setDimensao(int linhas, int colunas) {
		tabuleiro = new TabuleiroLetras(linhas, colunas);
	}

	public void setPrimeiraPalavraExiste(boolean primeiraPalavraExiste) {
		this.primeiraPalavraExiste = primeiraPalavraExiste;
	}

}
