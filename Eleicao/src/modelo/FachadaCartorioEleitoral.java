
package modelo;

import java.util.ArrayList;

import excecao.ExcecaoZonaEleitoralExistente;

public class FachadaCartorioEleitoral {

	private ArrayList<Zona> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;
	
	public FachadaCartorioEleitoral(){
		this.zonas = new ArrayList<Zona>();
		this.eleitores = new ArrayList<Eleitor>();
		this.secoes = new ArrayList<Secao>();
	}
	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) throws ExcecaoZonaEleitoralExistente {
		Zona zona = getZona(numeroZonaEleitoral);
		if(zona == null){
			zona = new Zona(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		}else
			throw new ExcecaoZonaEleitoralExistente();
		
	}
	public Zona getZona(int numeroZonaEleitoral){
		Zona z1 = new Zona(numeroZonaEleitoral, "");
		for (int cont = 0; cont <this.zonas.size(); cont++){
			Zona zona = this.zonas.get(cont);
			if (zona.equals(z1)){
				return zona;
			}
		}
		return null;
	}
	
	public int getNumeroDeZonas(){
		return zonas.size();
	}
	
	public int getNumeroDeSecoes() {
		return secoes.size();
	}
	
	public int getNumeroDeEleitores() {
		return eleitores.size();
	}
	
	
	public void cadastraEleitor(int cpf, String nome, int titulo, Secao secao, String municipio, String endereco) throws ExcecaoZonaEleitoralExistente{
		Eleitor eleitor = getEleitor(titulo, cpf);
		if(eleitor == null){
			eleitor = new Eleitor(cpf, nome, titulo);
			eleitor.setSecao(secao);
			eleitor.setEndereco(endereco);
			eleitor.setMunicipio(municipio);
			secao.cadastroEleitor(eleitor);
			this.eleitores.add(eleitor);
		}else{
			throw new ExcecaoZonaEleitoralExistente("Ja existe esse eleitor");
		}
	}

	
	public Eleitor getEleitor(int titulo, int cpf){
		Eleitor e1 = new Eleitor(cpf, "", 0);
		for (int cont = 0; cont <this.eleitores.size(); cont++){
			 Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.equals(e1))
				return eleitor;
		}
		return null;
	}
	public void cadastroSecao(int numero, Zona zona) throws ExcecaoZonaEleitoralExistente{
		Secao secao = getSecao(numero, zona);
		if(secao == null){
			secao = new Secao(numero, zona);
			zona.cadastroSecao(secao);
			this.secoes.add(secao);
		}else{
			throw new ExcecaoZonaEleitoralExistente("Ja existe essa secao");
		}
		
		
	}
	public Secao getSecao(int numero, Zona zona) {
			for (int cont = 0; cont < secoes.size(); cont++){
				Secao secao = this.secoes.get(cont);
				if(secao.getNumero()==numero && secao.getZona().equals(zona))
					return secao;
			}
		return null;
	}
	public Secao getSecaoPorNumero(int numero) {
		for (int cont = 0; cont < secoes.size(); cont++){
			Secao secao = this.secoes.get(cont);
			if(secao.getNumero()==numero)
				return secao;
		}
	return null;
	}
	
}