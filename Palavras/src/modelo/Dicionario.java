package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dicionario {

	List<String> dicionario;

	public Dicionario() throws FileNotFoundException {
		this.dicionario = criaDicionario();
	}

	public List<String> criaDicionario() throws FileNotFoundException  {
		
		Scanner scanner = new Scanner(new File("palavras.txt"));
		
		
		List<String> dicionarioCriado = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			dicionarioCriado.add(scanner.nextLine());
		}
		scanner.close();
		return dicionarioCriado;
	}

	public boolean existePalavraNoDicionario(List<Letra> listaDeLetrasDaPalavra) {
		String palavra = converteEmPalavra(listaDeLetrasDaPalavra);
		if (this.dicionario.contains(palavra)) {
			System.out.println("palavra Existe");
			return true;
		}
		return false;
	}

	public String converteEmPalavra(List<Letra> listaDeLetrasDaPalavra) {
		String palavra = "";
		if (listaDeLetrasDaPalavra.size() != 0) {
			for (int conti = 0; conti < listaDeLetrasDaPalavra.size(); conti++) {
				palavra += listaDeLetrasDaPalavra.get(conti).getLetra();
			}
			return palavra;

		}
		return null;

	}

}
