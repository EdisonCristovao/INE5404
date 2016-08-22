package modelo;

public class Candidato {

	private Eleitor eleitor;
	private Partido partido;	
	private String cargo;
	
	public Candidato(Eleitor eleitor, Partido partido, String cargo){
		this.eleitor = eleitor;
		this.partido = partido;
		this.cargo = cargo;
	}
	
	//para comparação
	public Candidato(Eleitor eleitor){
		this.eleitor = eleitor;
	}
	
	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
