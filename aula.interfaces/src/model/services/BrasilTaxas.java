package model.services;

public class BrasilTaxas implements ServicosTaxas{
    public double taxa (double quantia){
        if (quantia <= 100){
            return quantia * 0.2;
        }else {
            return quantia * 0.15;
        }
    }
}
