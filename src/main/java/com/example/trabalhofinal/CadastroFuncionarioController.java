package com.example.trabalhofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import auxiliares.CriarSenha;
import dao.FuncionarioDAO;
import model.funcionario;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CadastroFuncionarioController implements Initializable {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView cadastrarImagem;

    @FXML
    private Label erroCPF;

    @FXML
    private Label erroConfirmarSenha;

    @FXML
    private Label erroNome;

    @FXML
    private Label erroSenha;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private AnchorPane retangulo;

    @FXML
    private AnchorPane retanguloEsquerda;

    @FXML
    private TextField textCPF;

    @FXML
    private PasswordField textConfirmarSenha;

    @FXML
    private TextField textNome;

    @FXML
    private PasswordField textSenha;
    public static boolean verificarStringNumerica(String testeCPF) {
        return Pattern.matches("[0-9]+",testeCPF);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoCadastrar.setOnMouseClicked((event)->{
            funcionario funcionario= new funcionario();
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            erroNome.setText(null);
            erroCPF.setText(null);
            erroSenha.setText(null);
            erroConfirmarSenha.setText(null);

            int criar = 0;
            if (textCPF.getText().isEmpty()){
                erroCPF.setText("Colocar o CPF!");
                criar = 1;
            }else {
                int com=0;
                String teste = textCPF.getText();
                if(11 == teste.length()){
                    if (verificarStringNumerica(teste)==true){
                        funcionario.setCPF(textCPF.getText());
                    }else {
                        erroCPF.setText("CPF não pode ter letras");
                        criar = 1;
                    }
                }else {
                    erroCPF.setText("CPF do tamanho errado");
                    criar = 1;
                }

            }
            if (textNome.getText().isEmpty()){
                erroNome.setText("Colocar o Nome!");
                criar = 1;
            }else {
                 funcionario.setNome(textNome.getText());
            }
            if (textSenha.getText().isEmpty()){
                erroSenha.setText("Colocar a Senha!");
                criar = 1;
            }else {
                if (textSenha.getText().equals(textConfirmarSenha.getText())){
                    String senha=textSenha.getText();
                    CriarSenha criarSenha = new CriarSenha();
                    try {
                        criarSenha.criarsenha(senha);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                    funcionario.setSenha(criarSenha.getSenhahex());
                }else {
                    erroConfirmarSenha.setText("Senhas não iguais!");
                    criar = 1;
                }
            }
            if (criar==0){
                funcionarioDAO.create(funcionario);
                PrincipalLoginFuncionario principalLoginFuncionario = new PrincipalLoginFuncionario();
                PrincipalCadastroFuncionario.getStage().close();
                try{
                    principalLoginFuncionario.start(new Stage());
                }catch (Exception e){

                }
            }else {
                criar = 0;
            }

        });
        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalLoginFuncionario principalLoginFuncionario = new PrincipalLoginFuncionario();
            PrincipalCadastroFuncionario.getStage().close();
            try{
                principalLoginFuncionario.start(new Stage());
            }catch (Exception e){

            }
        });
    }
}

