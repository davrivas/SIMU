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
@Table(name = "tbl_tipos_accesorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAccesorio.findAll", query = "SELECT t FROM TipoAccesorio t")
    , @NamedQuery(name = "TipoAccesorio.findByIdTipoAccesorio", query = "SELECT t FROM TipoAccesorio t WHERE t.idTipoAccesorio = :idTipoAccesorio")
    , @NamedQuery(name = "TipoAccesorio.findByTipoAccesorio", query = "SELECT t FROM TipoAccesorio t WHERE t.tipoAccesorio = :tipoAccesorio")})
public class TipoAccesorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_accesorio")
    private Integer idTipoAccesorio;
    @Basic(optional = false)
    @Column(name = "tipo_accesorio")
    private String tipoAccesorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAccesorio")
    private List<Accesorio> accesorioList;

    public TipoAccesorio() {
    }

    public TipoAccesorio(Integer idTipoAccesorio) {
        this.idTipoAccesorio = idTipoAccesorio;
    }

    public TipoAccesorio(Integer idTipoAccesorio, String tipoAccesorio) {
        this.idTipoAccesorio = idTipoAccesorio;
        this.tipoAccesorio = tipoAccesorio;
    }

    public Integer getIdTipoAccesorio() {
        return idTipoAccesorio;
    }

    public void setIdTipoAccesorio(Integer idTipoAccesorio) {
        this.idTipoAccesorio = idTipoAccesorio;
    }

    public String getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(String tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    @XmlTransient
    public List<Accesorio> getAccesorioList() {
        return accesorioList;
    }

    public void setAccesorioList(List<Accesorio> accesorioList) {
        this.accesorioList = accesorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAccesorio != null ? idTipoAccesorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAccesorio)) {
            return false;
        }
        TipoAccesorio other = (TipoAccesorio) object;
        if ((this.idTipoAccesorio == null && other.idTipoAccesorio != null) || (this.idTipoAccesorio != null && !this.idTipoAccesorio.equals(other.idTipoAccesorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.TipoAccesorio[ idTipoAccesorio=" + idTipoAccesorio + " ]";
    }
    
}
