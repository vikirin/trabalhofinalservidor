package dao;
import model.funcionario;
import config.connectionFactory;
import inter.ifuncionarioDAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuncionarioDAO implements ifuncionarioDAO  {
    @Override
    public funcionario create(funcionario funcionario) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO funcionario"
                    +"(nome,senha,CPF)"+
                    " VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,funcionario.getNome());
            statement.setString(2,funcionario.getSenha());
            statement.setString(3,funcionario.getCPF());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idFuncionarioGerado = resultSet.getLong(1);
            funcionario.setIdFuncionario(idFuncionarioGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return funcionario;
    }

    @Override
    public funcionario update(funcionario funcionario) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE funcionario SET "
                    +"nome = ? ,senha = ? ,CPF = ? "+
                    "WHERE idFuncionario = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,funcionario.getNome());
            statement.setString(2,funcionario.getSenha());
            statement.setString(3,funcionario.getCPF());
            statement.setLong(4,funcionario.getIdFuncionario());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return funcionario;
    }

    @Override
    public void delete(Long idfuncionario) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM funcionario WHERE idFuncionario = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idfuncionario);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<funcionario> findall() {
        String query = "SElECT * FROM funcionario";
        List<funcionario> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                funcionario funcionario =new funcionario();
                funcionario.setIdFuncionario(rs.getLong("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setCPF(rs.getString("CPF"));
                lista.add(funcionario);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<funcionario> findbyID(Long idfuncionario) {
        String query = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        funcionario funcionario;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idfuncionario);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            funcionario = new funcionario(
                    rs.getLong("idFuncionario "),
                    rs.getString("nome"),
                    rs.getString("CriarSenha"),
                    rs.getString("CPF")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(funcionario);
    }
}
