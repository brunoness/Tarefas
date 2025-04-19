package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public interface IContratoDao {
    void salvar();
    
    String buscar(String id);
    
    String excluir(String id);
    
    String atualizar(String id);
    
    //TODO
    //Fazer métodos de buscar X, excluir X e atualizar X
	
}
