package com.example.trabalhofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class MenuFuncionarioController implements Initializable {

    @FXML
    private Button botaoBebidas;

    @FXML
    private Button botaoCliente;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoPedido;

    @FXML
    private Button botaoPizza;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label funcionarioLabel;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private ImageView imagemVoltar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalMenuFuncionario.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalLoginFuncionario principalLoginFuncionario = new  PrincipalLoginFuncionario();
            PrincipalMenuFuncionario.getStage().close();
            try{
                principalLoginFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoPizza.setOnMouseClicked((event)->{
            PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
            PrincipalMenuFuncionario.getStage().close();
            try{
                principalPizzaFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoBebidas.setOnMouseClicked((event)->{
            PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
            PrincipalMenuFuncionario.getStage().close();
            try{
                principalBebidasFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoCliente.setOnMouseClicked((event)->{
            PrincipalVerCliente principalVerCliente = new PrincipalVerCliente();
            PrincipalMenuFuncionario.getStage().close();
            try{
                principalVerCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoPedido.setOnMouseClicked((event)->{
            PrincipalVerPedidos principalVerPedidos = new PrincipalVerPedidos();
            PrincipalMenuFuncionario.getStage().close();
            try{
                principalVerPedidos.start(new Stage());
            }catch(Exception e){

            }
        });
    }
}


