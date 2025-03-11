package application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entities.OrderItem;
import enums.OrderStatus;

public class Order {

    private Date momento;
    private OrderStatus ordem;

    private List<OrderItem> itens = new ArrayList<>();

    public Order() {
    }

    public Order(Date momento, OrderStatus ordem) {
        this.momento = momento;
        this.ordem = ordem;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrderStatus getOrdem() {
        return ordem;
    }

    public void setOrdem(OrderStatus ordem) {
        this.ordem = ordem;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    

    


    
}
