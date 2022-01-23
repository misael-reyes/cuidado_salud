/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.GrupoalimentosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Grupoalimentos;

/**
 *
 * @author Misael
 */
@Stateless
@LocalBean
public class GrupoAlimento_ln {

    @EJB
    private GrupoalimentosFacade gaFacade;
    
    public List<Grupoalimentos> lista_grupos() {
        return gaFacade.findAll();
    }
    
    public int countGrupos() {
        return gaFacade.count();
    }
}
