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

