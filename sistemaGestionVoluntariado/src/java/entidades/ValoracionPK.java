/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Embeddable
public class ValoracionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "eventoid")
    private int eventoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voluntarioid")
    private int voluntarioid;

    public ValoracionPK() {
    }

    public ValoracionPK(int eventoid, int voluntarioid) {
        this.eventoid = eventoid;
        this.voluntarioid = voluntarioid;
    }

    public int getEventoid() {
        return eventoid;
    }

    public void setEventoid(int eventoid) {
        this.eventoid = eventoid;
    }

    public int getVoluntarioid() {
        return voluntarioid;
    }

    public void setVoluntarioid(int voluntarioid) {
        this.voluntarioid = voluntarioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) eventoid;
        hash += (int) voluntarioid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValoracionPK)) {
            return false;
        }
        ValoracionPK other = (ValoracionPK) object;
        if (this.eventoid != other.eventoid) {
            return false;
        }
        if (this.voluntarioid != other.voluntarioid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ValoracionPK[ eventoid=" + eventoid + ", voluntarioid=" + voluntarioid + " ]";
    }
    
}
