package interfaces;

public interface CartorioEleitoral {

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao) throws Exception;// ok
	
	public int numeroDeZonasEleitorais();// ok
	
	public void cadastraSecao(int numeroZonaEleitoral) throws Exception; // verificar Zona
	
	public InterfaceZonaEleitoral getZonas(int numeroZonaEleitoral);
		
	public int numeroDeSecoes(int numeroZonaEleitoral);
}
