/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author usuario
 */
public class CerrarSesionOrganizacionAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    
    public CerrarSesionOrganizacionAction() {
    }
    
    public String execute() throws Exception {
        session.clear();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    
}
