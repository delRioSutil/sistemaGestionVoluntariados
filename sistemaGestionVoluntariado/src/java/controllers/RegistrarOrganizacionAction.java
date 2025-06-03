/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import entidades.Organizacion;
import serviceClients.OrganizacionJerseyClient;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author usuario
 */
public class RegistrarOrganizacionAction extends ActionSupport {
    
    private String username;
    private String email;
    private String password;
    private Integer nif;
    
    public RegistrarOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        //Definimos e instanciamos la entidad a introducir
        Organizacion org = new Organizacion(nif);
        org.setNombre(username);
        org.setCorreo(email);
        //Convertimos la contraseña en hash para mayor seguridad
        String hashed = DigestUtils.sha256Hex(password);
        org.setContrasenya(hashed);
        org.setEventoCollection(null);
        //Instanciamos cliente para usar servicio web de base de datos
        OrganizacionJerseyClient client1=new OrganizacionJerseyClient();
        client1.create_XML(org);
        return SUCCESS;
    }
    
    
    public void validate() {
        if (username.equals("") || username == null || username.length()<3 || username.length()>16) {
            addFieldError("username", "El nombre de usuario debe tener entre 3 y 16 carácteres.");
        }
        if (password.length() < 7) {
            addFieldError("password", "Para mayor seguridad cree una contraseña de más de 6 carácteres");
        }
        if (nif==null){
            addFieldError("nif", "Inserte el nif de la organización");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }
    
    
}
