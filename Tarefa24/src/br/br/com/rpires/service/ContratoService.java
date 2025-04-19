package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * @author rodrigo.pires
 */
public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }
    
    @Override
    public String buscar(String id) {
    	return contratoDao.buscar(id);
    }

	@Override
	public String excluir(String id) {
		// TODO Auto-generated method stub
		return contratoDao.excluir(id);
	}

	@Override
	public String atualizar(String id) {
		// TODO Auto-generated method stub
		return contratoDao.atualizar(id);
	}
}
