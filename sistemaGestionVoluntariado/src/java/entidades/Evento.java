/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByEventoid", query = "SELECT e FROM Evento e WHERE e.eventoid = :eventoid")
    , @NamedQuery(name = "Evento.findByNombre", query = "SELECT e FROM Evento e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Evento.findByFechainicio", query = "SELECT e FROM Evento e WHERE e.fechainicio = :fechainicio")
    , @NamedQuery(name = "Evento.findByFechafin", query = "SELECT e FROM Evento e WHERE e.fechafin = :fechafin")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "eventoid")
    private Integer eventoid;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(mappedBy = "eventoid")
    private Collection<Donacion> donacionCollection;
    @OneToMany(mappedBy = "eventoid")
    private Collection<Tarea> tareaCollection;
    @JoinColumn(name = "organizacionid", referencedColumnName = "organizacionId")
    @ManyToOne
    private Organizacion organizacionid;
    @OneToMany(mappedBy = "eventoid")
    private Collection<Inscripcion> inscripcionCollection;
    @OneToMany(mappedBy = "eventoid")
    private Collection<Informe> informeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private Collection<Valoracion> valoracionCollection;

    public Evento() {
    }

    public Evento(Integer eventoid) {
        this.eventoid = eventoid;
    }

    public Integer getEventoid() {
        return eventoid;
    }

    public void setEventoid(Integer eventoid) {
        this.eventoid = eventoid;
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

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public Collection<Donacion> getDonacionCollection() {
        return donacionCollection;
    }

    public void setDonacionCollection(Collection<Donacion> donacionCollection) {
        this.donacionCollection = donacionCollection;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Organizacion getOrganizacionid() {
        return organizacionid;
    }

    public void setOrganizacionid(Organizacion organizacionid) {
        this.organizacionid = organizacionid;
    }

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
    }

    @XmlTransient
    public Collection<Informe> getInformeCollection() {
        return informeCollection;
    }

    public void setInformeCollection(Collection<Informe> informeCollection) {
        this.informeCollection = informeCollection;
    }

    @XmlTransient
    public Collection<Valoracion> getValoracionCollection() {
        return valoracionCollection;
    }

    public void setValoracionCollection(Collection<Valoracion> valoracionCollection) {
        this.valoracionCollection = valoracionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventoid != null ? eventoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.eventoid == null && other.eventoid != null) || (this.eventoid != null && !this.eventoid.equals(other.eventoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Evento[ eventoid=" + eventoid + " ]";
    }
    
}
