package modelo;

public class Grade<T> {
	
	//As linhas e colunas comecam na posicao 1!
	
	private Object[][] matriz;
	private int numLinhas;
	private int numColunas;
	
	public Grade(int numLinhas, int numColunas) {
		if (numLinhas>0  && numColunas>0) {
			this.numLinhas = numLinhas;
			this.numColunas = numColunas;
			this.matriz = (T[][]) new Object[numLinhas][numColunas];
		}
	}
	public void insere(int linha, int coluna, T elemento) {
		if (linha>0 && linha<=numLinhas && coluna>0 && coluna<=numColunas) {
			this.matriz[linha-1][coluna-1] = elemento;
		}
	}

	public T retorna(int linha, int coluna) {
		if (linha>0 && linha<=numLinhas && coluna>0 && coluna<=numColunas) {
			return (T) this.matriz[linha-1][coluna-1];
		}
		else
			return null;
	}
	
	public int retornaNumLinhas(){
		return this.numLinhas;
	}
	
	public int retornaNumColunas(){
		return this.numColunas;
	}
	
	@Override
	public String toString(){
		String resultado = "";
		for (int i=1;i<=this.numLinhas;i++){
			resultado += "\n";
			for (int j=1;j<=this.numColunas;j++) {
				resultado = resultado  + this.matriz[i-1][j-1] + "   "; 
				//resultado = resultado + "("+i+","+j+")"+":" + this.matriz[i-1][j-1] + "    "; 
			}
		}
		return resultado;	
	}
	
}