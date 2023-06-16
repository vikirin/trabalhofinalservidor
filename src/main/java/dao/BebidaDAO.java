package dao;

import config.connectionFactory;
import inter.ibebidaDAO;
import model.bebida;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BebidaDAO implements ibebidaDAO {
    @Override
    public bebida create(bebida bebida) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO bebida"
                    +"(nomeProduto,valor,image)"+
                    " VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bebida.getNomeProduto());
            statement.setFloat(2, bebida.getValor());
            statement.setString(3, bebida.getImagem());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idBebidaGerado = resultSet.getLong(1);
            bebida.setIdBebida(idBebidaGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return bebida;
    }

    @Override
    public bebida update(bebida bebida) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE bebida SET "
                    +"nomeProduto = ?,valor = ? ,image = ? "+
                    "WHERE idBebida = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, bebida.getNomeProduto());
            statement.setFloat(2, bebida.getValor());
            statement.setString(3, bebida.getImagem());
            statement.setLong(4, bebida.getIdBebida());

            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return bebida;
    }

    @Override
    public void delete(Long idBebida) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM bebida WHERE idBebida = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idBebida);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<bebida> findall() {
        String query = "SElECT * FROM bebida";
        List<bebida> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                bebida bebida =new bebida();
                bebida.setIdBebida(rs.getLong("idBebida"));
                bebida.setValor(rs.getFloat("valor"));
                bebida.setNomeProduto(rs.getString("nomeProduto"));
                bebida.setImagem(rs.getString("image"));
                lista.add(bebida);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<bebida> findbyID(Long idProduto) {
        String query = "SELECT * FROM bebida WHERE idBebida = ?;";
        bebida bebida;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idProduto);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            bebida = new bebida(
                    rs.getString("nomeProduto"),
                    rs.getFloat("valor"),
                    rs.getLong("idBebida"),
                    rs.getString("image")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(bebida);
    }
}
