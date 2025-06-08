/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.InscripcionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Inscripcion;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author juanr
 */
public class aprobarInscripcionAction extends ActionSupport {
    private Integer inscripcionId;
    private Integer eventoId;
    public aprobarInscripcionAction() {
    }
    
    public String execute() throws Exception {
        InscripcionJerseyClient client1 = new InscripcionJerseyClient();
        GenericType<Inscripcion> gt = new GenericType<Inscripcion>() {};
        Inscripcion ins = client1.find_XML(gt, inscripcionId.toString());
         ins.setAprobada(Boolean.TRUE);
         client1.edit_XML(ins, inscripcionId.toString());
         
         return SUCCESS;
    }

    public Integer getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Integer inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }
    
}
