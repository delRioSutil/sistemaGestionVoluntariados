/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.OrganizacionClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Organizacion;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usuario
 */
public class ActualizarOrganizacionAction extends ActionSupport implements SessionAware {
    
    private String email;
    private String nombre;
    private Map<String, Object> session;
    
    public ActualizarOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        Integer id =  (Integer) session.get("organizacionId");
        GenericType<Organizacion> genericType = new GenericType<Organizacion>() {};
        OrganizacionClient client1=new OrganizacionClient();
        Organizacion org = client1.find_XML(genericType, id.toString());
        if(this.email.equals("") || this.email == null){
            org.setNombre(nombre);
        } else if(this.nombre.equals("") || this.nombre == null){
            org.setCorreo(email);
        } else{
            org.setNombre(nombre);
            org.setCorreo(email);
        }
        client1.edit_XML(org, id.toString());
        return SUCCESS;
    }
    
    public void validate() {
        if ((nombre == null || nombre.trim().isEmpty()) && (email==null || email.trim().isEmpty())) {
            addFieldError("email", "Rellene algún dato");
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;     //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
