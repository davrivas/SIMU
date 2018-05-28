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
 * @author davrivas
 */
@Entity
@Table(name = "tbl_tipos_servicio_reparacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoServicioReparacion.findAll", query = "SELECT t FROM TipoServicioReparacion t")
    , @NamedQuery(name = "TipoServicioReparacion.findByIdTipoServicioReparacion", query = "SELECT t FROM TipoServicioReparacion t WHERE t.idTipoServicioReparacion = :idTipoServicioReparacion")
    , @NamedQuery(name = "TipoServicioReparacion.findByServicio", query = "SELECT t FROM TipoServicioReparacion t WHERE t.servicio = :servicio")})
public class TipoServicioReparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_servicio_reparacion")
    private Integer idTipoServicioReparacion;
    @Basic(optional = false)
    @Column(name = "servicio")
    private String servicio;
    @JoinTable(name = "tbl_reparaciones_has_tbl_tipos_servicio_reparacion", joinColumns = {
        @JoinColumn(name = "tipo_servicio_reparacion", referencedColumnName = "id_tipo_servicio_reparacion")}, inverseJoinColumns = {
        @JoinColumn(name = "reparacion", referencedColumnName = "id_reparacion")})
    @ManyToMany
    private List<Reparacion> reparacionList;

    public TipoServicioReparacion() {
    }

    public TipoServicioReparacion(Integer idTipoServicioReparacion) {
        this.idTipoServicioReparacion = idTipoServicioReparacion;
    }

    public TipoServicioReparacion(Integer idTipoServicioReparacion, String servicio) {
        this.idTipoServicioReparacion = idTipoServicioReparacion;
        this.servicio = servicio;
    }

    public Integer getIdTipoServicioReparacion() {
        return idTipoServicioReparacion;
    }

    public void setIdTipoServicioReparacion(Integer idTipoServicioReparacion) {
        this.idTipoServicioReparacion = idTipoServicioReparacion;
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
        hash += (idTipoServicioReparacion != null ? idTipoServicioReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicioReparacion)) {
            return false;
        }
        TipoServicioReparacion other = (TipoServicioReparacion) object;
        if ((this.idTipoServicioReparacion == null && other.idTipoServicioReparacion != null) || (this.idTipoServicioReparacion != null && !this.idTipoServicioReparacion.equals(other.idTipoServicioReparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.TipoServicioReparacion[ idTipoServicioReparacion=" + idTipoServicioReparacion + " ]";
    }
    
}
