package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
    
    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }


    public long duracao(){
        long diferenca = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public void atualizaData(Date checkIn, Date checkOut){
        Date agora = new Date();
        if (checkIn.before(agora) || checkOut.before(agora)){
            throw new IllegalArgumentException("As datas de reserva para atualizações devem ser datas futuras");
        }
        if (!checkOut.after(checkIn)){
            throw new IllegalArgumentException("A data deve ser posterior à data de check-in");
        }


        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto " +
                "\nNumero do Quarto: " + numeroQuarto +
                "\nCheck-in: " + sdf.format(checkIn) +
                "\nCheck-out: " + sdf.format(checkOut) +
                "\nDuração: " + duracao() + " noites";
    }

}
