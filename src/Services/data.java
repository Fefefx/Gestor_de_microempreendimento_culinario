/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class data {

    //Obtém a data atual do sistema e retorna uma String no formato dd/MM/yyyy
    public String obterData() {
        LocalDate data = LocalDate.now();
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data_formatada = data.format(formatar);
        return data_formatada;
    }

    //Recebe por parâmetro uma data no formato dd/MM/yyyy e converte-a para o formato do banco yyyy-MM-dd  
    public String formatarBanco(String dataLatina) {
        String dataFormatada = dataLatina.substring(6) + "-" + dataLatina.substring(3, 5) + "-" + dataLatina.substring(0, 2);
        System.out.println(dataFormatada);
        return dataFormatada;
    }

    //Recebe por parâmetro um objeto date e converte-o para o formato do banco yyyy-MM-dd  
    public String formatarBanco(Date data) {
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String dataFormatada = formatar.format(data);
            return dataFormatada;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma data válida");
        }
        return null;
    }

    //Recebe por parâmetro uma data no formato yyyy-MM-dd e converte-a para o formato latino dd/MM/yyyy
    public String formatarLatina(String dataBanco) {
        String formatar = dataBanco.substring(6) + "-" + dataBanco.substring(3, 5) + "-" + dataBanco.substring(0, 2);
        return formatar;
    }

}
