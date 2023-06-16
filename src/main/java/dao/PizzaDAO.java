package dao;

import model.pizza;
import config.connectionFactory;
import inter.ipizzaDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PizzaDAO implements ipizzaDAO {
    @Override
    public pizza create(pizza pizza) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pizza"
                    +"(nomeProduto,valor,image)"+
                    " VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pizza.getNomeProduto());
            statement.setFloat(2, pizza.getValor());
            statement.setString(3, pizza.getImagem());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPizzaGerado = resultSet.getLong(1);
            pizza.setIdPizza(idPizzaGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return pizza;
    }

    @Override
    public pizza update(pizza pizza) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pizza SET "
                    +"nomeProduto = ?,valor = ? ,image = ? "+
                    "WHERE idPizza = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pizza.getNomeProduto());
            statement.setFloat(2, pizza.getValor());
            statement.setString(3, pizza.getImagem());
            statement.setLong(4, pizza.getIdPizza());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pizza;
    }

    @Override
    public void delete(Long idPizza) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pizza WHERE idPizza = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPizza);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pizza> findall() {
        String query = "SElECT * FROM pizza";
        List<pizza> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pizza pizza =new pizza();
                pizza.setIdPizza(rs.getLong("idPizza"));
                pizza.setValor(rs.getFloat("valor"));
                pizza.setNomeProduto(rs.getString("nomeProduto"));
                pizza.setImagem(rs.getString("image"));
                lista.add(pizza);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pizza> findbyID(Long idPizza) {
        String query = "SELECT * FROM pizza WHERE idPizza = ?;";
        pizza pizza;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPizza);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pizza = new pizza(
                    rs.getString("nomeProduto"),
                    rs.getFloat("valor"),
                    rs.getLong("idPizza"),
                    rs.getString("image")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pizza);
    }
}
