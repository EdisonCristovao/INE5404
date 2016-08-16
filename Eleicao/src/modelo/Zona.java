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
		if(this.secoes.contains(secao))
			this.secoes.add(secao);
	}
}
