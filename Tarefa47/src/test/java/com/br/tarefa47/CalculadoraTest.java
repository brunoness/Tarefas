package com.br.tarefa47;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void testAdicionar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.somarPublic(2, 3));
        assertEquals(-1, calc.somarPublic(-2, 1));
        assertEquals(0, calc.somarPublic(0, 0));
    }

    @Test
    public void testSubtrair() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.subtrairPublic(3, 2));
        assertEquals(-3, calc.subtrairPublic(-2, 1));
    }

    @Test
    public void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.multiplicarPublic(2, 3));
        assertEquals(0, calc.multiplicarPublic(0, 5));
        assertEquals(-8, calc.multiplicarPublic(-2, 4));
    }

    @Test
    public void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.dividirPublic(6, 3));
        assertEquals(-3, calc.dividirPublic(-6, 2));
    }

    @Test
    public void testDividirPorZero() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calc.dividirPublic(5, 0));
    }
}





