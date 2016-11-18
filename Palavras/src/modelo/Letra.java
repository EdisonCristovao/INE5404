package modelo;


public class Letra implements interfaces.IntLetra {

	private Character letra;
	private int valor;

	public Letra() {
		this.letra = '#';
	}
	
	public Letra(Character letra, int valor) {
		this.letra = letra;
		this.valor=valor;
	}
	

	public void setValor(int valor) {
		this.valor = valor;
	}
	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) {
		this.letra = letra;
	}

	@Override
	public Character getCaracter() {
		return getLetra();
	}

	@Override
	public int getValor() {
		return this.valor;
	}

	@Override
	public String toString() {
		return "" + getLetra();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((letra == null) ? 0 : letra.hashCode());
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
		Letra other = (Letra) obj;
		if (letra == null) {
			if (other.letra != null)
				return false;
		} else if (!letra.equals(other.letra))
			return false;
		return true;
	}


	
	
}
