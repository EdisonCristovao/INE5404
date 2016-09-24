package visao;

import javax.swing.JOptionPane;

import excecao.ExcecaoCandidatoVereadorExistente;
import excecao.ExcecaoEleitorExistente;
import excecao.ExcecaoPartidoEleitoralExistente;
import excecao.ExcecaoZonaEleitoralExistente;
import excecao.ExcecaoZonaEleitoralInezistente;
import modelo.FachadaCartorioEleitoral;
import modelo.Secao;

public class InputCadastra {

	FachadaCartorioEleitoral c1 = new FachadaCartorioEleitoral();

	public InputCadastra(FachadaCartorioEleitoral c1) {
		this.c1 = c1;
	}

	public void cadastraZona() {

		int numeroZonaEleitoral;
		String localizacao;

		numeroZonaEleitoral = Integer
				.parseInt(JOptionPane.showInputDialog("Cadastro Zona\n" + "Insira o numero da zona"));
		localizacao = JOptionPane.showInputDialog("Insira a localização");
		try {
			c1.cadastraZonaEleitoral(numeroZonaEleitoral, localizacao);
		} catch (ExcecaoZonaEleitoralExistente e) {
			JOptionPane.showMessageDialog(null, "Zona existente, tente novamente");
		}
	}

	public void cadastraSecao() {
		int numeroZona = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Secao\n" + "Insira o numero da zona"));
		try {
			c1.cadastraSecao(numeroZona);
		} catch (ExcecaoZonaEleitoralInezistente e) {
			JOptionPane.showMessageDialog(null, "Zona invalida");

		}
	}

	public void cadastraEleitor() {
		int cpf;
		String nome;
		int titulo;
		int numeroDaSecao;
		int numeroDaZona;
		String municipio;
		String endereco;

		cpf = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Eleitor\n" + "Insira o numero do CPF"));
		nome = JOptionPane.showInputDialog("Insira o Nome");
		titulo = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero do Titulo"));
		municipio = JOptionPane.showInputDialog("Insira o Municipio");
		endereco = JOptionPane.showInputDialog("Insira o Endereco");
		numeroDaSecao = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da Secao"));
		numeroDaZona = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero da zona"));
		Secao secao = c1.getSecao(numeroDaZona, numeroDaSecao);

		if (secao == null) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		} else {
			try {
				c1.cadastraEleitor(cpf, nome, titulo, secao, municipio, endereco);
			} catch (ExcecaoEleitorExistente e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
			}
		}
	}

	public void cadastraPartido() {
		String sigla;
		String nomePartido;

		sigla = JOptionPane.showInputDialog("Cadastro Partido\n Insira a Sigla");
		nomePartido = JOptionPane.showInputDialog("Insira o Nome do Partido");

		try {
			c1.cadastroPartido(sigla, nomePartido);
		} catch (ExcecaoPartidoEleitoralExistente e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}

	public void cadastraCandidatoVereador() {
		int numero;
		String sigla;
		int cpf;

		numero = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Vereador\n Insira o numero do vereador"));
		sigla = JOptionPane.showInputDialog("Insira a Sigla do partido");
		cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira o cpf do vereador"));

		try {
			c1.cadastroCandidatoVereador(numero, c1.getEleitorPorCpf(cpf), c1.getPartido(sigla));
		} catch (ExcecaoCandidatoVereadorExistente e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}

	public void cadastraCandidatoPrefeito() {
		int numero;
		String sigla;
		int cpf;

		numero = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Prefeito\n Insira o numero do Prefeito"));
		sigla = JOptionPane.showInputDialog("Insira a Sigla do partido");
		cpf = Integer.parseInt(JOptionPane.showInputDialog("Insira o cpf do Prefeito"));

		c1.cadastroPrefeito(numero, c1.getEleitorPorCpf(cpf), c1.getPartido(sigla));
	}

	public void abrirEleicao() {
		c1.abreEleicao();
	}

	public void realizaVoto() {
		int numeroTitulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do titulo"));
		int numeroCandPrefeito = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Prefeito"));
		int numeroCandVereador = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do vereador"));

		c1.realizaVoto(c1.getEleitorPorTitulo(numeroTitulo), c1.getCandidatoPrefeitoPorNumero(numeroCandPrefeito),
				c1.getCandidatoVereadorPorNumero(numeroCandVereador));
	}

	public void realizaVotoNulo() {
		int numeroTitulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do titulo"));

		c1.realizaVotoNulo(c1.getEleitorPorTitulo(numeroTitulo));
	}

	public void justificarVoto() {
		int numeroTitulo = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do titulo"));

		c1.justificaVoto(c1.getEleitorPorTitulo(numeroTitulo));
	}

	public void fechaEleicao() {
		c1.fechaEleicao();
	}

}
