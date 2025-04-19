package br.com.rpires.service;

/**
 * @author rodrigo.pires
 */
public interface IContratoService {
    String salvar();

	String buscar(String id);

	String excluir(String id);

	String atualizar(String id);

    //TODO
    //Fazer métodos de buscar X, excluir e atualizar
}
