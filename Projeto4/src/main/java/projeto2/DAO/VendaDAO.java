package projeto2.DAO;
import projeto2.domain.Cliente;
import projeto2.domain.Produto;
import projeto2.domain.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO extends GenericDAO<Venda> {

    public VendaDAO() {
        super();
    }

    @Override
    public Boolean cadastrar(Venda venda) {
        String sqlVenda = "INSERT INTO venda (id, cliente_id) VALUES (?, ?)";
        String sqlVendaProduto = "INSERT INTO venda_produto (venda_id, produto_id) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement stmtVenda = connection.prepareStatement(sqlVenda)) {
                stmtVenda.setLong(1, venda.getId());
                stmtVenda.setLong(2, venda.getCliente().getId());
                stmtVenda.executeUpdate();
            }

            try (PreparedStatement stmtVP = connection.prepareStatement(sqlVendaProduto)) {
                for (Produto produto : venda.getProdutos()) {
                    stmtVP.setLong(1, venda.getId());
                    stmtVP.setLong(2, produto.getId());
                    stmtVP.addBatch();
                }
                stmtVP.executeBatch();
            }

            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void excluir(Long id) {
        String sqlVendaProduto = "DELETE FROM venda_produto WHERE venda_id = ?";
        String sqlVenda = "DELETE FROM venda WHERE id = ?";

        try (PreparedStatement stmtVP = connection.prepareStatement(sqlVendaProduto);
             PreparedStatement stmtVenda = connection.prepareStatement(sqlVenda)) {

            stmtVP.setLong(1, id);
            stmtVP.executeUpdate();

            stmtVenda.setLong(1, id);
            stmtVenda.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(Venda venda) {
        excluir(venda.getId());
        cadastrar(venda);
    }

    @Override
    public Venda consultar(Long id) {
        String sqlVenda = "SELECT * FROM venda WHERE id = ?";
        String sqlProdutos = "SELECT p.* FROM produto p " +
                             "JOIN venda_produto vp ON p.id = vp.produto_id " +
                             "WHERE vp.venda_id = ?";

        try (
            PreparedStatement stmtVenda = connection.prepareStatement(sqlVenda);
            PreparedStatement stmtProdutos = connection.prepareStatement(sqlProdutos)
        ) {
            stmtVenda.setLong(1, id);
            ResultSet rsVenda = stmtVenda.executeQuery();

            if (rsVenda.next()) {
                Long clienteId = rsVenda.getLong("cliente_id");
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.consultar(clienteId);

                stmtProdutos.setLong(1, id);
                ResultSet rsProdutos = stmtProdutos.executeQuery();

                List<Produto> produtos = new ArrayList<>();
                while (rsProdutos.next()) {
                    Produto produto = new Produto();
                    produto.setId(rsProdutos.getLong("id"));
                    produto.setNome(rsProdutos.getString("nome"));
                    produto.setPreco(rsProdutos.getDouble("preco"));
                    produtos.add(produto);
                }

                return new Venda(id, cliente, produtos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Venda> buscarTodos() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT id FROM venda";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda venda = consultar(rs.getLong("id"));
                if (venda != null) {
                    vendas.add(venda);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }
}
