/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Organizacion;
import javax.ws.rs.core.GenericType;
import org.apache.commons.codec.digest.DigestUtils;
import cliente.OrganizacionClient;

/**
 *
 * @author usuario
 */
public class loginOrganizacionAction extends ActionSupport {
    
    private String nif;
    private String password;
    private String mensaje;
    
    public loginOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        //Instanciamos el cliente y buscamos uno con el mismo nif
        OrganizacionClient client1=new OrganizacionClient();
        GenericType<Organizacion> genericType = new GenericType<Organizacion>() {};
        String aux = DigestUtils.sha256Hex(password);
        try {
            Organizacion org = client1.find_XML(genericType, nif);
            if (org == null || !org.getContrasenya().equals(aux)) {
                mensaje = "Datos incorrectosssss.";
                return ERROR;
            }
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
    
}
