package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Catalogo <T extends Produto>{
    private List<T> produtos = new ArrayList<>();

    public void addProduto(T produto){
        produtos.add(produto);
    }

    public T obterMaisCaro() {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        T produtoMaisCaro = null;
        Float precoMaisCaro = null;
        
        for (T produto : produtos) {
            Float precoAtual = produto.getPreco();
            if (precoAtual != null) {
                if (precoMaisCaro == null || precoAtual > precoMaisCaro) {
                    produtoMaisCaro = produto;
                    precoMaisCaro = precoAtual;
                }
            }

        }

        if (produtoMaisCaro == null){
            throw new IllegalArgumentException("Nenhum produto possui preço valido");
        }
        return produtoMaisCaro;
    }

    public T obterMaisBarato() {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        T produtoMaisBarato = null;
        Float precoMaisBarato = null;
        
        for (T produto : produtos) {
            Float precoAtual = produto.getPreco();
            if (precoAtual != null) {
                if (precoMaisBarato == null || precoAtual < precoMaisBarato) {
                    produtoMaisBarato = produto;
                    precoMaisBarato = precoAtual;
                }
            }
        }
        if (produtoMaisBarato == null){
            throw new IllegalArgumentException("Nenhum produto possui preco valido");
        }

        return produtoMaisBarato;
    }

    public List<T> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "produtos=" + produtos +
                '}';
    }
}
