package br.com.bruno;

public abstract class Carro {
    private String modelo;
    private int ano;
    private int potencia;

    public Carro(String modelo, int ano, int potencia) {
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
    }

    public abstract void exibirMarca();

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }
    
    public int getPotencia() {
        return potencia;
    }
}
