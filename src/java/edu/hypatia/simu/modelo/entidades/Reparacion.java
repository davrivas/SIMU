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
import javax.persistence.Lob;
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
 * @author davr
 */
@Entity
@Table(name = "tbl_reparaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r")
    , @NamedQuery(name = "Reparacion.findByIdReparacion", query = "SELECT r FROM Reparacion r WHERE r.idReparacion = :idReparacion")
    , @NamedQuery(name = "Reparacion.findByFecha", query = "SELECT r FROM Reparacion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reparacion.findByHora", query = "SELECT r FROM Reparacion r WHERE r.hora = :hora")
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
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "calificacion")
    private Integer calificacion;
    @JoinTable(name = "tbl_reparaciones_has_tbl_tipos_reparacion", joinColumns = {
        @JoinColumn(name = "reparacion", referencedColumnName = "id_reparacion")}, inverseJoinColumns = {
        @JoinColumn(name = "tipo_reparacion", referencedColumnName = "id_tipo_reparacion")})
    @ManyToMany
    private List<TipoReparacion> tipoReparacionList;
    @JoinColumn(name = "moto", referencedColumnName = "id_moto")
    @ManyToOne(optional = false)
    private Moto moto;
    @JoinColumn(name = "mecanico", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario mecanico;

    public Reparacion() {
    }

    public Reparacion(Integer idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Reparacion(Integer idReparacion, Date fecha, Date hora) {
        this.idReparacion = idReparacion;
        this.fecha = fecha;
        this.hora = hora;
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
    public List<TipoReparacion> getTipoReparacionList() {
        return tipoReparacionList;
    }

    public void setTipoReparacionList(List<TipoReparacion> tipoReparacionList) {
        this.tipoReparacionList = tipoReparacionList;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Usuario getMecanico() {
        return mecanico;
    }

    public void setMecanico(Usuario mecanico) {
        this.mecanico = mecanico;
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
