package modelo.estados;

import java.io.Serializable;

import excecao.ExcecaoUrnaJaAberta;
import excecao.ExcecaoUrnaJaCadastrada;
import interfaces.EstadoUrna;
import modelo.Urna;

public class Aberta implements EstadoUrna, Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Urna urna;
	
	public Aberta(Urna urna) {
		this.urna = urna;
	}
	@Override
	public void cadastrada() throws ExcecaoUrnaJaCadastrada {
		throw new ExcecaoUrnaJaCadastrada();
	}

	@Override
	public void aberta() throws ExcecaoUrnaJaAberta {
		throw new ExcecaoUrnaJaAberta();
	}

	@Override
	public void fechada() {
		urna.setEstado(new Fechada(urna));
	}

	
	

}
