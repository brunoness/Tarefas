package br.modulo1;

/**
 * @author Bruno Correia
 * Atestado de Saudo Ocupacional
 */

public class ASO {
	public int Id;
	public String namePaciente;
	public String date;
	public int cpf;
	public Boolean aptidao;
	public String medico;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNamePaciente() {
		return namePaciente;
	}
	public void setNamePaciente(String namePaciente) {
		this.namePaciente = namePaciente;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public Boolean getAptidao() {
		return aptidao;
	}
	public void setAptidao(Boolean aptidao) {
		this.aptidao = aptidao;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	
	public void checarAptidao(Boolean aptidao) {
		this.aptidao = aptidao;
		if (aptidao == false){
			System.out.println(aptidao + " Paciente não está apto.");
		} else {
			System.out.println(aptidao + " Paciente está apto.");
		}
			
	}
	
	public void fichaClinica() {
		System.out.println("ID: " + this.getId());
		System.out.println("Paciente: " + this.getNamePaciente());
		System.out.println("Data: " + this.getDate());
		System.out.println("Medico: " + this.getMedico());
	}
	
	
}
