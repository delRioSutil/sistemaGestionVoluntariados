package controllers;

import cliente.EventoClient;
import cliente.OrganizacionClient;
import com.opensymphony.xwork2.ActionSupport;
import entidades.Voluntario;
import javax.ws.rs.core.GenericType;
import cliente.VoluntarioJerseyClient;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.util.logging.Logger;
import entidades.Evento;
import entidades.Organizacion;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.interceptor.SessionAware;

public class LoginVoluntarioAction extends ActionSupport implements SessionAware{

    private String id;
    private String password;
    private Voluntario voluntario;
    private Map<String, Object> session;
    private List<Evento> eventos;

    public LoginVoluntarioAction() {
    }

    @Override
     public String execute() throws Exception  {
        //Instanciamos el cliente y buscamos uno con el mismo nif
        VoluntarioJerseyClient client1=new VoluntarioJerseyClient();
        //Llamamos al cliente de eventos y cargamos todos los eventos del sistema en variable eventos.
        EventoClient client2 = new EventoClient();
        GenericType<List<Evento>> genericTypeEventos = new GenericType<List<Evento>>() {};
        
        
        List<Evento> todosLosEventos = client2.findAll_XML(genericTypeEventos);
        eventos = new java.util.ArrayList<>();

        //Obtener fecha actual
        Date hoy = new Date();

        //Filtrar solo eventos futuros
        for (Evento e : todosLosEventos) {
            if (e.getFechainicio() != null && !e.getFechainicio().before(hoy)) {
                eventos.add(e);
            }
        }
        
        
        
        
        GenericType<Voluntario> genericType = new GenericType<Voluntario>() {};
        String mensaje;
        String aux = DigestUtils.sha256Hex(password);
        try {
            Voluntario vol = client1.find_XML(genericType, id);
            if (vol == null || !vol.getContrasenya().equals(aux)) {
                mensaje = "Datos incorrectos.";
                return ERROR;
            }
         session.put("voluntarioId", vol.getVoluntarioId());
         
         return SUCCESS;

        } catch (javax.ws.rs.NotFoundException e) {
            mensaje = "Datos incorrectos.";
            e.printStackTrace();
            return ERROR;

        } catch (javax.ws.rs.InternalServerErrorException e) {
            mensaje = "Error interno al buscar el voluntario.";
            e.printStackTrace(); //Ver detalles en consola
            return ERROR;
        }
    }
    
     public void validate() {
        if (password == null || password.trim().isEmpty()) {
            addFieldError("password", "Introduzca contraseña");
        }
        if (id==null || id.trim().isEmpty()){
            addFieldError("id", "Inserte el id de la organización");
        }
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
  

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(Voluntario voluntario) {
        this.voluntario = voluntario;
    }

    @Override
    public void setSession(Map<String, Object> session) {
 this.session = session;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
}
