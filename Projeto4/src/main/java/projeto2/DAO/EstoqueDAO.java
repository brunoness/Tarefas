package projeto2.DAO;

import projeto2.domain.Estoque;
import projeto2.domain.Produto;
import projeto2.DAO.jdbc.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO implements IGenericDAO<Estoque> {

    @Override
    public Boolean cadastrar(Estoque estoque) {
        String sql = "INSERT INTO estoque (id, produto_id, quantidade) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, estoque.getId());
            ps.setLong(2, estoque.getProduto().getId());
            ps.setInt(3, estoque.getQuantidade());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar estoque", e);
        }
    }

    @Override
    public void excluir(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM estoque WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir estoque", e);
        }
    }

    @Override
    public void alterar(Estoque estoque) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE estoque SET quantidade = ? WHERE id = ?")) {
            ps.setInt(1, estoque.getQuantidade());
            ps.setLong(2, estoque.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar estoque", e);
        }
    }

    @Override
    public Estoque consultar(Long id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM estoque WHERE id = ?")) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto produto = new ProdutoDAO().consultar(rs.getLong("produto_id"));
                return new Estoque(id, produto, rs.getInt("quantidade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar estoque", e);
        }
        return null;
    }

    @Override
    public List<Estoque> buscarTodos() {
        List<Estoque> estoques = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM estoque")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new ProdutoDAO().consultar(rs.getLong("produto_id"));
                Estoque estoque = new Estoque(
                    rs.getLong("id"),
                    produto,
                    rs.getInt("quantidade")
                );
                estoques.add(estoque);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar estoque", e);
        }
        return estoques;
    }
}