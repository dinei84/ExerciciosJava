package application;

import entities.EstoqueService;
import entities.Produto;

import java.io.FileNotFoundException;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        try {
            List<Produto> produtosParaRepor = EstoqueService.lerProdutos();
            EstoqueService.listaFinal(produtosParaRepor);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
