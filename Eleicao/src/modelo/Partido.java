package modelo;

import java.util.ArrayList;

public class Partido {

	private String siglaPartido;
	private String nomePartido;
	private ArrayList<Candidato> candidatosVereadores;
	private Candidato candidatoPrefeito;

	public Partido(String siglaPartido, String nomePartido){
		this.siglaPartido=siglaPartido;
		this.nomePartido=nomePartido;
		this.candidatosVereadores = new ArrayList<Candidato>();
		this.candidatoPrefeito = new Candidato();
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public void setSiglaPartido(String siglaPartido) {
		this.siglaPartido = siglaPartido;
	}

	public String getNomePartido() {
		return nomePartido;
	}

	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}

	public ArrayList<Candidato> getCandidatosVereadores() {
		return candidatosVereadores;
	}

	public void setCandidatosVereadores(ArrayList<Candidato> candidatosVereadores) {
		this.candidatosVereadores = candidatosVereadores;
	}

	public Candidato getCandidatoPrefeito() {
		return candidatoPrefeito;
	}

	public void setCandidatoPrefeito(Candidato candidatoPrefeito) {
		this.candidatoPrefeito = candidatoPrefeito;
	}
}
