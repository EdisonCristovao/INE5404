package modelo;

import java.io.Serializable;

public class CandidatoPrefeito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Eleitor eleitor;
	private int numero;
	private int numDeVotos;
	
	public CandidatoPrefeito(Eleitor eleitor, Partido partido, int numero){
		this.eleitor = eleitor;
		this.numero = numero;
		this.numDeVotos = 0;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	public int getNumDeVotos() {
		return numDeVotos;
	}

	public void setNumDeVotos(int numDeVotos) {
		this.numDeVotos = numDeVotos;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public void recebeVoto(){
		this.numDeVotos++;
	}
}
