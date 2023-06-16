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
import java.util.List;
import java.util.ResourceBundle;

public class EditarBebidasController implements Initializable {

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label editarLabel;

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
        bebida bebida = new bebida();
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<bebida> bebidaList = bebidaDAO.findall();
        for (bebida b : bebidaList){
            if (b.getIdBebida()==BebidasFuncionarioController.getIdbebida()){
                nomeTxt.setText(b.getNomeProduto());
                valorTxt.setText(b.getValor().toString());
                imagemTxt.setText(b.getImagem());
            }
        }
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalEditarBebidas.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
            PrincipalEditarBebidas.getStage().close();
            try{
                principalBebidasFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoEditar.setOnMouseClicked((event)->{
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
                bebida.setIdBebida(BebidasFuncionarioController.getIdbebida());
                bebidaDAO.update(bebida);
                PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
                PrincipalEditarBebidas.getStage().close();
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

