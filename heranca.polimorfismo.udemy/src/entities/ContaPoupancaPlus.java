package entities;

public class ContaPoupancaPlus extends ContaPoupanca{

    @Override
    public void retirada(double quantidade){
        saldo -= quantidade;
    }
}
