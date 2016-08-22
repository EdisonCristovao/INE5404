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
		this.candidatoPrefeito = new Candidato(null);;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siglaPartido == null) ? 0 : siglaPartido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		if (siglaPartido == null) {
			if (other.siglaPartido != null)
				return false;
		} else if (!siglaPartido.equals(other.siglaPartido))
			return false;
		return true;
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
	
	public void cadastraVereador(Candidato candidato){
		this.candidatosVereadores.add(candidato);
	}
}
