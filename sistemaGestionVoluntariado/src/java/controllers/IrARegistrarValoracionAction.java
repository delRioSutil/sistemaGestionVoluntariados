/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;

/**
 *
 * @author Antonio
 */
public class IrARegistrarValoracionAction extends ActionSupport {
      private Integer eventoIdSeleccionado;

    public IrARegistrarValoracionAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }

    public Integer getEventoIdSeleccionado() {
        return eventoIdSeleccionado;
    }

    public void setEventoIdSeleccionado(Integer eventoIdSeleccionado) {
        this.eventoIdSeleccionado = eventoIdSeleccionado;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
}
