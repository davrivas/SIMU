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
@Table(name = "tbl_motos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moto.findAll", query = "SELECT m FROM Moto m")
    , @NamedQuery(name = "Moto.findByIdMoto", query = "SELECT m FROM Moto m WHERE m.idMoto = :idMoto")
    , @NamedQuery(name = "Moto.findByPlaca", query = "SELECT m FROM Moto m WHERE m.placa = :placa")
    , @NamedQuery(name = "Moto.findByCilindraje", query = "SELECT m FROM Moto m WHERE m.cilindraje = :cilindraje")
    , @NamedQuery(name = "Moto.findByColor", query = "SELECT m FROM Moto m WHERE m.color = :color")
    , @NamedQuery(name = "Moto.findByModelo", query = "SELECT m FROM Moto m WHERE m.modelo = :modelo")
    , @NamedQuery(name = "Moto.findByKilometraje", query = "SELECT m FROM Moto m WHERE m.kilometraje = :kilometraje")})
public class Moto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moto")
    private Integer idMoto;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "cilindraje")
    private String cilindraje;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "kilometraje")
    private String kilometraje;
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    @JoinColumn(name = "estado_moto", referencedColumnName = "id_estado_moto")
    @ManyToOne(optional = false)
    private EstadoMoto estadoMoto;
    @JoinColumn(name = "producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moto")
    private List<Reparacion> reparacionList;

    public Moto() {
    }

    public Moto(Integer idMoto) {
        this.idMoto = idMoto;
    }

    public Moto(Integer idMoto, String placa, String cilindraje, String color, String modelo, String kilometraje) {
        this.idMoto = idMoto;
        this.placa = placa;
        this.cilindraje = cilindraje;
        this.color = color;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    public Integer getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Integer idMoto) {
        this.idMoto = idMoto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoMoto getEstadoMoto() {
        return estadoMoto;
    }

    public void setEstadoMoto(EstadoMoto estadoMoto) {
        this.estadoMoto = estadoMoto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        hash += (idMoto != null ? idMoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moto)) {
            return false;
        }
        Moto other = (Moto) object;
        if ((this.idMoto == null && other.idMoto != null) || (this.idMoto != null && !this.idMoto.equals(other.idMoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Moto[ idMoto=" + idMoto + " ]";
    }
    
}
