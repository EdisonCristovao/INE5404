package testes;

import org.junit.Before;
import org.junit.Test;

import modelo.SorteaLetras;
import modelo.SorteaLetras.TipoEstrategia;

public class SacoDeletrasTeste {
	SorteaLetras saco;

	@Before
	public void setUp() throws Exception {
		saco = new SorteaLetras();
	}

	@Test
	public void testeLetrasRamdom() {
		
		System.out.println("letra modo normal");
		for (int conti = 0; conti < 6; conti++) {
			System.out.println(saco.criaEstrategia(TipoEstrategia.NORMAL).tiraLetraDoSaco());
		}
		System.out.println("letra modo dificio");
		for (int conti = 0; conti < 6; conti++) {
			System.out.println(saco.criaEstrategia(TipoEstrategia.DIFICIL).tiraLetraDoSaco());
		}
		
	}

}
