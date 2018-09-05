/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hypatia.simu.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author davr
 */
@Entity
@Table(name = "tbl_accesorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accesorio.findAll", query = "SELECT a FROM Accesorio a")
    , @NamedQuery(name = "Accesorio.findByIdAccesorio", query = "SELECT a FROM Accesorio a WHERE a.idAccesorio = :idAccesorio")
    , @NamedQuery(name = "Accesorio.findByNombre", query = "SELECT a FROM Accesorio a WHERE a.nombre = :nombre")})
public class Accesorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_accesorio")
    private Integer idAccesorio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "tipo_accesorio", referencedColumnName = "id_tipo_accesorio")
    @ManyToOne(optional = false)
    private TipoAccesorio tipoAccesorio;

    public Accesorio() {
    }

    public Accesorio(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public Accesorio(Integer idAccesorio, String nombre) {
        this.idAccesorio = idAccesorio;
        this.nombre = nombre;
    }

    public Integer getIdAccesorio() {
        return idAccesorio;
    }

    public void setIdAccesorio(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoAccesorio getTipoAccesorio() {
        return tipoAccesorio;
    }

    public void setTipoAccesorio(TipoAccesorio tipoAccesorio) {
        this.tipoAccesorio = tipoAccesorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccesorio != null ? idAccesorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesorio)) {
            return false;
        }
        Accesorio other = (Accesorio) object;
        if ((this.idAccesorio == null && other.idAccesorio != null) || (this.idAccesorio != null && !this.idAccesorio.equals(other.idAccesorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Accesorio[ idAccesorio=" + idAccesorio + " ]";
    }
    
}
