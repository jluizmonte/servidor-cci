package cciserver.com.cciserver.util;

import cciserver.com.cciserver.model.SessaoUsuarioModel;

/**
 * Classe com Strings estáticas com caminhos locais para os logs e outras
 * leituras/escritas de arquivos locais.
 *
 * @author joseluiz
 *
 */
public class LocalUtil {

    /**
     * valores atribuidos quando chamados nos catch
     */
    public static String logText;
    /**
     * valores atribuidos quando chamados nos catch
     */
    public static String logClass;
    /**
     * nome do usuário logado na sessão
     */
    public static String logUser = SessaoUsuarioModel.nomeUsuario;
    /**
     * data no formato dd-MM_HH:mm
     */
    public static String logDate = new GetDateUtil().getDate();
    /**
     * data no formato dd/MM/yy HH:mm:ss
     */
    public String logDateNow = new GetDateUtil().getDateNow();
    /**
     * data no formato dd_MM
     */
    public static String logDateOnly = new GetDateUtil().getDateOnly();
    /**
     * data no formato HH:mm
     */
    public static String logTimeOnly = new GetDateUtil().getTimeOnly();
    /**
     * nome da instituição
     */
    public static String logLibrary = "CCI - CENTRAL DE CURSOS";
    /**
     * cria os arquivos de LOGS
     */
    public static String logFile = new FolderCreatorUtil().logFile();
    /**
     * retorna o nome da pasta de LOGS
     */
    public static String userDirectory = new FolderCreatorUtil().userDirectory();
    /**
     * cria o changelog
     */
    public static String changelogFile = new FolderCreatorUtil().changelogFile();
    /**
     * cria a pasta de LOGS vazia
     */
    public static String logFolderDirectory = new FolderCreatorUtil().logFolderDirectory();

    /**
     * cria a pasta para os relatorios
     */
    public static String relatorioDiretorio = new FolderCreatorUtil().relatorioDirectory();

    /**
     * especifica o tipo de log erro, mensagem padrão, mensagem de sucesso etc
     */
    public static String logType;
}
