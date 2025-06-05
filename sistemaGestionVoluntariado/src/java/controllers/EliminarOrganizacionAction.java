/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.OrganizacionClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Organizacion;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usuario
 */
public class EliminarOrganizacionAction extends ActionSupport implements SessionAware {
    
    private String mensaje;
    private String password;
    private Map<String, Object> session;
    
    public EliminarOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        Integer id = (Integer) session.get("organizacionId");
        OrganizacionClient client1=new OrganizacionClient();
        GenericType<Organizacion> genericType = new GenericType<Organizacion>() {};
        String aux = DigestUtils.sha256Hex(password);
        try {
            Organizacion org = client1.find_XML(genericType, id.toString());
            if (org == null || !org.getContrasenya().equals(aux)) {
                mensaje = "Contraseña incorrecta.";
                return ERROR;
            }
            client1.remove(id.toString());
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
