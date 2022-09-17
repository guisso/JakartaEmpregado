package io.github.guisso.jakartaempregado.log;

import io.github.guisso.jakartaempregado.util.OperacaoBancoDados;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * Classe Log
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-09
 */
@Entity
@Table(indexes = @Index(columnList = "dataHora, operacao"))
public class Log implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tipos de dados para PostgreSQL (14) e MySQL (8.0)
    // https://www.postgresql.org/docs/current/datatype.html
    // @Column(columnDefinition = "TIMESTAMP")
    // https://dev.mysql.com/doc/refman/8.0/en/data-types.html
    // @Column(columnDefinition = "DATETIME")
    @Column
    private LocalDateTime dataHora;

    @Column(columnDefinition = "CHAR(3)", nullable = false)
    private String operacao;

    @Column(length = 2500, nullable = false)
    private String mensagem;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Log() {
        dataHora = LocalDateTime.now();
    }

    public Log(String operacao, String mensagem) {
        this();
        this.operacao = operacao;
        this.mensagem = mensagem;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoBancoDados operacao) {
        this.operacao = operacao.toString();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Log{"
                + "id=" + id
                + ", dataHora=" + dataHora
                + ", operacao=" + operacao
                + ", mensagem=" + mensagem
                + '}';
    }

}
