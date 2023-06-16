package com.example.trabalhofinal;

import dao.PizzaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.pizza;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditarPizzaController implements Initializable {

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label editarPizzaLabel;

    @FXML
    private TextField imagemTxt;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private TextField nomePizzaTxt;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private TextField valorPizzaTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizza pizza = new pizza();
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<pizza> pizzaList = pizzaDAO.findall();
        for (pizza p : pizzaList){
            if (p.getIdPizza()==PizzaFuncionarioController.getIdpizza()){
                nomePizzaTxt.setText(p.getNomeProduto());
                valorPizzaTxt.setText(p.getValor().toString());
                imagemTxt.setText(p.getImagem());
            }
        }

        botaoFechar.setOnMouseClicked((event)->{
            PrincipalEditarPizza.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
            PrincipalEditarPizza.getStage().close();
            try{
                principalPizzaFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoEditar.setOnMouseClicked((event)->{
            int criar=0;
            if (nomePizzaTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setNomeProduto(nomePizzaTxt.getText());
            }
            if (valorPizzaTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setValor(Float.valueOf(valorPizzaTxt.getText()).floatValue());
            }
            if (imagemTxt.getText().isEmpty()){
                criar=1;
            }else {
                pizza.setImagem(imagemTxt.getText());
            }
            if (criar==0){
                pizza.setIdPizza(PizzaFuncionarioController.getIdpizza());
                pizzaDAO.update(pizza);
                PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
                PrincipalEditarPizza.getStage().close();
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

