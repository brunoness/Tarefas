package projetoCrud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import projetoCrud.domain.OrdemDeServico;

public class OrdemDeServicoMapDAO implements IOrdemDeServicoDAO {

	private Map<Long, OrdemDeServico> map;
	
	public OrdemDeServicoMapDAO() {
		this.map = new HashMap<>();
	}
	
	@Override
	public Boolean cadastrar(OrdemDeServico ordemdeservico) {
		if (this.map.containsKey(ordemdeservico.getOS())) {
			return false;
		}
		this.map.put(ordemdeservico.getOS(), ordemdeservico);
		return true;
	}

	@Override
	public void excluir(Long OS) {
		OrdemDeServico osCadastrada = this.map.get(OS);
		
		if (osCadastrada != null) {
			this.map.remove(osCadastrada.getOS(), osCadastrada);
		}
	}

	@Override
	public void alterar(OrdemDeServico ordemdeservico) {
		OrdemDeServico osCadastrada = this.map.get(ordemdeservico.getOS());
		
		if (osCadastrada != null) {
			osCadastrada.setDefeito(ordemdeservico.getDefeito());
			osCadastrada.setSolucao(ordemdeservico.getSolucao());
			osCadastrada.setEquipamento(ordemdeservico.getEquipamento());
		}
		
	}

	@Override
	public OrdemDeServico consultar(Long OS) {
		return this.map.get(OS);
	}

	@Override
	public Collection<OrdemDeServico> buscarTodos() {
		return this.map.values();
	}

}
