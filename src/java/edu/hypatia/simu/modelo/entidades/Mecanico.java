/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davrivas
 */
@Entity
@Table(name = "tbl_mecanicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecanico.findAll", query = "SELECT m FROM Mecanico m")
    , @NamedQuery(name = "Mecanico.findByIdMecanico", query = "SELECT m FROM Mecanico m WHERE m.idMecanico = :idMecanico")})
public class Mecanico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_mecanico")
    private Integer idMecanico;
    @JoinColumn(name = "id_mecanico", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mecanico")
    private List<Reparacion> reparacionList;

    public Mecanico() {
    }

    public Mecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Integer getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(Integer idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public List<Reparacion> getReparacionList() {
        return reparacionList;
    }

    public void setReparacionList(List<Reparacion> reparacionList) {
        this.reparacionList = reparacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMecanico != null ? idMecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanico)) {
            return false;
        }
        Mecanico other = (Mecanico) object;
        if ((this.idMecanico == null && other.idMecanico != null) || (this.idMecanico != null && !this.idMecanico.equals(other.idMecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Mecanico[ idMecanico=" + idMecanico + " ]";
    }
    
}
