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
        T produtoMaisCaro = produtos.get(0);
        BigDecimal precoMaisCaro = produtoMaisCaro.getPreco();
        
        for (T produto : produtos) {
            if (produto.getPreco().compareTo(precoMaisCaro) > 0) {
                produtoMaisCaro = produto;
                precoMaisCaro = produto.getPreco();
            }
        }
        return produtoMaisCaro;
    }

    public T obterMaisBarato() {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        T produtoMaisBarato = produtos.get(0);
        BigDecimal precoMaisBarato = produtoMaisBarato.getPreco();
        
        for (T produto : produtos) {
            if (produto.getPreco().compareTo(precoMaisBarato) < 0) {
                produtoMaisBarato = produto;
                precoMaisBarato = produto.getPreco();
            }
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
