package cciserver.com.cciserver.util;

import cciserver.com.cciserver.model.SessaoUsuarioModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Classe com as configurações dos arquivos de Log
 *
 * @author joseluiz
 *
 */
public class LogCatUtil {

    File logCat;
    ObterInfoSistemaUtil obterInfoSistema = new ObterInfoSistemaUtil();
    TemplateAlerts templateAlerts = new TemplateAlerts();

    /**
     * criação do aquivo
     *
     */
    public void createFile() {
        logCat = new File(LocalUtil.logFile);
        if (!logCat.exists()) {
            try {
                logCat.createNewFile();
                this.firstWriteFile();
            } catch (IOException e) {
                LocalUtil.logClass = this.getClass().getName();
                new LogCatUtil().writeFile(String.valueOf(e));
            }
        }

    }

    /**
     * Escrita do log quando for estourado um erro
     *
     * @param log log
     */
    public void writeFile(String log) {
        logCat = new File(LocalUtil.logFile);
        try {
            if (("".equals(log)) || (log == null)) {
                log = "Sem mais registros!";
                LocalUtil.logClass = getClass().toString();
            }

            if (SessaoUsuarioModel.nomeUsuario == null) {
                SessaoUsuarioModel.nomeUsuario = templateAlerts.erroUsuarioLogado();
            }
            FileWriter fileWriter = new FileWriter(logCat, true);
            try ( BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.newLine();
                bufferedWriter.write("--------");
                bufferedWriter.newLine();
                bufferedWriter.write("USUÁRIO: " + SessaoUsuarioModel.nomeUsuario);
                bufferedWriter.newLine();
                bufferedWriter.write("TIPO DE LOG: " + LocalUtil.logType);
                bufferedWriter.newLine();
                bufferedWriter.write("CLASSE ONDE OCORREU A EXCEÇÃO: " + LocalUtil.logClass);
                bufferedWriter.newLine();
                bufferedWriter.write("DATA E HORA: " + new LocalUtil().logDateNow);
                bufferedWriter.newLine();
                bufferedWriter.write("DESCRIÇÃO: " + log);
                bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo de LOG\n Informe ao desenvolvedor o ocorrido", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(ex));
        }
    }

    /**
     * cabeçalho padrão do arquivo de log
     */
    public void firstWriteFile() {
        logCat = new File(LocalUtil.logFile);
        try {
            FileWriter fileWriter = new FileWriter(logCat);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("<><>LOGS DO SISTEMA CONTROLE CCI<><>\n");
            bufferedWriter.write("Instituição: " + LocalUtil.logLibrary);
            bufferedWriter.newLine();
            bufferedWriter.write("Data criação arquivo de log: " + new LocalUtil().logDateNow);
            bufferedWriter.newLine();
            bufferedWriter.write("Sistema operacional: " + new ObterInfoSistemaUtil().getNomeSistema());
            bufferedWriter.newLine();
            bufferedWriter.write("Licenciado para: " + new ObterInfoSistemaUtil().getNomeUsuario());
            bufferedWriter.newLine();
            bufferedWriter.write("Versão atual do sistema:" + obterInfoSistema.getAcervoVersao() + " Final 2022");
            bufferedWriter.newLine();
            bufferedWriter.write("<<<<< LOGCAT >>>>>\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(new LocalUtil().logDateNow + ": " + "O SISTEMA FOI INSTALADO COM SUCESSO!\n");
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
                    JOptionPane.ERROR_MESSAGE);
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }
    }

    /**
     * Criação de um changelog
     */
    public void createWriteChangeLog() {

        logCat = new File(LocalUtil.changelogFile);

        try {
            logCat.createNewFile();
        } catch (IOException e) {
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }
        try {
            FileWriter fileWriter = new FileWriter(logCat);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("<<>>"
                    + "CRIAÇÃO DAS JAENLAS DE ALUNO, CURSO CONSULTA E REGISTRO DE ALUNO\n"
                    + "REPARO DO ERRO AO SALVAR UM ALUNO NOVO\n"
                    + "");
            bufferedWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            LocalUtil.logClass = this.getClass().getName();
            new LogCatUtil().writeFile(String.valueOf(e));
        }

    }

    /**
     * leitura dos arquivos de log e changelog para exibir numa tela
     */
    public void readNameLogs() {
        File folder = new File(LocalUtil.logFolderDirectory);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                LocalUtil.logLibrary += listOfFiles[i].getName();
            }
        }
    }
}
