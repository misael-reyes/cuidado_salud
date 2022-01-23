/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.ActividadusuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Actividadusuario;

/**
 *
 * @author Misael
 */
@Stateless
@LocalBean
public class ActividadUser_ln {

    @EJB
    private ActividadusuarioFacade actUserFacade;
    
    public void guardar(Actividadusuario au) {
        actUserFacade.create(au);
    }
    
    public List<Actividadusuario> listaa(int iduser) {
        return actUserFacade.findAllActividades(iduser);
    }
    
    public Actividadusuario buscarActUser(int id) {
        return actUserFacade.find(id);
    }
}
