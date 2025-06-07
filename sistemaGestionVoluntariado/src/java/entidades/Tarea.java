/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t")
    , @NamedQuery(name = "Tarea.findByTareaId", query = "SELECT t FROM Tarea t WHERE t.tareaId = :tareaId")
    , @NamedQuery(name = "Tarea.findByNombre", query = "SELECT t FROM Tarea t WHERE t.nombre = :nombre")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)   
    @Column(name = "tareaId")
    private Integer tareaId;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "eventoid", referencedColumnName = "eventoid")
    @ManyToOne
    private Evento eventoid;
    @JoinColumn(name = "voluntarioid", referencedColumnName = "voluntarioId")
    @ManyToOne
    private Voluntario voluntarioid;

    public Tarea() {
    }

    public Tarea(Integer tareaId) {
        this.tareaId = tareaId;
    }

    public Integer getTareaId() {
        return tareaId;
    }

    public void setTareaId(Integer tareaId) {
        this.tareaId = tareaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Evento getEventoid() {
        return eventoid;
    }

    public void setEventoid(Evento eventoid) {
        this.eventoid = eventoid;
    }

    public Voluntario getVoluntarioid() {
        return voluntarioid;
    }

    public void setVoluntarioid(Voluntario voluntarioid) {
        this.voluntarioid = voluntarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tareaId != null ? tareaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.tareaId == null && other.tareaId != null) || (this.tareaId != null && !this.tareaId.equals(other.tareaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tarea[ tareaId=" + tareaId + " ]";
    }
    
}
