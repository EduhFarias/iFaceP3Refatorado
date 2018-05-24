package Functions;

public class Test {
    public enum condition{
        EDIT(1), CREATE(2), SEND(3), DISPLAYM(4), DISPLAUR(5), JOIN(6);

        private final int valor;

        condition(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }
}
