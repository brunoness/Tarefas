package br.com.rpires.dao.mocks;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoDaoMock implements IContratoDao {

    @Override
    public void salvar() {

    }
    
    @Override
    public String buscar(String id) {
        return "Contrato encontrado";
    }

	@Override
	public String excluir(String id) {
		return "Contrato excluido";
	}
	
	@Override
    public String atualizar(String id) {
        return "Contrato atualizado";
    }
}
