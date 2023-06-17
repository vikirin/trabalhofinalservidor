package com.example.trabalhofinal.jasper;

import com.example.trabalhofinal.dao.AuxilliargeradoDAO;
import com.example.trabalhofinal.model.auxiliargerado;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.util.List;

public class jaspercontrollerpedidosfinal {
    public void gerarRelatorio() throws JRException{
AuxilliargeradoDAO auxilliargeradoDAO=new AuxilliargeradoDAO();
List<auxiliargerado> auxiliargerados =auxilliargeradoDAO.findall();


        //Criação do PDF com o Jasper
        JasperReport relatorioAula10 = JasperCompileManager.compileReport(
                "src/main/resources/pedido.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(auxiliargerados));

        //SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        tela.getContentPane().add(painel);
        tela.setVisible(true);

    }
}
