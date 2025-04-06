package br.com.bruno;

public class Carro<T> {
	private T Marca;
	private T Modelo;
	private Integer Potencia;
	
	public T getMarca() {
		return Marca;
	}
	public void setMarca(T marca) {
		Marca = marca;
	}
	public T getModelo() {
		return Modelo;
	}
	public void setModelo(T modelo) {
		Modelo = modelo;
	}
	public Integer getPotencia() {
		return Potencia;
	}
	public void setPotencia(Integer potencia) {
		Potencia = potencia;
	}
	
}
