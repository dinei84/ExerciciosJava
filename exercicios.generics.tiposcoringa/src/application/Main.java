package application;

public class Main {
    public static void main(String[] args) {

        List<Livro> livros = new ArrayList<>();
        Catalogo.adicionarLivrosNaLista(livros);

        List<Produto> produtos = new ArrayList<>();
        Catalogo.copiar(livros, produtos);

        System.out.println("\n--- Lista de Produtos Copiados ---");
        Catalogo.listarProdutos(produtos);


    }
}