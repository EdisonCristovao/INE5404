package visao;

import javax.swing.JOptionPane;

import modelo.CandidatoPrefeito;
import modelo.CandidatoVereador;
import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.Partido;
import modelo.Secao;
import modelo.Zona;
import modelo.estados.Aberta;

public class OutLista {

	FachadaCartorioEleitoral c1 = new FachadaCartorioEleitoral();

	public OutLista(FachadaCartorioEleitoral c1) {
		this.c1 = c1;
	}

	public void listaZona() {
		Zona zona;
		String dados = "Imprimindo Zonas cadastradas";
		for (int conti = 0; conti < c1.numeroDeZonasEleitorais(); conti++) {
			zona = c1.getZonas().get(conti);
			dados += "\nNumero: " + zona.getNumero() + "\nLocalização: " + zona.getLocalizacao()
					+ "\nNumero de secoes é: " + zona.getSecoes().size() + "\n";
		}
		JOptionPane.showMessageDialog(null, dados);
	}

	public void listaSecao() {
		int numeroDaZona = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da zona para listar as secoes"));
		String dados = "";
			Secao secao;
			dados += "Imprimindo Secoes cadastradas";
			for (int conti = 0; conti < c1.getZona(numeroDaZona).getSecoes().size(); conti++) {
				secao = c1.getZona(numeroDaZona).getSecoes().get(conti);
				dados += "\nNumero: " + secao.getNumero() + "\nNumero de Eleitores nessa secao: "
						+ secao.getEleitores().size() + "\nSecao da zona: " + numeroDaZona;
			}
		JOptionPane.showMessageDialog(null, dados);
	}

	public void listaEleitor() {
		Eleitor eleitor;
		int numeroDaZona = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Zona para listar os eleitores"));
		int numeroDaSecao = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da secao para listar os eleitores"));
		String dados = "Imprimindo Eleitores cadastrados";
		for (int conti = 0; conti < c1.getZona(numeroDaZona).getSecoes().size(); conti++) {
			eleitor = c1.getSecao(numeroDaZona, numeroDaSecao).getEleitores().get(conti);
			dados += "\ncpf: " + eleitor.getCpf() + "\nNome: " + eleitor.getNome() + "\nTitulo: " + eleitor.getTitulo()
					+ "\nMunicipio: " + eleitor.getMunicipio() + "\nEndereco: " + eleitor.getEndereco()
					+ "\nNumero da secao do eleitor: " + numeroDaSecao;
		}

		JOptionPane.showMessageDialog(null, dados);
	}

	public void listaPartido() {
		Partido partido;
		String dados = "Imprimindo Partidos cadastrados";
		for (int conti = 0; conti < c1.getPartidos().size(); conti++) {
			partido = c1.getPartidos().get(conti);
			dados += "\nNome: " + partido.getNomePartido() + "\nSigla: " + partido.getSiglaPartido()
					+ "\nNumero de candidados a vereadore: " + partido.getCandidatosVereadores().size();
		}
		JOptionPane.showMessageDialog(null, dados);
		System.out.println(dados);
	}

	public void listaCandidatoVereador() {
		CandidatoVereador candidato;
		String partido = JOptionPane.showInputDialog(null, "Digite o Nome do partido");
		String dados = "Imprimindo Candidatos vereadores cadastrados";
		for (int conti = 0; conti < c1.getPartido(partido).getCandidatosVereadores().size(); conti++) {
			candidato = c1.getPartido(partido).getCandidatosVereadores().get(conti);
			dados += "\nNumero: " + candidato.getNumero() + "\nNome do candidato a vereador: "
					+ candidato.getEleitor().getNome();
		}
		JOptionPane.showMessageDialog(null, dados);

	}

	public void listaCandidatoPrefeito() {
		CandidatoPrefeito candidatoPrefeito;
		String partido = JOptionPane.showInputDialog(null, "Digite o Nome do partido");
		String dados = "Imprimindo Candidatos Prefeito cadastrados";
		candidatoPrefeito = c1.getCandidatoPrefeito(c1.getPartido(partido));
		dados += "\nNumero: " + candidatoPrefeito.getNumero() + "\nNome do Candidato a prefeito: "
				+ candidatoPrefeito.getEleitor().getNome();
		JOptionPane.showMessageDialog(null, dados);
	}
	public void listaUrnas() {
		if (c1.getUrnas().get(0).getEstado().getClass() == Aberta.class) {
			System.out.println("ta aberta");
		}
	}
	

	public void mostraEstatistica() {
		String status;
		status = c1.estatisticaPrimeiroTurno();

		JOptionPane.showMessageDialog(null, status);
	}
	


}
