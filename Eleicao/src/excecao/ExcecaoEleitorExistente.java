package excecao;

public class ExcecaoEleitorExistente extends Exception {
	public ExcecaoEleitorExistente(){
		
	}
	
	public ExcecaoEleitorExistente(String msg){
		super(msg);
	}
}
