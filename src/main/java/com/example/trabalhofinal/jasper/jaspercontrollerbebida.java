package com.example.trabalhofinal.jasper;

import com.example.trabalhofinal.dao.BebidaDAO;
import com.example.trabalhofinal.model.bebida;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.util.List;

public class jaspercontrollerbebida {
    public void gerarRelatorio() throws JRException {
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<bebida> bebidaList =bebidaDAO.findall();

        JasperReport relatorioAula10 = JasperCompileManager.compileReport(
                "src/main/resources/relatotiriobebida.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(bebidaList));

        //SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        tela.getContentPane().add(painel);
        tela.setVisible(true);
    }
}
