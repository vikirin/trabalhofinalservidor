package jasper;

import dao.Pre_pedidobebidafinalDAO;
import model.pre_pedidobebidafinal;
import dao.Pre_pedidopizzafinalDAO;
import model.pre_pedidopizzafinal;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.util.List;

public class jaspercontrollerpedidosfinal {
    public void gerarRelatorio() throws JRException{
        pre_pedidobebidafinal prePedidobebidafinal = new pre_pedidobebidafinal();
        Pre_pedidobebidafinalDAO pre_PedidobebidafinalDAO = new Pre_pedidobebidafinalDAO();
        List<pre_pedidobebidafinal> prePedidobebidafinalList = pre_PedidobebidafinalDAO.findall();

        pre_pedidopizzafinal prepedidopizzafinal = new pre_pedidopizzafinal();
        Pre_pedidopizzafinalDAO pre_PedidopizzafinalDAO = new Pre_pedidopizzafinalDAO();
        List<pre_pedidopizzafinal> prePedidopizzafinalList = pre_PedidopizzafinalDAO.findall();

        //Criação do PDF com o Jasper
        JasperReport relatorioAula10 = JasperCompileManager.compileReport(
                "src/main/resources/pedido.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(prePedidobebidafinalList));

        JasperPrint relatorio1 = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(prePedidopizzafinalList));


        //SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        JRViewer painel1 = new JRViewer(relatorio1);
        tela.getContentPane().add(painel);
        tela.setVisible(true);

    }
}
