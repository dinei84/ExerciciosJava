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
        BigDecimal maisCaroVarificado = null;
        for (Produto produto : produtos) {
            maisCaroVarificado = BigDecimal.valueOf(produto.getPreco().compareTo((BigDecimal) produtos));
        }
        return (T) maisCaroVarificado;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "produtos=" + produtos +
                '}';
    }
}
