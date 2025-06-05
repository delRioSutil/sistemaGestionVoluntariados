/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "voluntario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voluntario.findAll", query = "SELECT v FROM Voluntario v")
    , @NamedQuery(name = "Voluntario.findByVoluntarioId", query = "SELECT v FROM Voluntario v WHERE v.voluntarioId = :voluntarioId")
    , @NamedQuery(name = "Voluntario.findByNombre", query = "SELECT v FROM Voluntario v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Voluntario.findByCorreo", query = "SELECT v FROM Voluntario v WHERE v.correo = :correo")
    , @NamedQuery(name = "Voluntario.findByContrasenya", query = "SELECT v FROM Voluntario v WHERE v.contrasenya = :contrasenya")})
public class Voluntario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "voluntarioId")
    private Integer voluntarioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 23)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrasenya")
    private String contrasenya;
    @OneToMany(mappedBy = "voluntarioid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Donacion> donacionCollection;
    @OneToMany(mappedBy = "voluntarioid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Tarea> tareaCollection;
    @OneToMany(mappedBy = "voluntarioid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Inscripcion> inscripcionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voluntario")
    private Collection<Valoracion> valoracionCollection;

    public Voluntario() {
    }

    public Voluntario(Integer voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    public Voluntario(Integer voluntarioId, String nombre, String correo, String contrasenya) {
        this.voluntarioId = voluntarioId;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenya = contrasenya;
    }

    public Integer getVoluntarioId() {
        return voluntarioId;
    }

    public void setVoluntarioId(Integer voluntarioId) {
        this.voluntarioId = voluntarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    @XmlTransient
    public Collection<Inscripcion> getInscripcionCollection() {
        return inscripcionCollection;
    }

    public void setInscripcionCollection(Collection<Inscripcion> inscripcionCollection) {
        this.inscripcionCollection = inscripcionCollection;
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
        hash += (voluntarioId != null ? voluntarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voluntario)) {
            return false;
        }
        Voluntario other = (Voluntario) object;
        if ((this.voluntarioId == null && other.voluntarioId != null) || (this.voluntarioId != null && !this.voluntarioId.equals(other.voluntarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Voluntario[ voluntarioId=" + voluntarioId + " ]";
    }
    
}
