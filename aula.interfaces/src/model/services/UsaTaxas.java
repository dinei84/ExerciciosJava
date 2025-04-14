package model.services;

public class UsaTaxas implements ServicosTaxas{
    @Override
    public double taxa (double quantia){
        if (quantia <= 400){
            return quantia * 0.4;
        }else {
            return quantia * 0.25;
        }
    }
}
