package cciserver.com.cciserver.util;

import java.io.File;

/**
 * Lista e cria os diretórios para os arquivos de log e changelog
 *
 * @author joseluiz
 *
 */
public class FolderCreatorUtil {

    /**
     * retorna diretorio local do usuário
     */
    public static String diretorioPadrao = System.getProperty("user.home");
    /**
     * retorna tipo do S.O
     */
    private final String nomeSistema = System.getProperty("os.name");
    /**
     * variavel para diretorio do usuario
     */
    public static String userDirectory;
    String logCat;
    String changeLog;

    /**
     * retorna o nome da pasta adicionada da barra necessária utilizada somente
     * para visualizar os logs
     *
     * @return return
     */
    public String userDirectory() {
        if (nomeSistema.equals("Linux")) {
            userDirectory = diretorioPadrao + "/controlecci/logs/";
        } else {
            userDirectory = diretorioPadrao + "\\controlecci\\logs\\";
        }
        return userDirectory;
    }

    /**
     * cria a pasta de LOGS vazia
     *
     * @return return
     */
    public String logFolderDirectory() {
//        if (nomeSistema.equals("Linux")) {
//            //   userDirectory = diretorioPadrao + "/controlecci/logs";
//            userDirectory = "logs";
//        } else {
//            userDirectory = diretorioPadrao + "\\controlecci\\logs";
//        }
        userDirectory = "logs";
        return userDirectory;
    }

    /**
     *
     * @return return
     */
    public String relatorioDirectory() {
        if (nomeSistema.equals("Linux")) {
            userDirectory = diretorioPadrao + "/Relatorios";
        } else {
            userDirectory = diretorioPadrao + "\\Relatorios";
        }
        return userDirectory;
    }

    /**
     * cria a pasta para salvar os relatorios em PDF
     */
    public void createRelatoryFolder() {
        File diretorio = new File(LocalUtil.relatorioDiretorio);
        if (!diretorio.exists()) {
            try {
                diretorio.mkdirs();
            } catch (Exception e) {
                LocalUtil.logClass = this.getClass().getName();
                new LogCatUtil().writeFile(String.valueOf(e));
            }
        }
    }

    /**
     * cria os arquivos de LOGS
     *
     * @return return
     */
    public String logFile() {
//        if (nomeSistema.equals("Linux")) {
//            //  userDirectory = diretorioPadrao + "/controlecci/logs/";
//            userDirectory = "logs/";
//            //  logCat = userDirectory + LocalUtil.logLibrary + ".log";
//            logCat = userDirectory + LocalUtil.logLibrary + ".log";
//        } else {
//            userDirectory = diretorioPadrao + "\\controlecci\\logs\\";
//            String uri = userDirectory + LocalUtil.logLibrary + ".log";
//            logCat = uri;
//        }
        logCat = "logs/" + LocalUtil.logLibrary + ".log";
        return logCat;
    }

    /**
     * criação do changelog
     *
     * @return return
     */
    public String changelogFile() {
        if (nomeSistema.equals("Linux")) {
            userDirectory = diretorioPadrao + "/controlecci/";
            changeLog = userDirectory + "changelog.txt";
        } else {
            userDirectory = diretorioPadrao + "\\controlecci\\";
            changeLog = userDirectory + "changelog.txt";
        }
        return changeLog;
    }

    /**
     * Criação da pasta no sistema local para manter os arquivos de logs e
     * changelog
     */
    public void createFolder() {
        File diretorio = new File(LocalUtil.logFolderDirectory);
        if (!diretorio.exists()) {
            try {
                diretorio.mkdirs();
            } catch (Exception e) {
                LocalUtil.logClass = this.getClass().getName();
                new LogCatUtil().writeFile(String.valueOf(e));
            }
        }
    }
}
