package model.entities;

import model.services.CalculadoraDePagamento;

public class Funcionario {
    private String nome;
    private CalculadoraDePagamento tipoPagamento;

    public Funcionario(String nome, CalculadoraDePagamento tipoPagamento) {
        this.nome = nome;
        this.tipoPagamento = tipoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CalculadoraDePagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(CalculadoraDePagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Dados do pagamento do funcionario: " +
                "\nNome: " + nome  +
                "\nPagamento: R$ " + String.format("%.2f", tipoPagamento.calcularPagamento());
    }

}
