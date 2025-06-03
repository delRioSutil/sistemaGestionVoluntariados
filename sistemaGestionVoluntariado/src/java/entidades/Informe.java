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
@Table(name = "informe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i")
    , @NamedQuery(name = "Informe.findByInformeId", query = "SELECT i FROM Informe i WHERE i.informeId = :informeId")
    , @NamedQuery(name = "Informe.findByVoluntariosAsistencia", query = "SELECT i FROM Informe i WHERE i.voluntariosAsistencia = :voluntariosAsistencia")
    , @NamedQuery(name = "Informe.findByRecaudacion", query = "SELECT i FROM Informe i WHERE i.recaudacion = :recaudacion")})
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "informeId")
    private Integer informeId;
    @Lob
    @Size(max = 65535)
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "voluntariosAsistencia")
    private Integer voluntariosAsistencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "recaudacion")
    private Float recaudacion;
    @JoinColumn(name = "eventoid", referencedColumnName = "eventoid")
    @ManyToOne
    private Evento eventoid;

    public Informe() {
    }

    public Informe(Integer informeId) {
        this.informeId = informeId;
    }

    public Integer getInformeId() {
        return informeId;
    }

    public void setInformeId(Integer informeId) {
        this.informeId = informeId;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Integer getVoluntariosAsistencia() {
        return voluntariosAsistencia;
    }

    public void setVoluntariosAsistencia(Integer voluntariosAsistencia) {
        this.voluntariosAsistencia = voluntariosAsistencia;
    }

    public Float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Float recaudacion) {
        this.recaudacion = recaudacion;
    }

    public Evento getEventoid() {
        return eventoid;
    }

    public void setEventoid(Evento eventoid) {
        this.eventoid = eventoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informeId != null ? informeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.informeId == null && other.informeId != null) || (this.informeId != null && !this.informeId.equals(other.informeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Informe[ informeId=" + informeId + " ]";
    }
    
}
