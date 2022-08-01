public class ICMS {

    private double valor;

    public ICMS(Numero valor){
        this.valor = valor.getNumero();
    }

    public double interpretar() {
        return valor * 0.2;
    }
}
