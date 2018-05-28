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
 * @author davrivas
 */
@Entity
@Table(name = "tbl_detalles_transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTransaccion.findAll", query = "SELECT d FROM DetalleTransaccion d")
    , @NamedQuery(name = "DetalleTransaccion.findByIdDetalleTransaccion", query = "SELECT d FROM DetalleTransaccion d WHERE d.idDetalleTransaccion = :idDetalleTransaccion")
    , @NamedQuery(name = "DetalleTransaccion.findByCantidad", query = "SELECT d FROM DetalleTransaccion d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleTransaccion.findByPrecio", query = "SELECT d FROM DetalleTransaccion d WHERE d.precio = :precio")
    , @NamedQuery(name = "DetalleTransaccion.findByPorcentaje", query = "SELECT d FROM DetalleTransaccion d WHERE d.porcentaje = :porcentaje")})
public class DetalleTransaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_transaccion")
    private Integer idDetalleTransaccion;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @JoinColumn(name = "producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "transaccion", referencedColumnName = "id_transaccion")
    @ManyToOne(optional = false)
    private Transaccion transaccion;

    public DetalleTransaccion() {
    }

    public DetalleTransaccion(Integer idDetalleTransaccion) {
        this.idDetalleTransaccion = idDetalleTransaccion;
    }

    public DetalleTransaccion(Integer idDetalleTransaccion, int cantidad, double precio) {
        this.idDetalleTransaccion = idDetalleTransaccion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getIdDetalleTransaccion() {
        return idDetalleTransaccion;
    }

    public void setIdDetalleTransaccion(Integer idDetalleTransaccion) {
        this.idDetalleTransaccion = idDetalleTransaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleTransaccion != null ? idDetalleTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTransaccion)) {
            return false;
        }
        DetalleTransaccion other = (DetalleTransaccion) object;
        if ((this.idDetalleTransaccion == null && other.idDetalleTransaccion != null) || (this.idDetalleTransaccion != null && !this.idDetalleTransaccion.equals(other.idDetalleTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.DetalleTransaccion[ idDetalleTransaccion=" + idDetalleTransaccion + " ]";
    }
    
}
