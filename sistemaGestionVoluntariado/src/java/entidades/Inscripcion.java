/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "inscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
    , @NamedQuery(name = "Inscripcion.findByInscripcionId", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionId = :inscripcionId")
    , @NamedQuery(name = "Inscripcion.findByFechainscripcion", query = "SELECT i FROM Inscripcion i WHERE i.fechainscripcion = :fechainscripcion")
    , @NamedQuery(name = "Inscripcion.findByAprobada", query = "SELECT i FROM Inscripcion i WHERE i.aprobada = :aprobada")
    , @NamedQuery(name = "Inscripcion.findByAsistencia", query = "SELECT i FROM Inscripcion i WHERE i.asistencia = :asistencia")})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "inscripcionId")
    private Integer inscripcionId;
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Column(name = "aprobada")
    private Boolean aprobada;
    @Column(name = "asistencia")
    private Boolean asistencia;
    @JoinColumn(name = "eventoid", referencedColumnName = "eventoid")
    @ManyToOne
    private Evento eventoid;
    @JoinColumn(name = "voluntarioid", referencedColumnName = "voluntarioId")
    @ManyToOne
    private Voluntario voluntarioid;

    public Inscripcion() {
    }

    public Inscripcion(Integer inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Integer getInscripcionId() {
        return inscripcionId;
    }

    public void setInscripcionId(Integer inscripcionId) {
        this.inscripcionId = inscripcionId;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public Boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
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
        hash += (inscripcionId != null ? inscripcionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.inscripcionId == null && other.inscripcionId != null) || (this.inscripcionId != null && !this.inscripcionId.equals(other.inscripcionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inscripcion[ inscripcionId=" + inscripcionId + " ]";
    }
    
}
