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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByReferencia", query = "SELECT p FROM Producto p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByPorcentajeDescuento", query = "SELECT p FROM Producto p WHERE p.porcentajeDescuento = :porcentajeDescuento")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje_descuento")
    private Double porcentajeDescuento;
    @ManyToMany(mappedBy = "productoList")
    private List<FotoProducto> fotoProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Accesorio> accesorioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<DetalleTransaccion> detalleTransaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Moto> motoList;
    @JoinColumn(name = "marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    private Marca marca;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String referencia, double precio) {
        this.idProducto = idProducto;
        this.referencia = referencia;
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @XmlTransient
    public List<FotoProducto> getFotoProductoList() {
        return fotoProductoList;
    }

    public void setFotoProductoList(List<FotoProducto> fotoProductoList) {
        this.fotoProductoList = fotoProductoList;
    }

    @XmlTransient
    public List<Accesorio> getAccesorioList() {
        return accesorioList;
    }

    public void setAccesorioList(List<Accesorio> accesorioList) {
        this.accesorioList = accesorioList;
    }

    @XmlTransient
    public List<DetalleTransaccion> getDetalleTransaccionList() {
        return detalleTransaccionList;
    }

    public void setDetalleTransaccionList(List<DetalleTransaccion> detalleTransaccionList) {
        this.detalleTransaccionList = detalleTransaccionList;
    }

    @XmlTransient
    public List<Moto> getMotoList() {
        return motoList;
    }

    public void setMotoList(List<Moto> motoList) {
        this.motoList = motoList;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
