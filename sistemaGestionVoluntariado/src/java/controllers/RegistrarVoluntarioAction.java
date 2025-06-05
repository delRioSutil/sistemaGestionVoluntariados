/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cliente.VoluntarioJerseyClient;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import entidades.Voluntario;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Antonio
 */
public class RegistrarVoluntarioAction extends ActionSupport {
    
    private String username;
    private String email;
    private String password;
    
    
    public RegistrarVoluntarioAction() {
    }
    
    public String execute() throws Exception {
        //Definimos e instanciamos la entidad a introducir
        VoluntarioJerseyClient client1=new VoluntarioJerseyClient();
        String id = client1.countREST();
        Integer idInt = Integer.valueOf(id);
        Voluntario vol = new Voluntario();
        vol.setVoluntarioId(idInt + 1);
        vol.setCorreo(email);
        vol.setNombre(username);
        //Convertimos la contraseña en hash para mayor seguridad
        String hashed = DigestUtils.sha256Hex(password);
        vol.setContrasenya(hashed);
        vol.setDonacionCollection(null);
        vol.setInscripcionCollection(null);
        vol.setTareaCollection(null);
        vol.setValoracionCollection(null);
        client1.create_XML(vol);
       
        
        //Instanciamos cliente para usar servicio web de base de datos
        
        
        return SUCCESS;
    }
        public void validate() {
        if (username.equals("") || username == null || username.length()<3 || username.length()>16) {
            addFieldError("username", "El nombre de usuario debe tener entre 3 y 16 carácteres.");
        }
        if (password.length() < 7) {
            addFieldError("password", "Para mayor seguridad cree una contraseña de más de 6 carácteres");
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

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
        
    
}
