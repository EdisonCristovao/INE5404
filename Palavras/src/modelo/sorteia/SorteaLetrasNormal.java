package modelo.sorteia;

import java.util.ArrayList;
import java.util.Random;

import interfaces.InSorteiaLetras;
import modelo.Letra;

public class SorteaLetrasNormal implements InSorteiaLetras {
	public ArrayList<Letra> sacoComLetrasFaceis = new ArrayList<Letra>();
	int qtd;

	public SorteaLetrasNormal() {
		criaSacoComLetras();
		this.qtd = 0;
	}

	public void criaSacoComLetras() {
		sacoComLetrasFaceis.add(new Letra('A', 1));
		sacoComLetrasFaceis.add(new Letra('A', 1));
		sacoComLetrasFaceis.add(new Letra('B', 3));
		sacoComLetrasFaceis.add(new Letra('C', 2));
		sacoComLetrasFaceis.add(new Letra('D', 2));
		sacoComLetrasFaceis.add(new Letra('E', 1));
		sacoComLetrasFaceis.add(new Letra('E', 1));
		sacoComLetrasFaceis.add(new Letra('F', 4));
		sacoComLetrasFaceis.add(new Letra('G', 4));
		sacoComLetrasFaceis.add(new Letra('H', 4));
		sacoComLetrasFaceis.add(new Letra('I', 1));
		sacoComLetrasFaceis.add(new Letra('I', 1));
		sacoComLetrasFaceis.add(new Letra('J', 5));
		sacoComLetrasFaceis.add(new Letra('L', 2));
		sacoComLetrasFaceis.add(new Letra('M', 1));
		sacoComLetrasFaceis.add(new Letra('N', 3));
		sacoComLetrasFaceis.add(new Letra('O', 1));
		sacoComLetrasFaceis.add(new Letra('O', 1));
		sacoComLetrasFaceis.add(new Letra('P', 2));
		sacoComLetrasFaceis.add(new Letra('Q', 6));
		sacoComLetrasFaceis.add(new Letra('R', 1));
		sacoComLetrasFaceis.add(new Letra('S', 1));
		sacoComLetrasFaceis.add(new Letra('T', 1));
		sacoComLetrasFaceis.add(new Letra('U', 1));
		sacoComLetrasFaceis.add(new Letra('U', 1));
		sacoComLetrasFaceis.add(new Letra('V', 4));
		sacoComLetrasFaceis.add(new Letra('X', 8));
		sacoComLetrasFaceis.add(new Letra('Z', 8));
	}

	public Letra tiraLetraDoSaco() {
		Random ran = new Random();
		int pos = ran.nextInt(sacoComLetrasFaceis.size() - 1);
		this.qtd = 0;
		return sacoComLetrasFaceis.get(pos);

	}

}
