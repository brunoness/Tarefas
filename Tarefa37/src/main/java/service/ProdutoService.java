package service;

import DAO.IProdutoDAO;
import domain.Produto;

import java.util.Collection;

public class ProdutoService implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Produto cadastrar(Produto entity) {
        return produtoDAO.cadastrar(entity);
    }

    @Override
    public void excluir(Produto entity) {
        produtoDAO.excluir(entity);
    }

    @Override
    public Produto alterar(Produto entity) {
        return produtoDAO.alterar(entity);
    }

    @Override
    public Produto consultar(Long id) {
        return produtoDAO.consultar(id);
    }

    @Override
    public Collection<Produto> buscarTodos() {
        return produtoDAO.buscarTodos();
    }
}

