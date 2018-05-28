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
@Table(name = "tbl_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "Permiso.findByPermiso", query = "SELECT p FROM Permiso p WHERE p.permiso = :permiso")
    , @NamedQuery(name = "Permiso.findByIcono", query = "SELECT p FROM Permiso p WHERE p.icono = :icono")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @Column(name = "permiso")
    private String permiso;
    @Column(name = "icono")
    private String icono;
    @Basic(optional = false)
    @Lob
    @Column(name = "url")
    private String url;
    @JoinTable(name = "tbl_roles_has_tbl_permisos", joinColumns = {
        @JoinColumn(name = "permiso", referencedColumnName = "id_permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "rol", referencedColumnName = "id_rol")})
    @ManyToMany
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Permiso(Integer idPermiso, String permiso, String url) {
        this.idPermiso = idPermiso;
        this.permiso = permiso;
        this.url = url;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.hypatia.simu.modelo.entidades.Permiso[ idPermiso=" + idPermiso + " ]";
    }
    
}
