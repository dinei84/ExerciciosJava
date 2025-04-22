package model.services;

import model.entities.Contrato;
import model.entities.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ServicoContrato {

    private Contrato contrato;
    private ServicoDePagamentoOnLine servico;

    public ServicoContrato(Contrato contrato, ServicoDePagamentoOnLine servico) {
        this.contrato = contrato;
        this.servico = servico;
    }

    public void processandoContrato(Contrato contrato, Integer meses){
        double valorBaseParcela = contrato.getValorTotal() / meses;

        for (int i = 1; i < meses + 1; i++) {
            double valorComJuros = servico.juros(valorBaseParcela, i);

            double valorFinal = valorComJuros + servico.taxaDePagamento(valorComJuros);

            Calendar cal = Calendar.getInstance();
            cal.setTime(contrato.getData());
            cal.add(Calendar.MONTH,i);
            Date dataParcela = cal.getTime();

            Parcela parcela = new Parcela(dataParcela, valorFinal);
            contrato.adicionarParcelas(parcela);
        }
     }
}
