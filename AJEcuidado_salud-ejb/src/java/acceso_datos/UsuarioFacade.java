/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Usuario;

/**
 *
 * @author Misael
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "AJEcuidado_salud-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findUser(String name, String password) {
        EntityManager em = getEntityManager();
        
        String query = "SELECT * FROM USUARIO WHERE NOMBREUSUARIO="+"'"+name+"'"+" AND PASSWORD="+"'"+password+"'";
        
        Usuario user = null;
        List<Usuario> users = null;
        try {
            users = em.createNativeQuery(query, Usuario.class).getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }
        if(users != null) {
            user = users.get(0);
        }
        return user;
    }
    
}
