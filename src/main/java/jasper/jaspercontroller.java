package jasper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import javax.swing.*;
import dao.Pre_pedidopizzaDAO;
import dao.Pre_pedidobebidaDAO;
import model.pre_pedidobebida;
import model.pre_pedidopizza;
import model.auxiliargerado;

import java.util.List;
public class jaspercontroller {
    public void gerarRelatorio() throws JRException{
        pre_pedidobebida prePedidobebida = new pre_pedidobebida();
        Pre_pedidobebidaDAO pre_PedidobebidaDAO = new Pre_pedidobebidaDAO();

        auxiliargerado auxiliargerado = new auxiliargerado();
        pre_pedidopizza prepedidopizza = new pre_pedidopizza();
        Pre_pedidopizzaDAO pre_PedidopizzaDAO = new Pre_pedidopizzaDAO();
        List<pre_pedidopizza> prePedidopizzaList = pre_PedidopizzaDAO.findall();
        List<pre_pedidobebida> prePedidobebidaList = pre_PedidobebidaDAO.findall();
        //Criação do PDF com o Jasper
        JasperReport relatorioAula10 =
                JasperCompileManager.compileReport(
                        "src/main/resources/com/example/trabalhors2/NotaFiscal.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(prePedidobebidaList));

        JasperPrint relatorio1 = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(prePedidopizzaList));

        //SWING para mostrar a tela PDF
//        JDialog tela = new JDialog( new JDialog(),
//                "Relatorio Pessoas", true);
//        tela.setSize(800, 600);
//        JRViewer painel = new JRViewer(relatorio);
//        JRViewer painel1 = new JRViewer(relatorio1);
//        tela.getContentPane().add(painel);
//        tela.setVisible(true);

    }
}

