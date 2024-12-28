package Tarefa13;

public class PessoaJuridica extends Pessoa {
	private String NomeFantasia;
	private String RazaoSocial;
	private Integer CNPJ;
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	public Integer getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(Integer cNPJ) {
		CNPJ = cNPJ;
	}
}
