package modelo;

import java.util.ArrayList;

public class Secao {
	
	private int numero;
	private Zona zona;
	private ArrayList<Eleitor> eleitores;

	public Secao (int numero, Zona zona){
		this.numero= numero;
		this.zona= zona;
		this.eleitores = new ArrayList <Eleitor>();
	}
	public void cadastroEleitor(Eleitor eleitor){
		if (!this.eleitores.contains(eleitor))
			this.eleitores.add(eleitor);
	}
	
	public int getNumero(){
		return this.numero;
	}
	public Zona getZona() {
		return zona;
	}
	public void setZona(Zona zona) {
		this.zona = zona;
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
	
	
	
	
}
