public class IPI {

    private double valor;

    public IPI(Numero valor){
        this.valor = valor.getNumero();
    }

    public double interpretar() {
        return valor * 0.057;
    }
}
