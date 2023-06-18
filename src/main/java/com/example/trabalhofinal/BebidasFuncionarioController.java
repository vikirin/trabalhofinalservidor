package com.example.trabalhofinal;

import com.example.trabalhofinal.dao.BebidaDAO;
import com.example.trabalhofinal.dao.Pre_pedidobebidaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import com.example.trabalhofinal.model.bebida;
import com.example.trabalhofinal.model.pre_pedidobebida;
import com.example.trabalhofinal.jasper.jaspercontrollerbebida;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BebidasFuncionarioController implements Initializable {


    @FXML
    private Label avisoLabel;

    @FXML
    private Button botaoCriar;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView imagemVta;

    @FXML
    private Label listaB;

    @FXML
    private ScrollPane listagemb;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private Label pizzaLabel;

    @FXML
    private TextField usuarioText;

    private static long idbebida;

    public static long getIdbebida() {
        return idbebida;
    }

    String lisB="";
    public static void setIdbebida(long idbebida) {
        BebidasFuncionarioController.idbebida = idbebida;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bebida bebida = new bebida();
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<bebida> bebidaList = bebidaDAO.findall();
        for(bebida b : bebidaList){
            lisB=lisB+"-> Bebida: "+b.getNomeProduto()+"\nValor: R$"+b.getValor()+"\n-> ID: "+b.getIdBebida()+"\n-------------------------------------------------------------------------------\n";
        }
        listaB.setText(lisB);


        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalMenuFuncionario principalMenuFuncionario = new PrincipalMenuFuncionario();
            PrincipalBebidasFuncionario.getStage().close();
            try{
                principalMenuFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoFechar.setOnMouseClicked((event)->{
            PrincipalBebidasFuncionario.getStage().close();
        });

        botaoCriar.setOnMouseClicked((event)->{
            PrincipalCriarBebidas principalCriarBebidas = new PrincipalCriarBebidas();
            PrincipalBebidasFuncionario.getStage().close();
            try{
                principalCriarBebidas.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoEditar.setOnMouseClicked((event)->{
            setIdbebida(Long.parseLong(usuarioText.getText()));
            PrincipalEditarBebidas principalEditarBebidas = new PrincipalEditarBebidas();
            PrincipalBebidasFuncionario.getStage().close();
            try{
                principalEditarBebidas.start(new Stage());
            }catch(Exception e){

            }

        });

        botaoDeletar.setOnMouseClicked((event)->{

            pre_pedidobebida prePedidobebida = new pre_pedidobebida();
            Pre_pedidobebidaDAO pre_PedidobebidaDAO = new Pre_pedidobebidaDAO();
            List<pre_pedidobebida> prePedidobebidaList = pre_PedidobebidaDAO.findall();
            for (bebida b : bebidaList){
                if (b.getIdBebida()==Long.valueOf(usuarioText.getText())){
                    bebidaDAO.delete(Long.valueOf(usuarioText.getText()));
                    avisoLabel.setTextFill(Paint.valueOf("#62d753"));
                    avisoLabel.setText("Bebida deletada com sucesso!");
                    for (pre_pedidobebida beb : prePedidobebidaList){
                        if (beb.getIdbebida()==Long.valueOf(usuarioText.getText())){
                            pre_PedidobebidaDAO.delete(beb.getIdpedido());
                        }
                    }
                    PrincipalBebidasFuncionario principalBebidasFuncionario = new PrincipalBebidasFuncionario();
                    PrincipalBebidasFuncionario.getStage().close();
                    try{
                        principalBebidasFuncionario.start(new Stage());
                    }catch(Exception e){

                    }
                }
                else{
                    avisoLabel.setTextFill(Paint.valueOf("#ff0000"));
                    avisoLabel.setText("Bebida não deletada!");
                }
            }
        });
        botaoRelatorio.setOnMouseClicked((event)->{
            jaspercontrollerbebida jaspercontrollerbebida =new jaspercontrollerbebida();
            try {
                jaspercontrollerbebida.gerarRelatorio();
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
