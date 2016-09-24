package modelo.estados;

import java.io.Serializable;

import excecao.ExcecaoUrnaJaCadastrada;
import excecao.ExcecaoUrnaJaFechada;
import interfaces.EstadoUrna;
import modelo.Urna;

public class Cadastrada implements EstadoUrna, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Urna urna;
	
	public Cadastrada(Urna urna) {
		this.urna = urna;
	}

	
	@Override
	public void cadastrada() throws ExcecaoUrnaJaCadastrada {
		throw new ExcecaoUrnaJaCadastrada();
	}

	@Override
	public void aberta() {
		urna.setEstado(new Aberta(urna));
	}

	@Override
	public void fechada() throws ExcecaoUrnaJaFechada {
		throw  new ExcecaoUrnaJaFechada();
	}

}
