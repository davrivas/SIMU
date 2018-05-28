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
import javax.persistence.Lob;
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
@Table(name = "tbl_fotos_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FotoProducto.findAll", query = "SELECT f FROM FotoProducto f")
    , @NamedQuery(name = "FotoProducto.findByIdFoto", query = "SELECT f FROM FotoProducto f WHERE f.idFoto = :idFoto")})
public class FotoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_foto")
    private Integer idFoto;
    @Basic(optional = false)
    @Lob
    @Column(name = "ruta_archivo_foto")
    private String rutaArchivoFoto;
    @JoinTable(name = "tbl_productos_has_tbl_fotos_producto", joinColumns = {
        @JoinColumn(name = "foto", referencedColumnName = "id_foto")}, inverseJoinColumns = {
        @JoinColumn(name = "producto", referencedColumnName = "id_producto")})
    @ManyToMany
    private List<Producto> productoList;

    public FotoProducto() {
    }

    public FotoProducto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public FotoProducto(Integer idFoto, String rutaArchivoFoto) {
        this.idFoto = idFoto;
        this.rutaArchivoFoto = rutaArchivoFoto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getRutaArchivoFoto() {
        return rutaArchivoFoto;
    }

    public void setRutaArchivoFoto(String rutaArchivoFoto) {
        this.rutaArchivoFoto = rutaArchivoFoto;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFoto != null ? idFoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FotoProducto)) {
            return false;
        }
        FotoProducto other = (FotoProducto) object;
        if ((this.idFoto == null && other.idFoto != null) || (this.idFoto != null && !this.idFoto.equals(other.idFoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.FotoProducto[ idFoto=" + idFoto + " ]";
    }
    
}
