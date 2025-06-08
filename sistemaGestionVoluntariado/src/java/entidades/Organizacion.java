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
@Table(name = "organizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizacion.findAll", query = "SELECT o FROM Organizacion o")
    , @NamedQuery(name = "Organizacion.findByOrganizacionId", query = "SELECT o FROM Organizacion o WHERE o.organizacionId = :organizacionId")
    , @NamedQuery(name = "Organizacion.findByNombre", query = "SELECT o FROM Organizacion o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Organizacion.findByCorreo", query = "SELECT o FROM Organizacion o WHERE o.correo = :correo")
    , @NamedQuery(name = "Organizacion.findByContrasenya", query = "SELECT o FROM Organizacion o WHERE o.contrasenya = :contrasenya")})
public class Organizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "organizacionId")
    private Integer organizacionId;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "correo")
    private String correo;
    @Size(max = 100)
    @Column(name = "contrasenya")
    private String contrasenya;
    @OneToMany(mappedBy = "organizacionid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Evento> eventoCollection;

    public Organizacion() {
    }

    public Organizacion(Integer organizacionId) {
        this.organizacionId = organizacionId;
    }

    public Integer getOrganizacionId() {
        return organizacionId;
    }

    public void setOrganizacionId(Integer organizacionId) {
        this.organizacionId = organizacionId;
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
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizacionId != null ? organizacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizacion)) {
            return false;
        }
        Organizacion other = (Organizacion) object;
        if ((this.organizacionId == null && other.organizacionId != null) || (this.organizacionId != null && !this.organizacionId.equals(other.organizacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Organizacion[ organizacionId=" + organizacionId + " ]";
    }
    
}
