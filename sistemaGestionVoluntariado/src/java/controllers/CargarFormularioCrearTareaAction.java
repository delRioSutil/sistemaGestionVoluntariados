/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author juanr
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;

public class CargarFormularioCrearTareaAction extends ActionSupport {

    private int eventoId;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    // Getter y Setter para eventoId
    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }
}
