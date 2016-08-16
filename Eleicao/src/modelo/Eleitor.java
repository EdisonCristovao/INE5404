package modelo;

public class Eleitor {

	private int cpf;
	private  String nome;
	private int titulo;
	private Zona zona;
	private Secao secao;
	private String endereco;
    private String municipio;
    
    public Eleitor(int cpf, String nome, int titulo){
    	this.cpf= cpf;
    	this.nome = nome;
    	this.titulo = titulo;
    	
    }
    

	public Secao getSecao() {
		return secao;
	}


	public void setSecao(Secao secao) {
		this.secao = secao;
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
	
}

