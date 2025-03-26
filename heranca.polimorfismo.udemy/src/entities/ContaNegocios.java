package entities;

public class ContaNegocios extends Conta{
    private Double limiteDeEmprestimo;

    public ContaNegocios(){
        super();
    }

    public ContaNegocios(Integer numero, String titular, Double saldo, Double limiteDeEmprestimo) {
        super(numero, titular, saldo);
        this.limiteDeEmprestimo = limiteDeEmprestimo;
    }

    public Double getLimiteDeEmprestimo() {
        return limiteDeEmprestimo;
    }

    public void setLimiteDeEmprestimo(Double limiteDeEmprestimo) {
        this.limiteDeEmprestimo = limiteDeEmprestimo;
    }

    public void emprestimo(double quantidade){
        if (quantidade <= limiteDeEmprestimo){
            saldo += quantidade - 10.0;
        }

    }
}
