/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import acceso_datos.MedicionFacade;
import java.util.List;
import modelo.Medicion;

/**
 *
 * @author Misael
 */
@Stateless
@LocalBean
public class Medicion_ln {

    @EJB
    private MedicionFacade medicionFacade;
    
    public void guardar(Medicion medicion) {
        medicionFacade.create(medicion);
    }
    
    public List<Medicion> lista_m() {
        return medicionFacade.findAll();
    }
    
    public Medicion recuperaUsuario(int id) {
        return medicionFacade.find(id);
    }
}
