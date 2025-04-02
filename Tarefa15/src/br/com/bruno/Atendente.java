package br.com.bruno;

public class Atendente {
	private String gradeRequest;
    private boolean tipoDeContrato;

    public Atendente(String gradeRequest, boolean tipoDeContrato) {
        this.gradeRequest= gradeRequest;
        this.tipoDeContrato = tipoDeContrato;
    }
    public boolean tipoDeContrato() {
        return tipoDeContrato;
    }
    public String getGradeRequest() {
        return gradeRequest;
    }
}
