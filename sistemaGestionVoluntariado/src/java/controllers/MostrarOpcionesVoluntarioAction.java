/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.EventoClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;

public class MostrarOpcionesVoluntarioAction extends ActionSupport {

    private List<Evento> eventos;

    @Override
    public String execute() {
        EventoClient client = new EventoClient();
        GenericType<List<Evento>> genericType = new GenericType<List<Evento>>() {};
        try {
            List<Evento> todos = client.findAll_XML(genericType);
            eventos = new ArrayList<>();
            Date hoy = new Date();

            for (Evento e : todos) {
                if (e.getFechainicio() != null && !e.getFechainicio().before(hoy)) {
                    eventos.add(e);
                }
            }

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}

