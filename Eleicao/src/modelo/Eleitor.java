package modelo;

import java.io.Serializable;

public class Eleitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cpf;
	private  String nome;
	private int titulo;
	private String endereco;
    private String municipio;
    private boolean voto;
     	
    public Eleitor(int cpf, String nome, int titulo){
    	this.cpf= cpf;
    	this.nome = nome;
    	this.titulo = titulo;
    	this.voto = false;
    }
	public boolean getVoto() {
		return voto;
	}
	public void setVoto(boolean voto) {
		this.voto = voto;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTitulo(int titulo) {
		this.titulo = titulo;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	

	public int getCpf() {
		return cpf;
	}


	public String getNome() {
		return nome;
	}


	public int getTitulo() {
		return titulo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf;
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
		Eleitor other = (Eleitor) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}
	
}

