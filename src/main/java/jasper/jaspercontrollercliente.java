package jasper;

import dao.ClienteDAO;

import model.cliente;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jaspercontrollercliente {
   public void gerarRelatorio() throws JRException {
       String file = "src/main/java/relatorio/relatorioCliente.jasper";
       JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file);
       Map<String, Object> parametros = new HashMap<>();
       parametros.put("tituloRelatorio", "relatorio Cliente");
       ClienteDAO clienteDAO =new ClienteDAO();

       List<cliente> clientes = clienteDAO.findall(); // Método para obter a lista de vendas do banco de dados ou outra fonte

       JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(clientes);
       JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport,parametros,dataSource);
       String arquivoSaida = "C:/Users/notes/Downloads/relatorio clientes.pdf";
       JasperExportManager.exportReportToPdfFile(jasperPrint, arquivoSaida);
    }
}

