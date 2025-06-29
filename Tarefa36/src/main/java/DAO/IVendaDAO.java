package DAO;

import domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long> {

    public Venda consultarComCollection(Long id);

    public void finalizarVenda(Venda venda);

    public void cancelarVenda(Venda venda);

    // public Collection<Venda> buscarPorStatus(Status status);
}

