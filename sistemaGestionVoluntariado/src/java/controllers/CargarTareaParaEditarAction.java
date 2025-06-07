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
import entidades.Tarea;
import javax.ws.rs.core.GenericType;

public class CargarTareaParaEditarAction extends ActionSupport {

    private int tareaId;
    private String nombre;
    private String descripcion;
    private int eventoId;
    private int voluntarioId;

    @Override
    public String execute() {
        try {
            TareaJerseyClient client = new TareaJerseyClient();
            GenericType<Tarea> genericType = new GenericType<Tarea>() {};
            Tarea tarea = client.find_XML(genericType, String.valueOf(tareaId));
            client.close();

            if (tarea != null) {
                this.nombre = tarea.getNombre();
                this.descripcion = tarea.getDescripcion();
                this.eventoId = tarea.getEventoid().getEventoid();
                this.voluntarioId = tarea.getVoluntarioid().getVoluntarioId(); // Asegúrate de que tenga getter
                return SUCCESS;
            } else {
                return ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        
    }

    // Getters y setters

    public int getTareaId() {
        return tareaId;
    }

    public void setTareaId(int tareaId) {
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