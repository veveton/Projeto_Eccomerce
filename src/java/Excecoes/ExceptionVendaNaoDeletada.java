package Excecoes;


public class ExceptionVendaNaoDeletada  extends Exception{

	
	public ExceptionVendaNaoDeletada() {
	
		System.out.println("Essa venda nao pode ser cancelada");
	}
}
