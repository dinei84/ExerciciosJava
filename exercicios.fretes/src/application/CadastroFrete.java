package application;

import java.util.ArrayList;
import java.util.List;

import entities.Frete;

public class CadastroFrete {
    
    private List<Frete> frete = new ArrayList<>();
    private List<CadastroDeCarga> cadastroCargas = new ArrayList<>();

    public List<Frete> getFrete() {
        return frete;
    }
    public List<CadastroDeCarga> getCadastroCargas() {
        return cadastroCargas;
    }
    public void addFrete(Frete frete){
        this.frete.add(frete);
    }
    public void deleteFrete(Frete frete){
        this.frete.remove(frete);
    }

}
