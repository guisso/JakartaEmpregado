/*
 * CC BY-NC-SA 4.0
 *
 * Copyright 2022 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;.
 *
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 * You are free to:
 *   Share - copy and redistribute the material in any medium or format
 *   Adapt - remix, transform, and build upon the material
 *
 * Under the following terms:
 *   Attribution - You must give appropriate credit, provide 
 *   a link to the license, and indicate if changes were made.
 *   You may do so in any reasonable manner, but not in any 
 *   way that suggests the licensor endorses you or your use.
 *   NonCommercial - You may not use the material for commercial purposes.
 *   ShareAlike - If you remix, transform, or build upon the 
 *   material, you must distribute your contributions under 
 *   the same license as the original.
 *   No additional restrictions - You may not apply legal 
 *   terms or technological measures that legally restrict 
 *   others from doing anything the license permits.
 *
 * Notices:
 *   You do not have to comply with the license for elements 
 *   of the material in the public domain or where your use 
 *   is permitted by an applicable exception or limitation.
 *   No warranties are given. The license may not give you 
 *   all of the permissions necessary for your intended use. 
 *   For example, other rights such as publicity, privacy, 
 *   or moral rights may limit how you use the material.
 */
package io.github.guisso.jakartaempregado.util;

/**
 * Roteiro de ações
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-14
 */
public interface Roteiro {

    // PASSO 0
    // @TODO 001 Baixar e descompactar o DBeaver https://dbeaver.io/
    // PASSO 1
    // @TODO 101 Criar conta remota em https://freedb.tech/ (MySQL)
    // @TODO 102 Configurar o DBeaver para conexão
    // @TODO 103 Configurar data source no WildFly para acesso
    // @TODO 104 Criar banco de dados "empresa" localmente (PostgreSQL)
    // @TODO 105 Configurar o DBeaver para conexão
    // @TODO 106 Configurar data source no WildFly para acesso
    // @TODO 107 Configurar duas unidades de persistência no persistence.xml
    // PASSO 2
    // @TODO 201 Criar a entidade "Log" no pacote "log"
    // @TODO 202 Verificar o ORM nos dois bancos de dados
    // @TODO 203 Criar o bean de sessão "LogBean" com a respectiva interface local no pacote "log" com a operação "registrar"
    // PASSO 3
    // @TODO 301 Criar a entidade "Empregado" no pacote "empregado"
    // @TODO 302 Verificar o ORM nos dois bancos de dados
    // @TODO 303 Criar o bean de sessão "EmpregadoBean" com a respectiva interface local no pacote "empregado" com a operação "salvar"
    // @TODO 304 Criar o bean de sessão "EmpregadoBean" com a respectiva interface local no pacote "empregado" com a operação "localizarPorId"
    // PASSO 4
    // @TODO 401 Criar servlet para teste de operações com os EJBs
    // PASSO 5
    // @TODO 501 Testar persistência (sem especificação de PU)
    // @TODO 502 Configurar PUs distintas para (remoto) Log e (local) demais entidades (Empregado, ...)
    // @TODO 503 Testar persistência de Empregado
    // @TODO 504 Testar persistência de Log
    // @TODO 505 Verificar ACID simulando falha no log
    // @TODO 506 Verificar ACID simulando falha no empregado
    // PASSO 6
    // @TODO 601 Configurar data sources com arquitetura extendida (XA)
    // @TODO 602 Configurar PUs distintas para (remoto) Log e (local) demais entidades (Empregado, ...)
    // @TODO 603 Testar persistência de Empregado
    // @TODO 604 Testar persistência de Log
    // @TODO 605 Testar persistência de Log via Empregado
    // @TODO 606 Verificar ACID simulando falha no log
    // @TODO 607 Verificar ACID simulando falha no empregado
    // PASSO 7
    // @TODO 701 Testar operação assíncrona de persistência do Log via Empregado
    // @TODO 702 Verificar ACID simulando falha no log
    // @TODO 703 Verificar ACID simulando falha no empregado
}
