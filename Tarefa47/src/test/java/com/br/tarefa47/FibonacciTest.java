package com.br.tarefa47;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void testValoresPequenos() {
        Calculadora calc = new Calculadora();
        assertEquals(55, calc.fibonacciPublic(10));
        assertEquals(2, calc.fibonacciPublic(3));
        assertEquals(13, calc.fibonacciPublic(7));

    }

    @Test
    public void testCasoBaseUm() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.fibonacciPublic(1));
    }

    @Test
    public void testNumeroNegativo() {
        Calculadora calc = new Calculadora();
        assertEquals(-5, calc.fibonacciPublic(-5));
    };

}
