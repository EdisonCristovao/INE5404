package modelo;

import java.io.Serializable;

public class CandidatoVereador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Eleitor eleitor;
	private int numero;
	private int numDeVotos;
	
	public CandidatoVereador(int numero, Eleitor eleitor, Partido partido){
		this.eleitor = eleitor;
		this.numero = numero;
		this.numDeVotos=0;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void recebeVoto(){
		this.numDeVotos++;
	}
	
}
