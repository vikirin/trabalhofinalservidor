package com.example.trabalhofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import dao.PizzaDAO;
import model.pizza;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarPizzaController implements Initializable {

    @FXML
    private Button botaoCriar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label criarTextoLabel;

    @FXML
    private TextField imagemTxt;

    @FXML
    private TextField nomeTxt;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private TextField valorTxt;

    @FXML
    private ImageView voltarImagem;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalCriarPizza.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
            PrincipalCriarPizza.getStage().close();
            try{
                principalPizzaFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoCriar.setOnMouseClicked((Event)->{
            pizza pizza = new pizza();
            PizzaDAO pizzaDAO = new PizzaDAO();
            int criar=0;
            if (nomeTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setNomeProduto(nomeTxt.getText());
            }
            if (valorTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setValor(Float.valueOf(valorTxt.getText()).floatValue());
            }
            if (imagemTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setImagem(imagemTxt.getText());
            }
            if (criar==0){
                pizzaDAO.create(pizza);
                PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
                PrincipalCriarPizza.getStage().close();
                try{
                    principalPizzaFuncionario.start(new Stage());
                }catch(Exception e){

                }
            }else {
                criar=0;
            }
        });
    }
}

