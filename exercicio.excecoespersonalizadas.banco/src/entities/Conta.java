package entities;

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

    public Double getNovoSaldo() {
        return novoSaldo;
    }


    public void sacar(Double saque){

        if (saque > saldo){
            System.out.println("Sem saldo");
        }
        if (saque > limiteSaque){
            System.out.println("Seu limite de saque é: " + getLimiteSaque());
        }

    }

    public Double saldoAtualizado (Double saque){
        double saldoAtl = 0;
        if (saque > limiteSaque || saque > saldo){
            saldo -= saque;
        }
        return saldoAtl = saldo;
    }

    @Override
    public String toString() {
        return "Conta: " +
                "\nNumber: " + number +
                " - Titular='" + titular + '\'' +
                " - Saldo=" + saldo +
                " - LimiteSaque=" + limiteSaque +
                " - Novo Saldo: " + saldoAtualizado(saldo);
    }
}
