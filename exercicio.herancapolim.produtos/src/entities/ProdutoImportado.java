package entities;

public class ProdutoImportado extends Produto{
    private Double taxaAlfandega;

    public ProdutoImportado(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double gettaxaAlfandega() {
        return taxaAlfandega;
    }

    public void settaxaAlfandega(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double precoTotal(){
        return preco + taxaAlfandega;
    }

    @Override
    public String etiquetaDePreco(){
        return " " + nome + " R$" + precoTotal() + " (Taxas de Alfandega) R$"  + gettaxaAlfandega();
    }
}
