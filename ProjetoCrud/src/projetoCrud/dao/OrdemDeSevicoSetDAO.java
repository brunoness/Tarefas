package projetoCrud.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import projetoCrud.domain.OrdemDeServico;

public class OrdemDeSevicoSetDAO implements IOrdemDeServicoDAO {

	private Set<OrdemDeServico> set;
	
	public OrdemDeSevicoSetDAO() {
        this.set = new HashSet<>();
    }
	
	 @Override
	    public Boolean cadastrar(OrdemDeServico ordemdeservico) {
	        return this.set.add(ordemdeservico);
	 }
	 
	 @Override
	    public void excluir(Long OS) {
		 OrdemDeServico ordemdeservicoEncontrada = null;
	        for (OrdemDeServico ordemdeservico : this.set) {
	            if (ordemdeservico.getOS().equals(OS)) {
	            	ordemdeservicoEncontrada = ordemdeservico;
	                break;
	            }
	        }
	        
	        if (ordemdeservicoEncontrada != null) {
	            this.set.remove(ordemdeservicoEncontrada);
	        }
	 }
	 
	 @Override
	    public OrdemDeServico consultar(Long OS) {
	        for (OrdemDeServico ordemdeservicoCadastrada : this.set) {
	             if (ordemdeservicoCadastrada.getOS().equals(OS)) {
	                 return ordemdeservicoCadastrada;
	             }
	        }
	        return null;
	    }

	    @Override
	    public Collection<OrdemDeServico> buscarTodos() {
	        return this.set;
	    }
	    
	    @Override
	    public void alterar(OrdemDeServico ordemdeservico) {
	        if (this.set.contains(ordemdeservico)) {
	            for (OrdemDeServico ordemdeservicoCadastrada : this.set) {
	                if (ordemdeservicoCadastrada.equals(ordemdeservico)) {
	                	ordemdeservicoCadastrada.setEquipamento(ordemdeservico.getEquipamento());
	                	ordemdeservicoCadastrada.setDefeito(ordemdeservico.getDefeito());
	                	ordemdeservicoCadastrada.setSolucao(ordemdeservico.getSolucao());
	                    break;
	                }
	            }
	        }
	    }
}
