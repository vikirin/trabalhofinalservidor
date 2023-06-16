package com.example.trabalhofinal;

import dao.PizzaDAO;
import dao.Pre_pedidopizzaDAO;
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
import model.pizza;
import model.pre_pedidopizza;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PizzaFuncionarioController implements Initializable {

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
    private Button botaoVoltar;

    @FXML
    private Label listagemP;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private ImageView pessoaImagem;

    @FXML
    private Label pizzaLabel;

    @FXML
    private ScrollPane scrolllP;

    @FXML
    private TextField usuarioText;

    @FXML
    private ImageView voltarImagem;

    private static long idpizza;

    public static long getIdpizza() {
        return idpizza;
    }

    public static void setIdpizza(long idpizza) {
        PizzaFuncionarioController.idpizza = idpizza;
    }
    String lisp="";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizza pizza = new pizza();
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<pizza> pizzaList = pizzaDAO.findall();
        for(pizza p : pizzaList){
            lisp=lisp+"-> Pizza: "+p.getNomeProduto()+"\n-> Valor: R$"+p.getValor()+"\n -> ID: "+p.getIdPizza()+"\n-------------------------------------------------------------------------------\n";
        }
        listagemP.setText(lisp);
        pre_pedidopizza prepedidopizza = new pre_pedidopizza();
        Pre_pedidopizzaDAO pre_PedidopizzaDAO = new Pre_pedidopizzaDAO();
        List<pre_pedidopizza> prePedidopizzaList = pre_PedidopizzaDAO.findall();

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalMenuFuncionario principalMenuFuncionario = new PrincipalMenuFuncionario();
            PrincipalPizzaFuncionario.getStage().close();
            try{
                principalMenuFuncionario.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoFechar.setOnMouseClicked((event)->{
            PrincipalPizzaFuncionario.getStage().close();
        });
        botaoDeletar.setOnMouseClicked((event)->{


            for (pizza p : pizzaList){
                if (p.getIdPizza()==Long.valueOf(usuarioText.getText())){
                    pizzaDAO.delete(Long.valueOf(usuarioText.getText()));
                    avisoLabel.setTextFill(Paint.valueOf("#62d753"));
                    avisoLabel.setText("Pizza deletada com sucesso!");
                    for (pre_pedidopizza piz : prePedidopizzaList){
                        if (piz.getIdPizza()==Long.valueOf(usuarioText.getText())){
                            pre_PedidopizzaDAO.delete(piz.getIdPedido());
                        }
                    }
                    PrincipalPizzaFuncionario principalPizzaFuncionario = new PrincipalPizzaFuncionario();
                    PrincipalPizzaFuncionario.getStage().close();
                    try{
                        principalPizzaFuncionario.start(new Stage());
                    }catch(Exception e){

                    }
                }
                else{
                    avisoLabel.setTextFill(Paint.valueOf("#ff0000"));
                    avisoLabel.setText("Pizza não deletada!");
                }
            }
        });

        botaoCriar.setOnMouseClicked((event)->{
            PrincipalCriarPizza principalCriarPizza = new PrincipalCriarPizza();
            PrincipalPizzaFuncionario.getStage().close();
            try{
               principalCriarPizza.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoEditar.setOnMouseClicked((event)->{
            setIdpizza(Long.parseLong(usuarioText.getText()));
            PrincipalEditarPizza principalEditarPizza = new PrincipalEditarPizza();
            PrincipalPizzaFuncionario.getStage().close();
            try{
                principalEditarPizza.start(new Stage());
            }catch(Exception e){

            }
        });
    }
}
