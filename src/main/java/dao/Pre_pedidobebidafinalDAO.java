package dao;

import config.connectionFactory;
import inter.ipre_pedidobebidafinalDAO;
import model.pre_pedidobebidafinal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pre_pedidobebidafinalDAO implements ipre_pedidobebidafinalDAO {

    @Override
    public pre_pedidobebidafinal create(pre_pedidobebidafinal pre_pedidobebidafinal) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pre_pedidobebidafinal"
                    +"(quntidade,nomebebida,valortotal,idcliente,idBebida)"+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, pre_pedidobebidafinal.getQuantidade());
            statement.setString(2, pre_pedidobebidafinal.getNomebebida());
            statement.setFloat(3, pre_pedidobebidafinal.getValortotal());
            statement.setLong(4, pre_pedidobebidafinal.getIdclinte());
            statement.setLong(5, pre_pedidobebidafinal.getIdbebida());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPedidoGerado = resultSet.getLong(1);
            pre_pedidobebidafinal.setIdpedido(idPedidoGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return pre_pedidobebidafinal;
    }

    @Override
    public pre_pedidobebidafinal update(pre_pedidobebidafinal pre_pedidobebidafinal) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pre_pedidobebidafinal SET "
                    +"quntidade=?,nomebebida=?,valortotal=?,idcliente=?,idBebida=?"+
                    "WHERE idpedido = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, pre_pedidobebidafinal.getQuantidade());
            statement.setString(2,pre_pedidobebidafinal.getNomebebida());
            statement.setFloat(3, pre_pedidobebidafinal.getValortotal());
            statement.setLong(4, pre_pedidobebidafinal.getIdclinte());
            statement.setLong(5, pre_pedidobebidafinal.getIdbebida());
            statement.setLong(6, pre_pedidobebidafinal.getIdpedido());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pre_pedidobebidafinal;
    }

    @Override
    public void delete(Long idpedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pre_pedidobebidafinal WHERE idpedido = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idpedido);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pre_pedidobebidafinal> findall() {
        String query = "SElECT * FROM pre_pedidobebidafinal";
        List<pre_pedidobebidafinal> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pre_pedidobebidafinal pre_pedidobebidafinal =new pre_pedidobebidafinal();
                pre_pedidobebidafinal.setNomebebida(rs.getString("nomebebida"));
                pre_pedidobebidafinal.setValortotal(rs.getFloat("valortotal"));
                pre_pedidobebidafinal.setQuantidade(rs.getLong("quntidade"));
                pre_pedidobebidafinal.setIdpedido(rs.getLong("idpedido"));
                pre_pedidobebidafinal.setIdbebida(rs.getLong("idbebida"));
                pre_pedidobebidafinal.setIdclinte(rs.getLong("idcliente"));
                lista.add(pre_pedidobebidafinal);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pre_pedidobebidafinal> findbyID(Long idpedido) {
        String query = "SELECT * FROM pre_pedidobebidafinal WHERE idpedido = ?;";
        pre_pedidobebidafinal pre_pedidobebidafinal;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idpedido);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pre_pedidobebidafinal = new pre_pedidobebidafinal(
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
        return Optional.ofNullable(pre_pedidobebidafinal);
    }
}
