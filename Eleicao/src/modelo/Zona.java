package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.InterfaceZonaEleitoral;

public class Zona implements InterfaceZonaEleitoral, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private String localizacao;
	private ArrayList<Secao>secoes;
	private int numeroSecao;
	
	public Zona(int numero, String localizacao){
		this.numero=numero;
		this.localizacao=localizacao;
		this.secoes= new ArrayList<Secao>();
		this.numeroSecao=0;
	}
	
    public int criaNovaSecao(){
	    this.numeroSecao++;
		Secao secao = new Secao(this.numeroSecao, this);
		this.secoes.add(secao);
		
		return numeroSecao;
		
		//da pra criar as urnas aqui
    }
    
    public int getNumero(){
    	return this.numero;
    }
	
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public ArrayList<Secao> getSecoes() {
		return secoes;
	}
	public void setSecoes(ArrayList<Secao> secoes) {
		this.secoes = secoes;
	}
	public int getNumeroSecao() {
		return numeroSecao;
	}
	public void setNumeroSecao(int numeroSecao) {
		this.numeroSecao = numeroSecao;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Zona other = (Zona) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	public Object geSecao(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
