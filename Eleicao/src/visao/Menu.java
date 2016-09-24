package visao;

import java.io.IOException;

import javax.swing.JOptionPane;

import excecao.ExcecaoCandidatoVereadorExistente;
import excecao.ExcecaoEleitorExistente;
import excecao.ExcecaoPartidoEleitoralExistente;
import excecao.ExcecaoZonaEleitoralExistente;
import modelo.FachadaCartorioEleitoral;
import modelo.Serializar;

public class Menu {

	static Serializar s1 = new Serializar();
	static FachadaCartorioEleitoral c1;
	InputCadastra cadastra = new InputCadastra(c1);
	OutLista o1 = new OutLista(c1);
	

	public static void main(String[] args) throws IOException, Exception {
		c1 = s1.carregaFachada("arquivo");
		Menu menu = new Menu();
		menu.menuPrimario();

	}

	public void menuPrimario() throws ExcecaoZonaEleitoralExistente, ExcecaoEleitorExistente,
			ExcecaoPartidoEleitoralExistente, ExcecaoCandidatoVereadorExistente {
		int op = 0;

		JOptionPane.showMessageDialog(null, "Cartorio Eleitoral V1.3");
		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Cartorio Eleitoral\n" + "Ecolha a opçao desejada.\n"
					+ "1-Cadastrar Zona Eleitoral\n" + "2-Cadastrar Secao Eleitoral\n" + "3-Cadastrar Eleitor\n"
					+ "4-Cadastrar Partido\n" + "5-Cadastrar Candidato Vereador\n" + "6-Cadastrar candidato Prefeito\n"
					+ "7-Eleicao\n" + "8-Listar\n" + "9-Sair"));

			switch (op) {
			case 1:
				cadastra.cadastraZona();
				break;
			case 2:
				cadastra.cadastraSecao();
				break;
			case 3:
				cadastra.cadastraEleitor();
				break;
			case 4:
				cadastra.cadastraPartido();
				break;
			case 5:
				cadastra.cadastraCandidatoVereador();
				break;
			case 6:
				cadastra.cadastraCandidatoPrefeito();
				break;
			case 7:
				menuTerciario();
				break;
			case 8:
				menuSecundario();
				op = 0;
				break;
			case 9:
				try {
					s1.salvaFachada(c1, "arquivo");
				} catch (IOException e) {
					System.out.println("erro ao serializar");
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite um valor valido");
				break;

			}
		}

	}

	public void menuSecundario() {

		int op = 0;

		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Listar Dados\n" + "Ecolha a opçao desejada.\n"
					+ "1-Listar Zonas Eleitorais\n" + "2-Listar Secoes Eleitorais\n" + "3-Listar Eleitores\n"
					+ "4-Listar Partidos\n" + "5-Listar Candidatos a Vereador\n" + "6-Listar Candidato a prefeito\n"
					+ "7-Lista Urnas\n" + "9-Voltar"));

			switch (op) {
			case 1:
				o1.listaZona();
				break;
			case 2:
				o1.listaSecao();
				break;
			case 3:
				o1.listaEleitor();
				break;
			case 4:
				o1.listaPartido();
				break;
			case 5:
				o1.listaCandidatoVereador();
				break;
			case 6:
				o1.listaCandidatoPrefeito();
				break;
			case 7:
				o1.listaUrnas();
				break;
			case 9:
				System.out.println("Volta para menu anterior");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite um valor valido");
				break;
			}
		}

	}

	public void menuTerciario() {
		int op = Integer.parseInt(JOptionPane
				.showInputDialog("Eleicao\n" + "Ecolha a opçao desejada.\n" + "1-Abrir eleicao\n"+ "2-Zera Contagem de votos\n" + "9-Voltar"));

		switch (op) {
		case 1:
			c1.abreEleicao();
			eleicaoPrimeiroTurno();
			break;
		case 2:
			c1.zeraContagemDeVotos();
			break;
		case 9:
			System.out.println("Volta para menu anterior");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Digite um valor valido");
			break;
		}
	}

	public void eleicaoPrimeiroTurno() {

		int op = 0;

		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Eleicao Primeiro turno\n" + "Ecolha a opçao desejada.\n"
					+ "1-Realizar voto \n" + "2-Realizar voto nulo\n" + "3-Justificar voto\n" + "9-Fechar eleicao\n"));

			switch (op) {
			case 1:
				cadastra.realizaVoto();
				break;
			case 2:
				cadastra.realizaVotoNulo();
				break;

			case 3:
				cadastra.justificarVoto();
				break;
			case 9:
				c1.fechaEleicao();
				JOptionPane.showMessageDialog(null, c1.estatisticaPrimeiroTurno());
			//	if (c1.analisaSegundoTurno()==null) {
				//	eleicaoSegundoTurno();
			//	}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Digite um valor valido");
				break;
			}
		}

	}

	// NAO IMPLEMENTADA AINDA
	public void eleicaoSegundoTurno() {

		int op = 0;

		while (op != 9) {
			op = Integer.parseInt(JOptionPane.showInputDialog("Eleicao Segundo turno\n" + "Ecolha a opçao desejada.\n"
					+ "1-Realizar voto \n" + "2-Realizar voto nulo\n" + "3-Justificar voto\n"
					+ "4-Vizualizar candidatos\n" + "9-Fechar eleicao\n"));

			switch (op) {
			case 1:
				 cadastra.realizaVoto();
				break;
			case 2:
				 cadastra.realizaVotoNulo();
				break;

			case 3:
				 cadastra.justificarVoto();
				break;
			case 9:
				 c1.fechaEleicao();
				
				 break;
			default:
				JOptionPane.showMessageDialog(null, "Digite um valor valido");
				break;
			}
		}
	}

}
