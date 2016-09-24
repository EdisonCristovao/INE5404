
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import excecao.ExcecaoCandidatoVereadorExistente;
import excecao.ExcecaoEleitorExistente;
import excecao.ExcecaoPartidoEleitoralExistente;
import excecao.ExcecaoZonaEleitoralExistente;
import excecao.ExcecaoZonaEleitoralInezistente;
import interfaces.CartorioEleitoral;
import interfaces.InterfaceZonaEleitoral;
import modelo.estados.Aberta;
import modelo.estados.Fechada;

public class FachadaCartorioEleitoral implements CartorioEleitoral, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Zona> zonas;
	private ArrayList<Secao> secoes;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Partido> partidos;
	private ArrayList<CandidatoVereador> candidatosVereadores;
	private ArrayList<CandidatoPrefeito> candidatosPrefeitos;
	private ArrayList<Urna> urnas;
	int numeroDaUrna;

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<Zona>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
		this.partidos = new ArrayList<Partido>();
		this.candidatosVereadores = new ArrayList<CandidatoVereador>();
		this.candidatosPrefeitos = new ArrayList<CandidatoPrefeito>();
		this.urnas = new ArrayList<Urna>();
		numeroDaUrna = 0;
	}

	public ArrayList<CandidatoVereador> getCandidatosVereadores() {
		return candidatosVereadores;
	}

	public ArrayList<CandidatoVereador> getCopiaCandidatosVereadores() {
		ArrayList<CandidatoVereador> copiaCandidatosVereadores = new ArrayList<CandidatoVereador>();
		for (int conti = 0; conti < candidatosVereadores.size(); conti++) {
			copiaCandidatosVereadores.add(candidatosVereadores.get(conti));
		}

		return copiaCandidatosVereadores;
	}

	public ArrayList<CandidatoPrefeito> getCandidatosPrefeitos() {
		return candidatosPrefeitos;
	}

	public ArrayList<CandidatoPrefeito> getCopiaCandidatosPrefeitos() {
		ArrayList<CandidatoPrefeito> copiaCandidatosPrefeitos = new ArrayList<CandidatoPrefeito>();
		for (int conti = 0; conti < copiaCandidatosPrefeitos.size(); conti++) {
			copiaCandidatosPrefeitos.add(candidatosPrefeitos.get(conti));
		}
		return copiaCandidatosPrefeitos;
	}

	// ---------------------Cadastro zona
	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao)
			throws ExcecaoZonaEleitoralExistente {
		Zona zona = getZona(numeroZonaEleitoral);
		if (zona == null) {
			zona = new Zona(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		} else
			throw new ExcecaoZonaEleitoralExistente();

	}

	@Override
	public InterfaceZonaEleitoral getZonas(int numeroZonaEleitoral) {
		return getZona(numeroZonaEleitoral);
	}

	public Zona getZona(int numeroZonaEleitoral) {
		Zona z1 = new Zona(numeroZonaEleitoral, "");
		for (int cont = 0; cont < this.zonas.size(); cont++) {
			Zona zona = this.zonas.get(cont);
			if (zona.equals(z1)) {
				return zona;
			}
		}
		return null;
	}

	public int numeroDeZonasEleitorais() {
		return zonas.size();
	}

	public ArrayList<Zona> getZonas() {
		return zonas;
	}
	// --------------URNAS-----

	public ArrayList<Urna> getUrnas() {
		return urnas;
	}

	// ------------------SECAO-------

	public void cadastraSecao(int numeroDaZona) throws ExcecaoZonaEleitoralInezistente {
		Secao secao;
		Zona zona = getZona(numeroDaZona);
		if (zona != null) {
			secao = new Secao(zona.criaNovaSecao(), zona);
			secoes.add(secao);
			Urna urna = new Urna(numeroDaUrna++, secao);
			urnas.add(urna);
		} else {
			throw new ExcecaoZonaEleitoralInezistente();
		}

	}

	public Secao getSecao(int numeroDaZona, int numeroDaSecao) {
		if (getZona(numeroDaZona) != null) {
			for (int conti = 0; conti < getZona(numeroDaZona).getSecoes().size(); conti++) {
				if (getZona(numeroDaZona).getSecoes().get(conti).getNumero() == numeroDaSecao)
					return secoes.get(conti);
			}

		}
		return null;
	}

	public ArrayList<Secao> getSecoes() {
		return secoes;
	}

	public Secao getSecaoPorEleitor(Eleitor eleitor) {
		for (int conti = 0; conti < secoes.size(); conti++) {
			if (secoes.get(conti).getEleitores().contains(eleitor)) {
				return secoes.get(conti);
			}
		}
		return null;
	}

	@Override
	public int numeroDeSecoes(int numeroZonaEleitoral) {
		return getZona(numeroZonaEleitoral).getSecoes().size();

	}
	// -----------------------------ELEITORES---------------

	public void cadastraEleitor(int cpf, String nome, int titulo, Secao secao, String municipio, String endereco)
			throws ExcecaoEleitorExistente {
		Eleitor eleitor = getEleitorPorCpf(cpf);
		if (eleitor == null) {
			eleitor = new Eleitor(cpf, nome, titulo);
			eleitor.setEndereco(endereco);
			eleitor.setMunicipio(municipio);
			secao.cadastroEleitor(eleitor);
			eleitores.add(eleitor);
		} else {
			throw new ExcecaoEleitorExistente("Ja existe esse eleitor");
		}
	}

	public Eleitor getEleitorPorCpf(int cpf) {
		Eleitor e1 = new Eleitor(cpf, "", 0);
		for (int conti = 0; conti < eleitores.size(); conti++) {
			if (eleitores.get(conti).equals(e1)) {
				return eleitores.get(conti);
			}

		}
		return null;
	}

	public Eleitor getEleitorPorTitulo(int numeroTitulo) {
		for (int coni = 0; coni < eleitores.size(); coni++) {
			if (eleitores.get(coni).getTitulo() == numeroTitulo) {
				return eleitores.get(coni);

			}
		}
		return null;
	}

	// -------------------- Partido

	public void cadastroPartido(String sigla, String nomePartido) throws ExcecaoPartidoEleitoralExistente {
		Partido partido = getPartido(sigla);
		if (partido == null) {
			partido = new Partido(sigla, nomePartido);
			partidos.add(partido);
		} else {
			throw new ExcecaoPartidoEleitoralExistente("partido existente");
		}
	}

	public Partido getPartido(String sigla) {
		Partido p1 = new Partido(sigla, "");
		for (int cont = 0; cont < partidos.size(); cont++) {
			Partido partido = this.partidos.get(cont);
			if (partido.equals(p1))
				return partido;
		}
		return null;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public int getNumDePartidos() {
		return partidos.size();
	}

	// ------------------Candidato Vereador
	public void cadastroCandidatoVereador(int numero, Eleitor eleitor, Partido partido)
			throws ExcecaoCandidatoVereadorExistente {
		CandidatoVereador candidato = getCandidatoVereador(eleitor, partido);
		if (candidato == null) {
			candidato = new CandidatoVereador(numero, eleitor, partido);
			partido.cadastraVereador(candidato);
			candidatosVereadores.add(candidato);
		} else {
			throw new ExcecaoCandidatoVereadorExistente("Candidato existente");
		}

	}

	public CandidatoVereador getCandidatoVereador(Eleitor eleitor, Partido partido) {
		CandidatoVereador c1 = new CandidatoVereador(0, eleitor, partido);
		for (int cont = 0; cont < partido.getCandidatosVereadores().size(); cont++) {
			CandidatoVereador candidato = partido.getCandidatosVereadores().get(cont);
			if (candidato.equals(c1))
				return candidato;
		}
		return null;
	}

	public CandidatoVereador getCandidatoVereadorPorNumero(int numeroCandVereador) {
		for (int conti = 0; conti < candidatosVereadores.size(); conti++) {
			if (candidatosVereadores.get(conti).getNumero() == numeroCandVereador) {
				return candidatosVereadores.get(conti);
			}
		}
		return null;
	}

	// -----------------cadastro prefeito
	public void cadastroPrefeito(int numero, Eleitor eleitor, Partido partido) {
		CandidatoPrefeito candidatoPrefeito = new CandidatoPrefeito(eleitor, partido, numero);
		partido.setCandidatoPrefeito(candidatoPrefeito);
		candidatosPrefeitos.add(candidatoPrefeito);
	}

	public CandidatoPrefeito getCandidatoPrefeito(Partido partido) {
		return partido.getCandidatoPrefeito();
	}

	public CandidatoPrefeito getCandidatoPrefeitoPorNumero(int numeroCandPrefeito) {
		for (int conti = 0; conti < candidatosPrefeitos.size(); conti++) {
			if (candidatosPrefeitos.get(conti).getNumero() == numeroCandPrefeito) {
				return candidatosPrefeitos.get(conti);
			}
		}
		return null;
	}

	// ----------------------ELEICAO
	public void abreEleicao() {
		for (int conti = 0; conti < getUrnas().size(); conti++) {
			urnas.get(conti).setEstado(new Aberta(urnas.get(conti)));
		}
	}

	public void realizaVoto(Eleitor eleitor, CandidatoPrefeito candidatoPrefeito, CandidatoVereador candidatoVereador) {
		Secao secao = getSecaoPorEleitor(eleitor);
		if (eleitor.getVoto() == false) {
			for (int conti = 0; conti < urnas.size(); conti++) {
				if (urnas.get(conti).getSecao().equals(secao)) {
					urnas.get(conti).realizarVoto(eleitor, candidatoPrefeito, candidatoVereador);
					eleitor.setVoto(true);

				}
			}
		}
	}

	public void realizaVotoNulo(Eleitor eleitor) {
		Secao secao = getSecaoPorEleitor(eleitor);
		if (eleitor.getVoto() == false) {
			for (int conti = 0; conti < urnas.size(); conti++) {
				if (urnas.get(conti).getSecao().equals(secao)) {
					urnas.get(conti).realizarVotoNulo(eleitor);
					eleitor.setVoto(true);

				}
			}
		}
	}

	public void justificaVoto(Eleitor eleitor) {
		Secao secao = getSecaoPorEleitor(eleitor);
		if (eleitor.getVoto() == false) {
			for (int conti = 0; conti < urnas.size(); conti++) {
				if (urnas.get(conti).getSecao().equals(secao)) {
					urnas.get(conti).justificarVoto(eleitor);
					eleitor.setVoto(true);

				}
			}
		}
	}

	public void fechaEleicao() {
		for (int conti = 0; conti < getUrnas().size(); conti++) {
			urnas.get(conti).setEstado(new Fechada(urnas.get(conti)));
		}

	}

	// -----------ESTATISTICA---------
	public int numeroDeVtosNulos() {
		int nTotal = 0;
		for (int conti = 0; conti < urnas.size(); conti++) {
			Urna urna = urnas.get(conti);
			nTotal += urna.getNumVotosNulos();
		}
		return nTotal;
	}

	public int numeroDeVtosJustificados() {
		int nTotal = 0;
		for (int conti = 0; conti < urnas.size(); conti++) {
			Urna urna = urnas.get(conti);
			nTotal += urna.getNumVotosJustificados();
		}
		return nTotal;
	}

	public int numeroDeVotos() {
		int nTotal = 0;
		for (int conti = 0; conti < urnas.size(); conti++) {
			Urna urna = urnas.get(conti);
			nTotal += urna.getNumeroDeVotos();
		}
		return nTotal;
	}

	public int totalDeVotos() {
		int totalDeVotos = numeroDeVtosNulos() + numeroDeVtosJustificados() + numeroDeVotos();
		return totalDeVotos;
	}

	public CandidatoPrefeito candidatoPrefeitoMaisVotado() {
		CandidatoPrefeito candidato = candidatosPrefeitos.get(0);

		for (int conti = 1; conti < candidatosPrefeitos.size(); conti++) {
			if (candidatosPrefeitos.get(conti).getNumDeVotos() > candidato.getNumDeVotos()) {
				candidato = candidatosPrefeitos.get(conti);
			}
		}
		return candidato;
	}

	public ArrayList<CandidatoVereador> candidatosVereadorresMaisVotados() {
		ArrayList<CandidatoVereador> auxCandidatosVencedores = getCopiaCandidatosVereadores();
		ArrayList<CandidatoVereador> candidatosVencedores = new ArrayList<CandidatoVereador>();
		int vezes = 0;
		int pos = 0;

		while (vezes <= 1) {
			for (int conti = 0; conti < auxCandidatosVencedores.size(); conti++) {
				if (auxCandidatosVencedores.get(conti).getNumDeVotos() > auxCandidatosVencedores.get(pos)
						.getNumDeVotos()) {
					pos = conti;
				}
			}
			candidatosVencedores.add(auxCandidatosVencedores.get(pos));
			auxCandidatosVencedores.remove(auxCandidatosVencedores.get(pos));
			vezes++;
		}

		return candidatosVencedores;
	}

	public CandidatoPrefeito analisaSegundoTurno() {
		CandidatoPrefeito candidato = candidatoPrefeitoMaisVotado();

		if (candidato.getNumDeVotos() > (numeroDeVotos() / 2)) {
			return candidato;
		} else {
			return null;
		}

	}

	public String estatisticaPrimeiroTurno() {
		String estatistica = "";
		ArrayList<CandidatoVereador> candidatos = candidatosVereadorresMaisVotados();
		float perCentVotosNulos = (100 * numeroDeVtosNulos()) / totalDeVotos();
		float perCentVotosJustificados = (100 * numeroDeVtosJustificados()) / totalDeVotos();
		float perCentVotosEfetivos = (100 * numeroDeVotos()) / totalDeVotos();

		estatistica += "Total de votos " + totalDeVotos() + "\n" + perCentVotosEfetivos + "% de votos efetivos.\n"
				+ perCentVotosJustificados + "% de votos justificados.\n" + perCentVotosNulos + "% de votos nulos.\n";

		if (candidatos.size() != 0) {
			estatistica += "\nOs " + candidatos.size() + " candidatos mais votados foram.\n";
			for (int conti = 0; conti < candidatos.size(); conti++) {
				estatistica += (conti + 1) + "-" + candidatos.get(conti).getEleitor().getNome() + " com "
						+ candidatos.get(conti).getNumDeVotos() + " votos\n";
			}
		} else {
			estatistica += "\n nenhum vereador eleito.\n";
		}

		CandidatoPrefeito candidato = analisaSegundoTurno();
		if (candidato != null) {
			estatistica += "\nPrefeito eleito " + candidato.getEleitor().getNome() + "\nCom "
					+ (100 * candidato.getNumDeVotos()) / totalDeVotos() + "% dos votos\n";
		} else {
			estatistica += "Sera necessario segundo tudo\n";
		}
		candidatos = new ArrayList<CandidatoVereador>();
		return estatistica;
	}

	public String estatisticaSegundoTurno() {
		String estatistica = "";
		float perCentVotosNulos = (100 * numeroDeVtosNulos()) / totalDeVotos();
		float perCentVotosJustificados = (100 * numeroDeVtosJustificados()) / totalDeVotos();
		float perCentVotosEfetivos = (100 * numeroDeVotos()) / totalDeVotos();

		estatistica += "Total de votos " + totalDeVotos() + "\n" + perCentVotosEfetivos + "% de votos efetivos.\n"
				+ perCentVotosJustificados + "% de votos justificados.\n" + perCentVotosNulos + "% de votos nulos.\n";

		CandidatoPrefeito candidato = candidatoPrefeitoMaisVotado();
		if (candidato != null) {
			estatistica += "\nPrefeito eleito " + candidato.getEleitor().getNome() + "\n Com "
					+ (100 * candidato.getNumDeVotos()) / totalDeVotos() + "% dos votos\n";
		}

		return estatistica;
	}

	public void zeraContagemDeVotos() {
		for (int conti = 0; conti < candidatosVereadores.size(); conti++) {
			candidatosPrefeitos.get(conti).setNumDeVotos(0);
		}
		for (int conti = 0; conti < candidatosPrefeitos.size(); conti++) {
			candidatosPrefeitos.get(conti).setNumDeVotos(0);
		}
		for (int conti = 0; conti < eleitores.size(); conti++) {
			eleitores.get(conti).setVoto(false);
		}
		

	}

	// -------------

}