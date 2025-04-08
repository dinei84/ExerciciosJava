package entities;

import exceptions.DomainException;

public class Conta {
    private Integer number;
    private String titular;
    private Double saldo;
    private Double limiteSaque;
    private Double novoSaldo;

    public Conta(Integer number, String titular, Double saldo, Double limiteSaque) {
        this.number = number;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }


    public Double getLimiteSaque() {
        return limiteSaque;
    }


    public void sacar(Double saque) throws DomainException.SaldoInsuficiente, DomainException.LimiteSaqueExcedido, DomainException.ValorInvalido {
        if (saque <= 0) throw new DomainException.ValorInvalido("Valor de saque invalido");
        if (saque > limiteSaque) {
            throw new DomainException.LimiteSaqueExcedido("Seu limite de saque é: R$" + getLimiteSaque());
        }
        if (saque > saldo) {
            throw new DomainException.SaldoInsuficiente("Sem saldo");
        }
        saldo -= saque;
    }

    public void depositar(Double deposito){
        saldo += deposito;
    }



    @Override
    public String toString() {
        return "\nConta: " +
                "\nNumber: " + number +
                "\nTitular: " + titular + '\'' +
                "\nSaldo: " + saldo +
                "\nLimiteSaque: " + limiteSaque;
    }

}
