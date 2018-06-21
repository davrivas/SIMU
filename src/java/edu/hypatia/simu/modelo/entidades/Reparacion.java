/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davrivas
 */
@Entity
@Table(name = "tbl_reparaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByIdReparacion", query = "SELECT r FROM Reparacion r WHERE r.idReparacion = :idReparacion")
    , @NamedQuery(name = "Reparacion.findByFecha", query = "SELECT r FROM Reparacion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reparacion.findByDescripcion", query = "SELECT r FROM Reparacion r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Reparacion.findByCalificacion", query = "SELECT r FROM Reparacion r WHERE r.calificacion = :calificacion")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reparacion")
    private Integer idReparacion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "calificacion")
    private Integer calificacion;
    @JoinTable(name = "tbl_reparaciones_has_tbl_tipos_servicio_reparacion", joinColumns = {
        @JoinColumn(name = "reparacion", referencedColumnName = "id_reparacion")}, inverseJoinColumns = {
        @JoinColumn(name = "tipo_servicio_reparacion", referencedColumnName = "id_tipo_servicio_reparacion")})
    @ManyToMany
    private List<TipoServicioReparacion> tipoServicioReparacionList;
    @JoinColumn(name = "mecanico", referencedColumnName = "id_mecanico")
    @ManyToOne(optional = false)
    private Mecanico mecanico;
    @JoinColumn(name = "moto", referencedColumnName = "id_moto")
    @ManyToOne(optional = false)
    private Moto moto;

    public Reparacion() {
    }

    public Reparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Reparacion(Integer idReparacion, Date fecha) {
        this.idReparacion = idReparacion;
        this.fecha = fecha;
    }

    public Integer getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    @XmlTransient
    public List<TipoServicioReparacion> getTipoServicioReparacionList() {
        return tipoServicioReparacionList;
    }

    public void setTipoServicioReparacionList(List<TipoServicioReparacion> tipoServicioReparacionList) {
        this.tipoServicioReparacionList = tipoServicioReparacionList;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparacion != null ? idReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.idReparacion == null && other.idReparacion != null) || (this.idReparacion != null && !this.idReparacion.equals(other.idReparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Reparacion[ idReparacion=" + idReparacion + " ]";
    }

}
