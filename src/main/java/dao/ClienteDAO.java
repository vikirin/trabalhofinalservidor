package dao;

import config.connectionFactory;
import inter.iclienteDAO;
import model.cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO implements iclienteDAO {
    @Override
    public cliente create(cliente cliente) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO cliente"
                    +"(nome,senha,nomeConta)"+
                    " VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,cliente.getNome());
            statement.setString(2,cliente.getSenha());
            statement.setString(3,cliente.getNomeconta());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long IdClienteGerado = resultSet.getLong(1);
            cliente.setIdCliente(IdClienteGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public cliente update(cliente cliente) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE cliente SET "
                    +"nome=?,senha=?,nomeConta=? "+
                    "WHERE idCliente = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,cliente.getNome());
            statement.setString(2,cliente.getSenha());
            statement.setString(3,cliente.getNomeconta());
            statement.setLong(4,cliente.getIdCliente());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return cliente;
    }

    @Override
    public void delete(Long idCliente) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM cliente WHERE idCliente = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idCliente);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<cliente> findall() {
        String query = "SElECT * FROM cliente";
        List<cliente> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                cliente cliente =new cliente();
                cliente.setIdCliente(rs.getLong("idCliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setNomeconta(rs.getString("nomeConta"));
                lista.add(cliente);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<cliente> findbyID(Long idCliente) {
        String query = "SELECT * FROM cliente WHERE idCliente = ?";
        cliente cliente;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idCliente);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            cliente = new cliente(
                    rs.getLong("idCliente"),
                    rs.getString("nome"),
                    rs.getString("senha"),
                    rs.getString("nomeConta")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(cliente);
    }
}
