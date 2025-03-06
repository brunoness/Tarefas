package projetoCrud.domain;

import java.util.Objects;

public class OrdemDeServico {

	private Long OS;
	private String equipamento;
	private String defeito;
	private String solucao;
	
	public OrdemDeServico(String OS, String equipamento, String defeito, String solucao) {
		this.OS = Long.valueOf(OS.trim());
		this.equipamento = equipamento;
		this.defeito = defeito;
		this.solucao = solucao;
	}

	public Long getOS() {
		return OS;
	}

	public void setOS(Long oS) {
		OS = oS;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(OS);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemDeServico other = (OrdemDeServico) obj;
		return Objects.equals(OS, other.OS);
	}

	@Override
	public String toString() {
		return "OrdemDeServico [OS=" + OS + ", defeito=" + defeito + ", solucao=" + solucao + "]";
	}
	
	
}

