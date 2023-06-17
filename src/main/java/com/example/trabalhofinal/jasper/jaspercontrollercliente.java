package com.example.trabalhofinal.jasper;

import com.example.trabalhofinal.dao.ClienteDAO;

import com.example.trabalhofinal.model.cliente;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;


import javax.swing.*;
import java.util.List;


public class jaspercontrollercliente {
   public void gerarRelatorio() throws JRException {
       ClienteDAO clienteDAO =new ClienteDAO();
       List<cliente> clientes = clienteDAO.findall();
       JasperReport relatorioAula10 = JasperCompileManager.compileReport(
               "src/main/resources/relatorioCliente.jrxml");

       JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
               null, new JRBeanCollectionDataSource(clientes));

       //SWING para mostrar a tela PDF
       JDialog tela = new JDialog( new JDialog(),
               "Relatorio Pessoas", true);
       tela.setSize(800, 600);
       JRViewer painel = new JRViewer(relatorio);
       tela.getContentPane().add(painel);
       tela.setVisible(true);
    }
}

