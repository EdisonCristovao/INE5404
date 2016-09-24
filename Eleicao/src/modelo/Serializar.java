package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializar {

	public void salvaFachada(FachadaCartorioEleitoral cartorio, String nomeDoArquivo) throws IOException{
		try{
			FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
			ObjectOutputStream stream = new ObjectOutputStream(arquivo);
			stream.writeObject(cartorio);
			arquivo.close();			
		}
		catch (FileNotFoundException e){
		}
	}

	@SuppressWarnings("finally")
	public FachadaCartorioEleitoral carregaFachada(String nomeArquivo) throws IOException, Exception{
		FachadaCartorioEleitoral fachada = null;
		try{
			FileInputStream arquivo = new FileInputStream(nomeArquivo);
			ObjectInputStream stream = new ObjectInputStream(arquivo);
			fachada = (FachadaCartorioEleitoral) stream.readObject();
			stream.close();
			return fachada;
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			return fachada;
		}
	}
	
	
}