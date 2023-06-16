package dao;

import config.connectionFactory;
import inter.ipre_pedidobebidaDAO;
import model.pre_pedidobebida;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pre_pedidobebidaDAO implements ipre_pedidobebidaDAO {

    @Override
    public pre_pedidobebida create(pre_pedidobebida pre_pedidobebida) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pre_pedidobebida"
                    +"(quntidade,nomebebida,valortotal,idcliente,idBebida)"+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, pre_pedidobebida.getQuantidade());
            statement.setString(2, pre_pedidobebida.getNomebebida());
            statement.setFloat(3, pre_pedidobebida.getValortotal());
            statement.setLong(4, pre_pedidobebida.getIdclinte());
            statement.setLong(5, pre_pedidobebida.getIdbebida());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPedidoGerado = resultSet.getLong(1);
            pre_pedidobebida.setIdpedido(idPedidoGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return pre_pedidobebida;
    }

    @Override
    public pre_pedidobebida update(pre_pedidobebida pre_pedidobebida) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pre_pedidobebida SET "
                    +"quntidade=?,nomebebida=?,valortotal=?,idcliente=?,idBebida=?"+
                    "WHERE idpedido = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, pre_pedidobebida.getQuantidade());
            statement.setString(2,pre_pedidobebida.getNomebebida());
            statement.setFloat(3, pre_pedidobebida.getValortotal());
            statement.setLong(4, pre_pedidobebida.getIdclinte());
            statement.setLong(5, pre_pedidobebida.getIdbebida());
            statement.setLong(6, pre_pedidobebida.getIdpedido());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidobebida;
    }

    @Override
    public void delete(Long idpedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pre_pedidobebida WHERE idpedido = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idpedido);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pre_pedidobebida> findall() {
        String query = "SElECT * FROM pre_pedidobebida";
        List<pre_pedidobebida> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pre_pedidobebida pre_pedidobebida =new pre_pedidobebida();
                pre_pedidobebida.setNomebebida(rs.getString("nomebebida"));
                pre_pedidobebida.setValortotal(rs.getFloat("valortotal"));
                pre_pedidobebida.setQuantidade(rs.getLong("quntidade"));
                pre_pedidobebida.setIdpedido(rs.getLong("idpedido"));
                pre_pedidobebida.setIdbebida(rs.getLong("idbebida"));
                pre_pedidobebida.setIdclinte(rs.getLong("idcliente"));
                lista.add(pre_pedidobebida);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pre_pedidobebida> findbyID(Long idpedido) {
        String query = "SELECT * FROM pre_pedidobebida WHERE idpedido = ?;";
        pre_pedidobebida pre_pedidobebida;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idpedido);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pre_pedidobebida = new pre_pedidobebida(
                    rs.getString("nomebebida"),
                    rs.getFloat("valortotal"),
                    rs.getLong("quntidade"),
                    rs.getLong("idpedido"),
                    rs.getLong("idbebida"),
                    rs.getLong("idcliente")
            );
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pre_pedidobebida);
    }
}
