package dao;

import config.connectionFactory;
import inter.ipre_pedidopizzafinalDAO;
import model.pre_pedidopizzafinal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pre_pedidopizzafinalDAO implements ipre_pedidopizzafinalDAO {
    @Override
    public pre_pedidopizzafinal create(pre_pedidopizzafinal pre_pedidopizzafinal) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pre_pedidopizzafinal"
                    +"(tamanho,sabor,valortotal,idcliente,idPizza)"+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pre_pedidopizzafinal.getTamanho());
            statement.setString(2, pre_pedidopizzafinal.getSabor());
            statement.setFloat(3, pre_pedidopizzafinal.getValortotal());
            statement.setLong(4, pre_pedidopizzafinal.getIdcliente());
            statement.setLong(5, pre_pedidopizzafinal.getIdPizza());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPedidoGerado = resultSet.getLong(1);
            pre_pedidopizzafinal.setIdPedido(idPedidoGerado);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidopizzafinal;
    }

    @Override
    public pre_pedidopizzafinal update(pre_pedidopizzafinal pre_pedidopizzafinal) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pre_pedidopizzafinal SET "
                    +"tamanho = ?,sabor = ?,valortotal = ?," +
                    "idcliente = ?, idPizza = ? "+
                    "WHERE id_Pedido = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pre_pedidopizzafinal.getTamanho());
            statement.setString(2, pre_pedidopizzafinal.getSabor());
            statement.setFloat(3, pre_pedidopizzafinal.getValortotal());
            statement.setLong(4, pre_pedidopizzafinal.getIdcliente());
            statement.setLong(5, pre_pedidopizzafinal.getIdPizza());
            statement.setLong(6, pre_pedidopizzafinal.getIdPedido());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidopizzafinal;
    }

    @Override
    public void delete(Long idPedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pre_pedidopizzafinal WHERE id_Pedido = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pre_pedidopizzafinal> findall() {
        String query = "SElECT * FROM pre_pedidopizzafinal";
        List<pre_pedidopizzafinal> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pre_pedidopizzafinal pre_pedidopizzafinal =new pre_pedidopizzafinal();
                pre_pedidopizzafinal.setTamanho(rs.getString("tamanho"));
                pre_pedidopizzafinal.setSabor(rs.getString("sabor"));
                pre_pedidopizzafinal.setValortotal(rs.getFloat("valortotal"));
                pre_pedidopizzafinal.setIdPedido(rs.getLong("id_Pedido"));
                pre_pedidopizzafinal.setIdPizza((rs.getLong("idPizza")));
                pre_pedidopizzafinal.setIdcliente(rs.getLong("idcliente"));
                lista.add(pre_pedidopizzafinal);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pre_pedidopizzafinal> findbyID(Long idPedido) {
        String query = "SELECT * FROM pre_pedidopizzafinal WHERE id_Pedido = ?;";
        pre_pedidopizzafinal pre_pedidopizzafinal;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pre_pedidopizzafinal = new pre_pedidopizzafinal(
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
        return Optional.ofNullable(pre_pedidopizzafinal);
    }
}
