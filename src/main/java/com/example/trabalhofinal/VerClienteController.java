package com.example.trabalhofinal;

import dao.ClienteDAO;
import jasper.jaspercontrollercliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.cliente;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VerClienteController implements Initializable {

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label clienteLabel;

    @FXML
    private Label funcionariosLabel;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private ScrollPane scroll;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    String pronto="";
        cliente cliente =new cliente();
        ClienteDAO clienteDAO =new ClienteDAO();
        List<cliente> clienteList = clienteDAO.findall();

        for (cliente c : clienteList){
            pronto=pronto+"-> ID: "+c.getIdCliente()+"\n-> Nome: "+c.getNome()+"\n-> Nome de Usuário: "+c.getNomeconta()+"\n-------------------------------------------------------------------------------\n";
        }
        funcionariosLabel.setText(pronto);
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalVerCliente.getStage().close();
        });
        botaoRelatorio.setOnMouseClicked((event)->{
            jaspercontrollercliente jaspercontrollercliente =new jaspercontrollercliente();
            try {
                jaspercontrollercliente.gerarRelatorio();
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
        });
        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalMenuFuncionario principalMenuFuncionario = new PrincipalMenuFuncionario();
            PrincipalVerCliente.getStage().close();
            try{
                principalMenuFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });




    }
}
