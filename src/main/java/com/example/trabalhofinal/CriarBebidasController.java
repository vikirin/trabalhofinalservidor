package com.example.trabalhofinal;

import dao.BebidaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.bebida;

import java.net.URL;
import java.util.ResourceBundle;

public class CriarBebidasController implements Initializable {

    @FXML
    private Button botaoCriar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label criarBebidasLabel;

    @FXML
    private TextField imagemTxt;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private TextField nomeTxt;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private TextField valorTxt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalCriarBebidas.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
            PrincipalCriarBebidas.getStage().close();
            try{
                principalBebidasFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });
        botaoCriar.setOnMouseClicked((event)->{
            bebida bebida = new bebida();
            BebidaDAO bebidaDAO = new BebidaDAO();
            int criar=0;
            if (nomeTxt.getText().isEmpty()){
                criar=1;
            }else {
                bebida.setNomeProduto(nomeTxt.getText());
            }
            if (valorTxt.getText().isEmpty()){
                criar=1;
            }else {
                bebida.setValor(Float.valueOf(valorTxt.getText()).floatValue());
            }
            if (imagemTxt.getText().isEmpty()){
                criar=1;
            }else {
                bebida.setImagem(imagemTxt.getText());
            }
            if (criar==0){
                bebidaDAO.create(bebida);
                PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
                PrincipalCriarBebidas.getStage().close();
                try{
                    principalBebidasFuncionario.start(new Stage());
                }catch(Exception e){

                }
            }else {
                criar=0;
            }
        });
    }
}

