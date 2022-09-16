package io.github.guisso.jakartaempregado.log;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe responsável pela lógica de negócios aplicada à persistência do Log
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&lt;
 * @since 0.1, 2022-09-15
 */
@Stateless
public class LogBean implements LogBeanLocal {

    // Configurado para persistência local
    @PersistenceContext(unitName = "EmpresaRemotoPU")
    EntityManager remoto;

    @Override
    public void registrar(Log log) throws Exception {
        remoto.persist(log);
    }

    @Override
    public Log localizarPorId(Log id) {
        return remoto.find(Log.class, id);
    }

}
