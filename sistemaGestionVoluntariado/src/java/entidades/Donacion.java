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
@Table(name = "donacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donacion.findAll", query = "SELECT d FROM Donacion d")
    , @NamedQuery(name = "Donacion.findByDonacionId", query = "SELECT d FROM Donacion d WHERE d.donacionId = :donacionId")
    , @NamedQuery(name = "Donacion.findByCantidad", query = "SELECT d FROM Donacion d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Donacion.findByFecha", query = "SELECT d FROM Donacion d WHERE d.fecha = :fecha")})
public class Donacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "donacionId")
    private Integer donacionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "voluntarioid", referencedColumnName = "voluntarioId")
    @ManyToOne
    private Voluntario voluntarioid;
    @JoinColumn(name = "eventoid", referencedColumnName = "eventoid")
    @ManyToOne
    private Evento eventoid;

    public Donacion() {
    }

    public Donacion(Integer donacionId) {
        this.donacionId = donacionId;
    }

    public Integer getDonacionId() {
        return donacionId;
    }

    public void setDonacionId(Integer donacionId) {
        this.donacionId = donacionId;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Voluntario getVoluntarioid() {
        return voluntarioid;
    }

    public void setVoluntarioid(Voluntario voluntarioid) {
        this.voluntarioid = voluntarioid;
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
        hash += (donacionId != null ? donacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donacion)) {
            return false;
        }
        Donacion other = (Donacion) object;
        if ((this.donacionId == null && other.donacionId != null) || (this.donacionId != null && !this.donacionId.equals(other.donacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Donacion[ donacionId=" + donacionId + " ]";
    }
    
}
