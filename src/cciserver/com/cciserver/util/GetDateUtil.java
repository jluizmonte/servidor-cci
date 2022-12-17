package cciserver.com.cciserver.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Metodo para as datas/horas usadas no sistema formatadas em diversos padrões
 *
 * @author joseluiz
 *
 */
public class GetDateUtil {

    /**
     * retorna dia e mes (separado por hifen) e hora (hora e minutos)
     *
     * @return data
     */
    public String getDate() {
        String dataAtual = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM_HH:mm");
        LocalDateTime timepoint = LocalDateTime.now();
        dataAtual = (timepoint.format(fmt));
        return dataAtual;

    }

    /**
     * retorna a data completa (dia ,mês e ano) e a hora atual (hora, minuto e
     * segundos)
     *
     * @return data
     */
    public String getDateNow() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        LocalDateTime timepoint = LocalDateTime.now();
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna o dia e o mês com um underline
     *
     * @return data
     */
    public String getDateOnly() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd_MM");
        LocalDateTime timepoint = LocalDateTime.now();
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna a hora e minutos
     *
     * @return data
     */
    public String getTimeOnly() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime timepoint = LocalDateTime.now();
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna dia, mês e ano atuais
     *
     * @return data
     */
    public String getDateTime() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDateTime timepoint = LocalDateTime.now();
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna a data atual no formato dd-mm-yyyy
     *
     * @return
     */
    public String getDateTimeUS() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        LocalDateTime timepoint = LocalDateTime.now();
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna a data atualizada de 1 mês
     *
     * @return data
     */
    public String getDateTimeMonth() {
        String date = "";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime timepoint = LocalDateTime.now().plusMonths(1);
        date = (timepoint.format(fmt));
        return date;
    }

    /**
     * retorna o dia anterior
     *
     * @return
     */
    public Date retornaDiaAnterior() {
        Date data = new Date();
        Date diaAnterior = new Date(data.getYear(), data.getMonth(), data.getDate() - 1);
        return diaAnterior;
    }

    /**
     * retorna a data atual para o JDateChooser
     *
     * @return
     */
    public Date retornaDataAtual() {
        Date data = new Date();
        Date diaAnterior = new Date(data.getYear(), data.getMonth(), data.getDate());
        return diaAnterior;
    }

    public Date converterDataBr(String data) {
        SimpleDateFormat formatoDesejado = new SimpleDateFormat("dd/MM/yyyy");
        Date datas = null;

        formatoDesejado.format(data);
        return datas;
    }

    public String recuperaDataChooser(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String novaData = sdf.format(data);
        return novaData;
    }
}
