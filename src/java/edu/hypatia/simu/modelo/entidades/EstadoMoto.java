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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davr
 */
@Entity
@Table(name = "tbl_estados_moto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoMoto.findAll", query = "SELECT e FROM EstadoMoto e")
    , @NamedQuery(name = "EstadoMoto.findByIdEstadoMoto", query = "SELECT e FROM EstadoMoto e WHERE e.idEstadoMoto = :idEstadoMoto")
    , @NamedQuery(name = "EstadoMoto.findByNombreEstado", query = "SELECT e FROM EstadoMoto e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoMoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_moto")
    private Integer idEstadoMoto;
    @Basic(optional = false)
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoMoto")
    private List<Moto> motoList;

    public EstadoMoto() {
    }

    public EstadoMoto(Integer idEstadoMoto) {
        this.idEstadoMoto = idEstadoMoto;
    }

    public EstadoMoto(Integer idEstadoMoto, String nombreEstado) {
        this.idEstadoMoto = idEstadoMoto;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstadoMoto() {
        return idEstadoMoto;
    }

    public void setIdEstadoMoto(Integer idEstadoMoto) {
        this.idEstadoMoto = idEstadoMoto;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public List<Moto> getMotoList() {
        return motoList;
    }

    public void setMotoList(List<Moto> motoList) {
        this.motoList = motoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoMoto != null ? idEstadoMoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMoto)) {
            return false;
        }
        EstadoMoto other = (EstadoMoto) object;
        if ((this.idEstadoMoto == null && other.idEstadoMoto != null) || (this.idEstadoMoto != null && !this.idEstadoMoto.equals(other.idEstadoMoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.EstadoMoto[ idEstadoMoto=" + idEstadoMoto + " ]";
    }
    
}
