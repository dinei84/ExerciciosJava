package exceptions;

public class DomainException extends Exception{


    public static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String msg) {
            super(msg);
        }
    }

    public static class LimiteSaqueExcedidoException extends Exception {
        public LimiteSaqueExcedidoException(String msg) {
            super(msg);
        }
    }

    public static class ValorInvalidoException extends Exception {
        public ValorInvalidoException(String msg) {
            super(msg);
        }
    }

}
