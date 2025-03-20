package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Caminhao;
import entities.Carga;
import entities.Emissor;
import entities.Motorista;

public class CadastroDeCarga {
    private Date data;
    private Caminhao caminhao;
    private Motorista motorista;
    private Emissor emissor;
    private double freteMotorista;
    private Integer cte;
    private String nfe;
    private String observacao;

    public List<Carga> cargas = new ArrayList<>();

    public CadastroDeCarga(){
    }

    public CadastroDeCarga(Date data, Caminhao caminhao, Motorista motorista, Emissor emissor, double freteMotorista,
            Integer cte, String nfe, String observacao) {
        this.data = data;
        this.caminhao = caminhao;
        this.motorista = motorista;
        this.emissor = emissor;
        this.freteMotorista = freteMotorista;
        this.cte = cte;
        this.nfe = nfe;
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Emissor getEmissor() {
        return emissor;
    }

    public void setEmissor(Emissor emissor) {
        this.emissor = emissor;
    }

    public double getFreteMotorista() {
        return freteMotorista;
    }

    public void setFreteMotorista(double freteMotorista) {
        this.freteMotorista = freteMotorista;
    }

    public Integer getCte() {
        return cte;
    }

    public void setCte(Integer cte) {
        this.cte = cte;
    }

    public String getNfe() {
        return nfe;
    }

    public void setNfe(String nfe) {
        this.nfe = nfe;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void addCarga(Carga carga){
        this.cargas.add(carga);
    }

    public void removeCarga(Carga carga){
        this.cargas.remove(carga);
    }

}
