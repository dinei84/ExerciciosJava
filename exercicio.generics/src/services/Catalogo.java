package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Catalogo<T extends Produto> {
    private final List<T> produtos = new ArrayList<>();

    public void adicionarProduto(T produto) {
        produtos.add(produto);
    }

    public T obterMaisCaro() {
        return produtos.stream()
                .max((a, b) -> a.getPreco().compareTo(b.getPreco()))
                .orElseThrow(() -> new IllegalArgumentException("Lista vazia"));
    }

    public T obterMaisBarato() {
        return produtos.stream()
                .min((a, b) -> a.getPreco().compareTo(b.getPreco()))
                .orElseThrow(() -> new IllegalArgumentException("Lista vazia"));
    }

    public List<T> listarProdutos() {
        return new ArrayList<>(produtos);
    }
}