package com.example.trabalhofinal.jasper;

import com.example.trabalhofinal.dao.PizzaDAO;

import com.example.trabalhofinal.model.pizza;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;


import javax.swing.*;
import java.util.List;


public class jaspercontrollerpizza {

    public void gerarRelatorio() throws JRException {
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<pizza> pizzaList = pizzaDAO.findall();

        JasperReport relatorioAula10 = JasperCompileManager.compileReport(
                "src/main/resources/relatotiriopizza.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(pizzaList));

        //SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        tela.getContentPane().add(painel);
        tela.setVisible(true);
    }
}
