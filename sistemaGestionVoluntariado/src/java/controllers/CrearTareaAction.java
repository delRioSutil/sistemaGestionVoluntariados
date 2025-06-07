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

import cliente.TareaJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Evento;
import entidades.Tarea;
import entidades.Voluntario;

public class CrearTareaAction extends ActionSupport {

    private String nombre;
    private String descripcion;
    private int eventoId;
    private int voluntarioId;

    @Override
    public String execute() throws Exception {
        try {
            Tarea tarea = new Tarea();
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);

            Evento evento = new Evento();
            evento.setEventoid(eventoId);
            tarea.setEventoid(evento);
            
            TareaJerseyClient client = new TareaJerseyClient();
            String id = client.countREST();
            Integer idInt = Integer.valueOf(id);
            tarea.setTareaId(idInt+1);

            if (voluntarioId > 0) {
                Voluntario voluntario = new Voluntario();
                voluntario.setVoluntarioId(voluntarioId);
                tarea.setVoluntarioid(voluntario);
            }


            client.create_XML(tarea);
            client.close();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public int getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(int voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    
    
}
