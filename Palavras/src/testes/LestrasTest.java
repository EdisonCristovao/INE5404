package testes;


import org.junit.Before;
import org.junit.Test;

import modelo.Letra;


public class LestrasTest {
	Letra l1;
	@Before
	public void setUp() throws Exception {
		 l1 = new Letra();
	}

	@Test
	public void test() {
	System.out.println(l1.getCaracter());
	}

}
