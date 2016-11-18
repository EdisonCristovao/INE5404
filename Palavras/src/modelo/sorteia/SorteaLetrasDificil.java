package modelo.sorteia;

import java.util.ArrayList;
import java.util.Random;

import interfaces.InSorteiaLetras;
import modelo.Letra;

public class SorteaLetrasDificil implements InSorteiaLetras {
	public ArrayList<Letra> sacoComLetrasDificeis = new ArrayList<Letra>();
	int qtd;

	public SorteaLetrasDificil() {
		criaSacoComLetras();
		this.qtd = 0;
	}

	public void criaSacoComLetras() {
		sacoComLetrasDificeis.add(new Letra('A', 1));
		sacoComLetrasDificeis.add(new Letra('B', 3));
		sacoComLetrasDificeis.add(new Letra('C', 2));
		sacoComLetrasDificeis.add(new Letra('D', 2));
		sacoComLetrasDificeis.add(new Letra('E', 1));
		sacoComLetrasDificeis.add(new Letra('F', 4));
		sacoComLetrasDificeis.add(new Letra('G', 4));
		sacoComLetrasDificeis.add(new Letra('H', 4));
		sacoComLetrasDificeis.add(new Letra('I', 1));
		sacoComLetrasDificeis.add(new Letra('J', 5));
		sacoComLetrasDificeis.add(new Letra('L', 2));
		sacoComLetrasDificeis.add(new Letra('M', 1));
		sacoComLetrasDificeis.add(new Letra('N', 3));
		sacoComLetrasDificeis.add(new Letra('O', 1));
		sacoComLetrasDificeis.add(new Letra('P', 2));
		sacoComLetrasDificeis.add(new Letra('Q', 6));
		sacoComLetrasDificeis.add(new Letra('R', 1));
		sacoComLetrasDificeis.add(new Letra('S', 1));
		sacoComLetrasDificeis.add(new Letra('T', 1));
		sacoComLetrasDificeis.add(new Letra('U', 1));
		sacoComLetrasDificeis.add(new Letra('V', 4));
		sacoComLetrasDificeis.add(new Letra('X', 8));
		sacoComLetrasDificeis.add(new Letra('Z', 8));
	}

	public Letra tiraLetraDoSaco() {
		Random ran = new Random();
		int pos = ran.nextInt(sacoComLetrasDificeis.size() - 1);
		this.qtd = 0;
		return sacoComLetrasDificeis.get(pos);

	}

}
