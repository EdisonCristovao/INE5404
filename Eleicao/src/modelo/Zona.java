package modelo;

import java.util.ArrayList;

public class Zona {
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
	    Secao secao= new Secao(this.numeroSecao, this);// esse this é o propri objeto nesse caso zona ou seja endereço dele
		this.secoes.add(secao);
		return this.numeroSecao;
    }
    public int getNumero(){
    	return this.numero;
    }
	public void cadastroSecao(Secao secao) {
		if(!this.secoes.contains(secao))
			this.secoes.add(secao);
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
}
