/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.ValoracionJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Valoracion;
import javax.ws.rs.core.GenericType;

public class CargarValoracionAction extends ActionSupport {
    private int eventoid;
    private int voluntarioid;

    private Valoracion valoracion;

    @Override
    public String execute() {
        try {
            ValoracionJerseyClient client = new ValoracionJerseyClient();
            String idCompuesta = "eventoid=" + eventoid + ";voluntarioid=" + voluntarioid;

             GenericType<Valoracion> gType = new GenericType<Valoracion>() {};
            valoracion = client.find_XML(gType, idCompuesta);
            client.close();

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }

    // Getters y Setters
    public Valoracion getValoracion() {
        return valoracion;
    }

    public int getEventoid() {
        return eventoid;
    }

    public void setEventoid(int eventoid) {
        this.eventoid = eventoid;
    }

    public int getVoluntarioid() {
        return voluntarioid;
    }

    public void setVoluntarioid(int voluntarioid) {
        this.voluntarioid = voluntarioid;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
    
}