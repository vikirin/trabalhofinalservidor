package dao;

import config.connectionFactory;
import inter.ipre_pedidopizzaDAO;
import model.pre_pedidopizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pre_pedidopizzaDAO implements ipre_pedidopizzaDAO {
    @Override
    public pre_pedidopizza create(pre_pedidopizza pre_pedidopizza) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pre_pedidopizza"
                    +"(tamanho,sabor,valortotal,idcliente,idPizza)"+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pre_pedidopizza.getTamanho());
            statement.setString(2, pre_pedidopizza.getSabor());
            statement.setFloat(3, pre_pedidopizza.getValortotal());
            statement.setLong(4, pre_pedidopizza.getIdcliente());
            statement.setLong(5, pre_pedidopizza.getIdPizza());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPedidoGerado = resultSet.getLong(1);
            pre_pedidopizza.setIdPedido(idPedidoGerado);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidopizza;
    }

    @Override
    public pre_pedidopizza update(pre_pedidopizza pre_pedidopizza) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pre_pedidopizza SET "
                    +"tamanho = ?,sabor = ?,valortotal = ?," +
                    "idcliente = ?, idPizza = ? "+
                    "WHERE id_Pedido = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pre_pedidopizza.getTamanho());
            statement.setString(2, pre_pedidopizza.getSabor());
            statement.setFloat(3, pre_pedidopizza.getValortotal());
            statement.setLong(4, pre_pedidopizza.getIdcliente());
            statement.setLong(5, pre_pedidopizza.getIdPizza());
            statement.setLong(6, pre_pedidopizza.getIdPedido());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidopizza;
    }

    @Override
    public void delete(Long idPedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pre_pedidopizza WHERE id_Pedido = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pre_pedidopizza> findall() {
        String query = "SElECT * FROM pre_pedidopizza";
        List<pre_pedidopizza> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pre_pedidopizza pre_pedidopizza =new pre_pedidopizza();
                pre_pedidopizza.setTamanho(rs.getString("tamanho"));
                pre_pedidopizza.setSabor(rs.getString("sabor"));
                pre_pedidopizza.setValortotal(rs.getFloat("valortotal"));
                pre_pedidopizza.setIdPedido(rs.getLong("id_Pedido"));
                pre_pedidopizza.setIdPizza((rs.getLong("idPizza")));
                pre_pedidopizza.setIdcliente(rs.getLong("idcliente"));
                lista.add(pre_pedidopizza);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pre_pedidopizza> findbyID(Long idPedido) {
        String query = "SELECT * FROM pre_pedidopizza WHERE id_Pedido = ?;";
        pre_pedidopizza pre_pedidopizza;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pre_pedidopizza = new pre_pedidopizza(
                    rs.getString("tamanho"),
                    rs.getString("sabor"),
                    rs.getFloat("valortotal"),
                    rs.getLong("id_Pedido"),
                    rs.getLong("idPizza"),
                    rs.getLong("idcliente")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pre_pedidopizza);
    }
}
