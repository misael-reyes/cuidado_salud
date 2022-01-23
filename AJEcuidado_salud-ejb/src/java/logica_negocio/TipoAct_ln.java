/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.TipoactividadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Actividadusuario;
import modelo.Tipoactividad;

/**
 *
 * @author Misael
 */
@Stateless
@LocalBean
public class TipoAct_ln {

    @EJB
    private TipoactividadFacade tipoactFacade;
    
    public Tipoactividad recuperaTipoAct(int id) {
        return tipoactFacade.find(id);
    }
    
    public List<Tipoactividad> lista_act() {
        return tipoactFacade.findAll();
    }
}
