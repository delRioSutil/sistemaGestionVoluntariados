/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.EventoClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Organizacion;
import javax.ws.rs.core.GenericType;
import org.apache.commons.codec.digest.DigestUtils;
import cliente.OrganizacionClient;
import entidades.Evento;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usuario
 */
public class loginOrganizacionAction extends ActionSupport implements SessionAware{
    
    private String nif;
    private String password;
    private String mensaje;
    private Map<String, Object> session;
    
    public loginOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        //Instanciamos el cliente y buscamos uno con el mismo nif
        OrganizacionClient client1=new OrganizacionClient();
        EventoClient client2 = new EventoClient();
        GenericType<Organizacion> genericType = new GenericType<Organizacion>() {};
        GenericType<List<Evento>> genericTypeList = new GenericType<List<Evento>>() {};
        List<Evento> eventos = new ArrayList<Evento>();
        List<Evento> eventosOrg = new ArrayList<Evento>();
        String aux = DigestUtils.sha256Hex(password);
        try {
            Organizacion org = client1.find_XML(genericType, nif);
            eventos =  client2.findAll_XML(genericTypeList);         
            if (org == null || !org.getContrasenya().equals(aux)) {
                mensaje = "Contraseña incorrecta.";
                return ERROR;
            }
            Integer id = org.getOrganizacionId();
            session.put("organizacionId", id);
            session.put("organizacion", org);
            for(Evento evento: eventos){
                if(evento.getOrganizacionid().getOrganizacionId() == id){
                    eventosOrg.add(evento);
                }
            }
            session.put("eventos", eventosOrg);
            return SUCCESS;

        } catch (javax.ws.rs.NotFoundException e) {
            mensaje = "Datos incorrectos.";
            e.printStackTrace();
            return ERROR;

        } catch (javax.ws.rs.InternalServerErrorException e) {
            mensaje = "Error interno al buscar la organización.";
            e.printStackTrace(); //Ver detalles en consola
            return ERROR;
        }
    }
    
     public void validate() {
        if (password == null || password.trim().isEmpty()) {
            addFieldError("password", "Introduzca contraseña");
        }
        if (nif==null || nif.trim().isEmpty()){
            addFieldError("nif", "Inserte el nif de la organización");
        }
    }
    

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
    
}
