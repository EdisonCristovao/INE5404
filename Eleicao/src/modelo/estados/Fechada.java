package modelo.estados;

import java.io.Serializable;

import excecao.ExcecaoUrnaJaAberta;
import excecao.ExcecaoUrnaJaFechada;
import interfaces.EstadoUrna;
import modelo.Urna;

public class Fechada implements EstadoUrna, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Urna urna;
	
	public Fechada(Urna urna) {
		this.urna = urna;
	}
	
	@Override
	public void cadastrada() {
		urna.setEstado(new Cadastrada(urna));
	}

	@Override
	public void aberta() throws ExcecaoUrnaJaAberta {
		throw new ExcecaoUrnaJaAberta();
	}

	@Override
	public void fechada() throws ExcecaoUrnaJaFechada {
		throw new ExcecaoUrnaJaFechada();
	}
	
	

}
