package projetoCrud.dao;

import java.util.Collection;
import projetoCrud.domain.OrdemDeServico;

public interface IOrdemDeServicoDAO {
	
	public Boolean cadastrar(OrdemDeServico ordemdeservico);
	
	public void excluir(Long OS);
	
	public void alterar(OrdemDeServico ordemdeservico);
	
	public OrdemDeServico consultar (Long OS);
	
	public Collection<OrdemDeServico> buscarTodos();
	

}
