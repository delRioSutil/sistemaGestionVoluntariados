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

public class EditarTareaAction extends ActionSupport {

    private Integer tareaId;
    private String nombre;
    private String descripcion;
    private Integer eventoId;
    private Integer voluntarioId;

    @Override
    public String execute() {
        try {
            Tarea tarea = new Tarea();
            tarea.setTareaId(tareaId);
            tarea.setNombre(nombre);
            tarea.setDescripcion(descripcion);

            // Set entidades relacionadas como objetos
            Evento evento = new Evento();
            evento.setEventoid(eventoId);
            tarea.setEventoid(evento);

            Voluntario voluntario = new Voluntario();
            voluntario.setVoluntarioId(voluntarioId);
            tarea.setVoluntarioid(voluntario);



            TareaJerseyClient client = new TareaJerseyClient();
            client.edit_XML(tarea, tareaId.toString());
            client.close();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Getters y Setters
    public Integer getTareaId() {
        return tareaId;
    }

    public void setTareaId(Integer tareaId) {
        this.tareaId = tareaId;
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

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public Integer getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Integer voluntarioId) {
        this.voluntarioId = voluntarioId;
    }
}