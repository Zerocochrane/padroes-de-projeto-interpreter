import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpretadorExpressaoTest {

    @Test
    void deveCalcularExpressaoICMS() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("100 ICMS");
        assertEquals(20, interpretador.interpretar());
    }

    @Test
    void deveCalcularExpressaoIPI() {
        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("100 IPI");
        assertEquals(4.0, interpretador.interpretar());
    }

    @Test
    void deveRetonarExcecaoElementoInvalido() {
        try {
            InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas("2 IOF");
            assertEquals(5.7, interpretador.interpretar());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

}