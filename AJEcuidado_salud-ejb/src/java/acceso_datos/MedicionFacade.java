/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Medicion;

/**
 *
 * @author Misael
 */
@Stateless
public class MedicionFacade extends AbstractFacade<Medicion> {

    @PersistenceContext(unitName = "AJEcuidado_salud-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicionFacade() {
        super(Medicion.class);
    }
    
    public List<Medicion> findAllMedicion(int id) {
        EntityManager em = getEntityManager();
        
        String query = "SELECT * FROM MEDICION WHERE USUARIO="+id;
        
        List<Medicion> mediciones = null;
        try {
            mediciones = em.createNativeQuery(query, Medicion.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }

        return mediciones;
    }
    
}
