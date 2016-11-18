package modelo;

import interfaces.InSorteiaLetras;
import modelo.sorteia.SorteaLetrasDificil;
import modelo.sorteia.SorteaLetrasNormal;

public class SorteaLetras {

	public static InSorteiaLetras singleton;

	public enum TipoEstrategia {
		NORMAL, DIFICIL
	};

	private TipoEstrategia tipo;

	public SorteaLetras() {
		this.tipo = TipoEstrategia.DIFICIL;
	}

	public InSorteiaLetras criaEstrategia(TipoEstrategia tipo) {
		switch (tipo) {
		case NORMAL:
			if (singleton == null) {
				singleton = new SorteaLetrasNormal();
			}
			return singleton;
		case DIFICIL:
			if (singleton == null) {
				singleton = new SorteaLetrasDificil();
			}
			return singleton;

		default:
			return new SorteaLetrasNormal();
		}
	}

	public TipoEstrategia getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		if (tipo == 2)
			this.tipo = TipoEstrategia.DIFICIL;
		else
			this.tipo = TipoEstrategia.NORMAL;
	}

}
