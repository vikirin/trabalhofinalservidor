package com.example.trabalhofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import auxiliares.CriarSenha;
import dao.FuncionarioDAO;

import model.funcionario;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFuncionarioController implements Initializable {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Label erroLabel;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private AnchorPane retanguloBaixo;

    @FXML
    private AnchorPane retanguloCima;

    @FXML
    private TextField textNome;

    @FXML
    private PasswordField textSenha;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoCadastrar.setOnMouseClicked((event)->{
            PrincipalCadastroFuncionario principalCadastroFuncionario = new PrincipalCadastroFuncionario();
            PrincipalLoginFuncionario.getStage().close();
            try{
                principalCadastroFuncionario.start(new Stage());
            }catch (Exception e){

            }
        });

        botaoEntrar.setOnMouseClicked((event)->{
            erroLabel.setText(null);
            funcionario funcionario =new funcionario();
            FuncionarioDAO funcionarioDAO =new FuncionarioDAO();
            List<funcionario> funcionarioList = funcionarioDAO.findall();
            String senha=textSenha.getText();
            CriarSenha criarSenha = new CriarSenha();
            try {
                criarSenha.criarsenha(senha);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            for (funcionario f : funcionarioList){
                if (f.getCPF().equals(textNome.getText())&& f.getSenha().equals(criarSenha.getSenhahex())){
                    PrincipalMenuFuncionario principalMenuFuncionario = new PrincipalMenuFuncionario();
                    PrincipalLoginFuncionario.getStage().close();
                    try{
                        principalMenuFuncionario.start(new Stage());
                    }catch(Exception e){

                    }
                }else {
                    erroLabel.setText("CPF ou Senha incorreto!");
                }
            }

        });
    }
}

