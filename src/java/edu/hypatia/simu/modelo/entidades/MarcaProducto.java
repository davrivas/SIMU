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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author davrivas
 */
@Entity
@Table(name = "tbl_marcas_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaProducto.findAll", query = "SELECT m FROM MarcaProducto m")
    , @NamedQuery(name = "MarcaProducto.findByIdMarcaProducto", query = "SELECT m FROM MarcaProducto m WHERE m.idMarcaProducto = :idMarcaProducto")
    , @NamedQuery(name = "MarcaProducto.findByMarcaProducto", query = "SELECT m FROM MarcaProducto m WHERE m.marcaProducto = :marcaProducto")})
public class MarcaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca_producto")
    private Integer idMarcaProducto;
    @Basic(optional = false)
    @Column(name = "marca_producto")
    private String marcaProducto;
    @JoinColumn(name = "tipo_producto", referencedColumnName = "id_tipo_producto")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaProducto")
    private List<Producto> productoList;

    public MarcaProducto() {
    }

    public MarcaProducto(Integer idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public MarcaProducto(Integer idMarcaProducto, String marcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
        this.marcaProducto = marcaProducto;
    }

    public Integer getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(Integer idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
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
        hash += (idMarcaProducto != null ? idMarcaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaProducto)) {
            return false;
        }
        MarcaProducto other = (MarcaProducto) object;
        if ((this.idMarcaProducto == null && other.idMarcaProducto != null) || (this.idMarcaProducto != null && !this.idMarcaProducto.equals(other.idMarcaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.MarcaProducto[ idMarcaProducto=" + idMarcaProducto + " ]";
    }
    
}
