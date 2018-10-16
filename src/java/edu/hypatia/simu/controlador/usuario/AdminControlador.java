package edu.hypatia.simu.controlador.usuario;

import edu.hypatia.simu.modelo.dao.ProductoFacadeLocal;
import edu.hypatia.simu.modelo.dao.TransaccionFacadeLocal;
import edu.hypatia.simu.modelo.dao.UsuarioFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value="adminControlador")
@ViewScoped
public class AdminControlador implements Serializable {
    @EJB
    private UsuarioFacadeLocal ufl;
    @EJB
    private TransaccionFacadeLocal tfl;
    @EJB
    private ProductoFacadeLocal pfl;
    private Integer usuarios;
    private Integer transacciones;
    private Integer productos;

    public AdminControlador() {
    }

    public Integer getUsuarios() {
        return ufl.count();
    }

    public Integer getTransacciones() {
        return tfl.count();
    }

    public Integer getProductos() {
        return pfl.count();
    }

}
