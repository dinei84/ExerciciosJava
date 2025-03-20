package entities;

import java.util.ArrayList;
import java.util.List;
import application.CadastroDeCarga;

public class Frete {
    private Cliente clente;
    private String expedidor;
    private String destinatario;
    private String destinoFinal;
    private String trocaDeNfe;
    private String pedido;
    private double freteEmpresa;
    private String produto;
    private String embalagem;
    private double carregado;
    private double saldo;
    private double freteMotorista;
    private int operacao;
    private int lote;
    private String localizacao;
    private String observacao;
    
    private List<CadastroDeCarga> cargas = new ArrayList<>();
    
    public List<CadastroDeCarga> getCargas() {
        return cargas;
    }
    
    public void addCarga(CadastroDeCarga carga) {
        cargas.add(carga);
    }
}
