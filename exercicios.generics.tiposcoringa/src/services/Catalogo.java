package services;

import java.util.ArrayList;
import java.util.List;

public class Catalogo<T extends Produto>{
    private final List<T> produtos = new ArrayList<>();

    public void adicionarProduto(T produto){
        produtos.add(produto);
    }

    public T obterMaisCaro(){
        return produtos.stream()
                .max((a,b) -> a.getPreco().compareTo(b.getPreco()))
                .orElseThrow(() -> new IllegalArgumentException("Lista Vazia"));
    }

    public T obterMaisBarato(){
        return produtos.stream()
                .min((a,b) -> a.getPreco().compareTo(b.getPreco()))
                .orElseThrow(() -> new IllegalArgumentException("Lista Vazia"));
    }

    public List<T> listaProdutos(){
        return new ArrayList<>(produtos);
    }

//    Métodos do Tipo Coringa

    public static void adicionarLivrosNaList(List<? extends Produto> produtos){
        for (Produto p : produtos){
            System.out.println(p.getNome() + " - R$" + p.getPreco());
        }
    }

    public static void adicicionarLivrosNaLista(List<? super entities.Livro> lista, entities.Livro... livros){
        for (entities.Livro livro : livros){
            lista.add(livro);
        }
    }

    public static <T> void copiar (List<? extends T> origem, List<? super T> destino){
        for (T item : origem){
            destino.add(item);
        }
    }

}
