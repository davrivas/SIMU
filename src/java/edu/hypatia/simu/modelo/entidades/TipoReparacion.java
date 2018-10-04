/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davr
 */
@Entity
@Table(name = "tbl_tipos_reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReparacion.findAll", query = "SELECT t FROM TipoReparacion t")
    , @NamedQuery(name = "TipoReparacion.findByIdTipoReparacion", query = "SELECT t FROM TipoReparacion t WHERE t.idTipoReparacion = :idTipoReparacion")
    , @NamedQuery(name = "TipoReparacion.findByServicio", query = "SELECT t FROM TipoReparacion t WHERE t.servicio = :servicio")})
public class TipoReparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_reparacion")
    private Integer idTipoReparacion;
    @Basic(optional = false)
    @Column(name = "servicio")
    private String servicio;
    @JoinTable(name = "tbl_reparaciones_has_tbl_tipos_reparacion", joinColumns = {
        @JoinColumn(name = "tipo_reparacion", referencedColumnName = "id_tipo_reparacion")}, inverseJoinColumns = {
        @JoinColumn(name = "reparacion", referencedColumnName = "id_reparacion")})
    @ManyToMany
    private List<Reparacion> reparacionList;

    public TipoReparacion() {
    }

    public TipoReparacion(Integer idTipoReparacion) {
        this.idTipoReparacion = idTipoReparacion;
    }

    public TipoReparacion(Integer idTipoReparacion, String servicio) {
        this.idTipoReparacion = idTipoReparacion;
        this.servicio = servicio;
    }

    public Integer getIdTipoReparacion() {
        return idTipoReparacion;
    }

    public void setIdTipoReparacion(Integer idTipoReparacion) {
        this.idTipoReparacion = idTipoReparacion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
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
        hash += (idTipoReparacion != null ? idTipoReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReparacion)) {
            return false;
        }
        TipoReparacion other = (TipoReparacion) object;
        if ((this.idTipoReparacion == null && other.idTipoReparacion != null) || (this.idTipoReparacion != null && !this.idTipoReparacion.equals(other.idTipoReparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.TipoReparacion[ idTipoReparacion=" + idTipoReparacion + " ]";
    }
    
}
