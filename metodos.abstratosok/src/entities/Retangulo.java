package entities;

import entities.enums.Cor;

public class Retangulo extends Forma{
    private Double altura;
    private Double largura;

    public Retangulo(){
        super();
    }
    public Retangulo(Cor cor, Double altura, Double largura) {
        super(cor);
        this.altura = altura;
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    @Override
    public double area() {
        return largura * altura;
    }
}
