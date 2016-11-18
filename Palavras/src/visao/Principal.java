package visao;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import modelo.PalavrasCruzadas;

public class Principal {
	static PalavrasCruzadas jogo = new PalavrasCruzadas();
	static InJogo in = new InJogo();
	static OutJogo out = new OutJogo(jogo);

	public static void main(String[] args) throws FileNotFoundException {
		JOptionPane.showMessageDialog(null, "Bem vindo ao jogo de palavras");
		Principal principal = new Principal();
		principal.menuJogo();

	}

	public void jogandoJogo() {
		jogo.setTerminou(false);
		int op = 0;

		while (op != 9) {

			op = Integer.parseInt(JOptionPane
					.showInputDialog(out.menuPrincipal() + out.interfaceBasicaDoJogo() + "\nEscolha a opçao:"));

			switch (op) {
			case 1:
				jogo.pegaLetras();

				break;
			case 2:
				String palavra = JOptionPane.showInputDialog(out.interfaceBasicaDoJogo()).toUpperCase();
				try {
					jogo.adicionaPalavra(jogo.retornaLetrasDaPalavra(palavra),
							Integer.parseInt(
									JOptionPane.showInputDialog(out.mostraTabuleiro() + "\nDigite numero da linha!")),
							Integer.parseInt(
									JOptionPane.showInputDialog(out.mostraTabuleiro() + "\nDigite numero da coluna!")),
							in.pegaDirecao());
				} catch (Exception e) {
					System.out.println(out.mostraErroAdicionarPalavra());
				}
				break;
			case 9:
				JOptionPane.showMessageDialog(null, out.finalizaJogo());
				jogo.novoJogo();
				jogo.setPrimeiraPalavraExiste(false);
				break;
			default:

				break;
			}
		}

	}

	public void menuJogo() {

		int op = 0;
		while (op != 9) {

			op = Integer.parseInt(JOptionPane.showInputDialog(out.menuPrincipalJogo()));

			switch (op) {
			case 1:
				JOptionPane.showMessageDialog(null, "Jogo modo Normal\nTabuleiro 10x10");
				jogandoJogo();
				break;
			case 2:
				menuConfig();
				break;
			case 3:

				break;

			default:

				break;
			}
		}
	}

	public void menuConfig() {

		int op = 0;
		while (op != 9) {

			op = Integer.parseInt(JOptionPane.showInputDialog(out.menuConfig()));

			switch (op) {
			case 1:
				jogo.getJ1().setNome(in.pegaNomeDoJogador());
				break;
			case 2:
				jogo.setDimensao(in.pegaNumeroDeLinhas(), in.pegaNumeroDeColunas());
				break;
			case 3:
				int tipo = Integer.parseInt(JOptionPane.showInputDialog(out.menuDificuldade()));
				jogo.getSaco().setTipo(tipo);
				break;
			case 4:
				jogo.setQuantidadeDeLetras(in.quantidadeDeLetra());
				break;

			default:

				break;
			}
		}

	}
}
