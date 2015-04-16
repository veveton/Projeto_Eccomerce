package Excecoes;


public class ExceptionProdutoNaoDeletado  extends Exception{

	public ExceptionProdutoNaoDeletado() {
	System.out.println("Produto nao pode ser deletado, verifique se existe");
		// TODO Auto-generated constructor stub
	}
}
