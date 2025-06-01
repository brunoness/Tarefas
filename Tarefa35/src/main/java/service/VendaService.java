package service;

import DAO.IVendaDAO;
import domain.Venda;
import domain.Venda.Status;

import java.util.Collection;

public class VendaService implements IVendaService {

    private IVendaDAO vendaDAO;

    public VendaService(IVendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    @Override
    public Venda cadastrar(Venda entity) {
        entity.setStatus(Status.INICIADA);
        return vendaDAO.cadastrar(entity);
    }

    @Override
    public void excluir(Venda entity) {
        vendaDAO.excluir(entity);
    }

    @Override
    public Venda alterar(Venda entity) {
        return vendaDAO.alterar(entity);
    }

    @Override
    public Venda consultar(Long id) {
        return vendaDAO.consultar(id);
    }

    @Override
    public Collection<Venda> buscarTodos() {
        return vendaDAO.buscarTodos();
    }

    @Override
    public Venda consultarComCollection(Long id) {
        return vendaDAO.consultarComCollection(id);
    }

    @Override
    public void finalizarVenda(Venda venda) {
        venda.setStatus(Status.CONCLUIDA);
        vendaDAO.finalizarVenda(venda);
    }

    @Override
    public void cancelarVenda(Venda venda) {
        venda.setStatus(Status.CANCELADA);
        vendaDAO.cancelarVenda(venda);
    }
}

