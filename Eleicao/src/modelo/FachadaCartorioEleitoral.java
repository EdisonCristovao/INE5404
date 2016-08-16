
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
	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) throws ExcecaoZonaEleitoralExistente{
		Zona zona = getZona(numeroZonaEleitoral);
		if(zona == null){
			zona = new Zona(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);
		}else
			throw new ExcecaoZonaEleitoralExistente();
		
	}
	
	public Zona getZona(int numeroZonaEleitoral){
		for (int cont = 0; cont <this.zonas.size(); cont++){
			Zona zona = this.zonas.get(cont);
			if (zona.getNumero() == numeroZonaEleitoral){
				return zona;
			}
		}
		return null;
	}
	
	public int numeroDeZonasEleitorais(){
		return zonas.size();
	}
	
	public void cadastraSecao(Zona zona){
		zona.criaNovaSecao();
	}
	
	public void cadastraEleitor(int cpf, String nome, int titulo, Secao secao, String municipio, String endereco){
		Eleitor eleitor = getEleitor(titulo);
		if(eleitor == null){
			eleitor = new Eleitor(cpf, nome, titulo);
			eleitor.setSecao(secao);
			eleitor.setEndereco(endereco);
			eleitor.setMunicipio(municipio);
			secao.cadastroEleitor(eleitor);
			this.eleitores.add(eleitor);
		}
	}

	
	public Eleitor getEleitor(int titulo){
		for (int cont = 0; cont <this.eleitores.size(); cont++){
			 Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == titulo)
				return eleitor;
		}
		return null;
	}
	public void cadastroSecao(int numero, Zona zona){
		Secao secao = getSecao(numero);
		if(secao == null){
			secao = new Secao(numero, zona);
			zona.cadastroSecao(secao);
					
		}
		
		
	}
	private Secao getSecao(int numero) {
			for (int cont = 0; cont < secoes.size(); cont++){
				Secao secao = this.secoes.get(cont);
				if(secao.getNumero()==numero)
					return secao;
			}
		return null;
	}
	
}