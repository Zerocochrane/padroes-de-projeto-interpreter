import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesAritmeticas implements InterpretadorExpressao {

    private InterpretadorExpressao interpretadorInicial;

    public InterpretadorExpressoesAritmeticas(String contexto) {

        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.matches("\\d+(\\.\\d*)?")) {
                pilhaInterpretadores.push(new Numero(Double.parseDouble(elemento)));
            } else if (elemento.equals("ICMS")) {
                Numero valor = (Numero) pilhaInterpretadores.pop();
                ICMS interpretador = new ICMS(valor);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            } else if (elemento.equals("IPI")) {
                Numero valor = (Numero) pilhaInterpretadores.pop();
                IPI interpretador = new IPI(valor);
                pilhaInterpretadores.push(new Numero(interpretador.interpretar()));
            }else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    public double interpretar() {
        return interpretadorInicial.interpretar();
    }
}