package exceptions;

public class DomainException extends Exception{


    public static class SaldoInsuficiente extends Exception {
        public SaldoInsuficiente(String msg) {
            super(msg);
        }
    }

    public static class LimiteSaqueExcedido extends Exception {
        public LimiteSaqueExcedido(String msg) {
            super(msg);
        }
    }

    public static class ValorInvalido extends Exception {
        public ValorInvalido(String msg) {
            super(msg);
        }
    }

    public static class ValorInseridoInvalido extends Exception{
        public ValorInseridoInvalido(String msg){super(msg);}
    }

}
