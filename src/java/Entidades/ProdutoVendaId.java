package Entidades;
// Generated 07/04/2015 21:25:37 by Hibernate Tools 4.3.1



/**
 * ProdutoVendaId generated by hbm2java
 */
public class ProdutoVendaId  implements java.io.Serializable {


     private int prodCodigo;
     private int produtoCodProduto;
     private int vendaCodVenda;

    public ProdutoVendaId() {
    }

    public ProdutoVendaId(int prodCodigo, int produtoCodProduto, int vendaCodVenda) {
       this.prodCodigo = prodCodigo;
       this.produtoCodProduto = produtoCodProduto;
       this.vendaCodVenda = vendaCodVenda;
    }
   
    public int getProdCodigo() {
        return this.prodCodigo;
    }
    
    public void setProdCodigo(int prodCodigo) {
        this.prodCodigo = prodCodigo;
    }
    public int getProdutoCodProduto() {
        return this.produtoCodProduto;
    }
    
    public void setProdutoCodProduto(int produtoCodProduto) {
        this.produtoCodProduto = produtoCodProduto;
    }
    public int getVendaCodVenda() {
        return this.vendaCodVenda;
    }
    
    public void setVendaCodVenda(int vendaCodVenda) {
        this.vendaCodVenda = vendaCodVenda;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProdutoVendaId) ) return false;
		 ProdutoVendaId castOther = ( ProdutoVendaId ) other; 
         
		 return (this.getProdCodigo()==castOther.getProdCodigo())
 && (this.getProdutoCodProduto()==castOther.getProdutoCodProduto())
 && (this.getVendaCodVenda()==castOther.getVendaCodVenda());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getProdCodigo();
         result = 37 * result + this.getProdutoCodProduto();
         result = 37 * result + this.getVendaCodVenda();
         return result;
   }   


}


