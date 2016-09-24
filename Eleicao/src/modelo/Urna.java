package modelo;


import java.io.Serializable;

import interfaces.EstadoUrna;
import modelo.estados.Cadastrada;

public class Urna implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private Secao secao;
	private EstadoUrna estado;
	private int numVotosJustificados;
	private int numVotosNulos;
	private int numeroDeVotos;
	
	public Urna(int numero, Secao secao) {
		this.numero = numero;
		this.secao = secao;
		this.estado = new Cadastrada(this);
		this.numVotosNulos = 0;
		this.numeroDeVotos = 0;
		this.numVotosJustificados = 0;
	}
	

	public int getNumeroDeVotos() {
		return numeroDeVotos;
	}

	public void setNumeroDeVotos(int numeroDeVotos) {
		this.numeroDeVotos = numeroDeVotos;
	}

	public int getNumVotosJustificados() {
		return numVotosJustificados;
	}

	public void setNumVotosJustificados(int numVotosJustificados) {
		this.numVotosJustificados = numVotosJustificados;
	}

	public EstadoUrna getEstado() {
		return estado;
	}

	public void setEstado(EstadoUrna estado) {
		this.estado = estado;
	}

	public int getNumVotosNulos() {
		return numVotosNulos;
	}

	public void setNumVotosNulos(int numVotosNulos) {
		this.numVotosNulos = numVotosNulos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public void justificarVoto(Eleitor eleitor) {
		this.numVotosJustificados++;
	}

	public void realizarVotoNulo(Eleitor eleitor) {
		this.numVotosNulos++;
	}

	public void realizarVoto(Eleitor eleitor, CandidatoPrefeito candidatoPrefeito,
			CandidatoVereador candidatoVereador) {
		votoPrefeito(candidatoPrefeito);
		votoVereador(candidatoVereador);
		numeroDeVotos++;
	}

	public void votoPrefeito(CandidatoPrefeito candidatoPrefeito) {
		candidatoPrefeito.recebeVoto();
	}

	public void votoVereador(CandidatoVereador candidatoVereador) {
		candidatoVereador.recebeVoto();
	}

}
