package interfaces;

import excecao.ExcecaoUrnaJaAberta;
import excecao.ExcecaoUrnaJaCadastrada;
import excecao.ExcecaoUrnaJaFechada;

public interface EstadoUrna {
	
	public void cadastrada() throws ExcecaoUrnaJaCadastrada;
	public void aberta() throws ExcecaoUrnaJaAberta;
	public void fechada() throws ExcecaoUrnaJaFechada;
}
