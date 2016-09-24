package modelo;

import java.io.Serializable;
import java.util.ArrayList;

import interfaces.InterfaceSecao;

public class Secao implements InterfaceSecao, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private ArrayList<Eleitor> eleitores;
	private Zona zona;

	public Secao (int numero, Zona zona){
		this.numero= numero;
		this.eleitores = new ArrayList <Eleitor>();
		this.zona = zona;
	}
	public void cadastroEleitor(Eleitor eleitor){
		if (!this.eleitores.contains(eleitor))
			this.eleitores.add(eleitor);
	}
	
	public int getNumero(){
		return this.numero;
	}
	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}
	public void setEleitores(ArrayList<Eleitor> eleitores) {
		this.eleitores = eleitores;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public Zona getZona() {
		return this.zona;
	}
	
	
}
