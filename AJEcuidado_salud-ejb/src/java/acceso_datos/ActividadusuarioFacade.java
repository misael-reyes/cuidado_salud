/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Actividadusuario;

/**
 *
 * @author Misael
 */
@Stateless
public class ActividadusuarioFacade extends AbstractFacade<Actividadusuario> {

    @PersistenceContext(unitName = "AJEcuidado_salud-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadusuarioFacade() {
        super(Actividadusuario.class);
    }
    
    public List<Actividadusuario> findAllActividades(int id) {
        EntityManager em = getEntityManager();
        
        String query = "SELECT * FROM ACTIViDADUSUARIO WHERE USUARIO="+id;
        
        List<Actividadusuario> actividades = null;
        try {
            actividades = em.createNativeQuery(query, Actividadusuario.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }

        return actividades;
    }
    
}
