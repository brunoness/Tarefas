package com.bruno;

import com.bruno.model.Elemento;
import com.bruno.service.PilhaService;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilhaServiceTest {

    private PilhaService pilhaService;

    @Before
    public void setUp() {
        pilhaService = new PilhaService();
    }

    @Test
    public void testEmpilhar() {
        Elemento e = new Elemento("teste");
        pilhaService.empilhar(e);
        assertEquals(1, pilhaService.tamanho());
        assertEquals("teste", pilhaService.topo().getValor());
    }

    @Test
    public void testDesempilhar() {
        pilhaService.empilhar(new Elemento("um"));
        Elemento desempilhado = pilhaService.desempilhar();
        assertEquals("um", desempilhado.getValor());
        assertTrue(pilhaService.estaVazia());
    }

    @Test
    public void testTopoVazio() {
        assertNull(pilhaService.topo());
    }

    @Test
    public void testTamanho() {
        assertEquals(0, pilhaService.tamanho());
        pilhaService.empilhar(new Elemento("x"));
        assertEquals(1, pilhaService.tamanho());
    }
}