package br.com.rpires.dao;

/**
 * @author rodrigo.pires
 */
public class ContratoDao implements IContratoDao {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }
    
    @Override
    public String buscar(String id) {
        throw new UnsupportedOperationException("Não implementado.");
    }

	@Override
	public String excluir(String id) {
		throw new UnsupportedOperationException("Não implementado.");		
	}
	
	@Override
    public String atualizar(String id) {
        throw new UnsupportedOperationException("Não implementado.");
    }
}
