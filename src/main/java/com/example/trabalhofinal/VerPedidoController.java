package com.example.trabalhofinal;

import com.example.trabalhofinal.dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.example.trabalhofinal.model.cliente;
import com.example.trabalhofinal.model.pre_pedidopizzafinal;
import com.example.trabalhofinal.model.pre_pedidobebidafinal;

import com.example.trabalhofinal.dao.Pre_pedidobebidafinalDAO;
import com.example.trabalhofinal.dao.Pre_pedidopizzafinalDAO;

import com.example.trabalhofinal.jasper.jaspercontrollerpedidosfinal;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VerPedidoController implements Initializable {

    @FXML
    private Label bebidaLabel;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoRelatorio;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private Label lisbebida;

    @FXML
    private Label lispizza;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private Label pedidoLabel;

    @FXML
    private Label pizzaLabel;

    @FXML
    private ScrollPane scrollbebida;

    @FXML
    private ScrollPane scrollpiz;

    String pizza = "" ,bebida = "" ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cliente cliente = new cliente();
        ClienteDAO clienteDAO =new ClienteDAO();
        List<cliente> clienteList = clienteDAO.findall();

        pre_pedidobebidafinal prePedidobebidafinal = new pre_pedidobebidafinal();
        Pre_pedidobebidafinalDAO pre_PedidobebidafinalDAO = new Pre_pedidobebidafinalDAO();
        List<pre_pedidobebidafinal> prePedidobebidafinalList = pre_PedidobebidafinalDAO.findall();

        pre_pedidopizzafinal prepedidopizzafinal = new pre_pedidopizzafinal();
        Pre_pedidopizzafinalDAO pre_PedidopizzafinalDAO = new Pre_pedidopizzafinalDAO();
        List<pre_pedidopizzafinal> prePedidopizzafinalList = pre_PedidopizzafinalDAO.findall();

        for (pre_pedidopizzafinal p : prePedidopizzafinalList){
            pizza=pizza+"-> ID: "+p.getIdPedido()+"\n-> Pizza: "+p.getSabor() +"\n-> Tamanho: "+ p.getTamanho() +"\n-> Valor: R$"+p.getValortotalp();
            for (cliente c : clienteList){
                if (p.getIdcliente() == c.getIdCliente()){
                    pizza= pizza + " cliente: "+c.getNome()+"\n-------------------------------------------------------------------------------\n";

                }
            }
            pizzaLabel.setText(pizza);
        }
        for (pre_pedidobebidafinal b :prePedidobebidafinalList){
            bebida=bebida+"-> ID: "+b.getIdpedido()+"\n-> Bebida: "+b.getNomebebida() +"\n-> Quantidade: "+ b.getQuantidade()+"\n-> Valor: "+b.getValortotalb();
            for (cliente c : clienteList){
                if (b.getIdclinte() == c.getIdCliente()){
                    bebida= bebida + " cliente: "+c.getNome()+"\n-------------------------------------------------------------------------------\n";

                }
            }
            bebidaLabel.setText(bebida);
        }


        botaoFechar.setOnMouseClicked((event)->{
            PrincipalVerPedidos.getStage().close();
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalMenuFuncionario principalMenuFuncionario = new PrincipalMenuFuncionario();
            PrincipalVerPedidos.getStage().close();
            try{
                principalMenuFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });
    botaoRelatorio.setOnMouseClicked((event)->{
        jaspercontrollerpedidosfinal jaspercontrollerpedidosfinal = new jaspercontrollerpedidosfinal();
        try {
            jaspercontrollerpedidosfinal.gerarRelatorio();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    });
    }
}

