package service;

import domain.Venda;

public interface IVendaService extends IGenericService<Venda, Long> {

    public Venda consultarComCollection(Long id);

    public void finalizarVenda(Venda venda);

    public void cancelarVenda(Venda venda);

}

