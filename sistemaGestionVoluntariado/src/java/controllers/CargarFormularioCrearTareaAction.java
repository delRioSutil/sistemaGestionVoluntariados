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

import cliente.InscripcionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

public class CargarFormularioCrearTareaAction extends ActionSupport {

    private int eventoId;
    private List<Inscripcion> inscripcionesAprobadas;

    @Override
    public String execute() throws Exception {
        
        GenericType<List<Inscripcion>> gt2 = new GenericType<List<Inscripcion>>() {};
        InscripcionJerseyClient insClient = new InscripcionJerseyClient();
        List<Inscripcion> inscripciones = insClient.findAll_XML(gt2);  
        List<Inscripcion> aux = new ArrayList<Inscripcion>(); 
        
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getAprobada()){
                aux.add(inscripcion);
            }
        }
        this.inscripcionesAprobadas= aux;
        
        
        return SUCCESS;
    }

    // Getter y Setter para eventoId
    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public List<Inscripcion> getInscripcionesAprobadas() {
        return inscripcionesAprobadas;
    }

    public void setInscripcionesAprobadas(List<Inscripcion> inscripcionesAprobadas) {
        this.inscripcionesAprobadas = inscripcionesAprobadas;
    }
    
}
