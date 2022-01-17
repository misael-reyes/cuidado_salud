/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logica_negocio.Medicion_ln;
import logica_negocio.Usuario_ln;
import modelo.Medicion;
import modelo.Usuario;

/**
 *
 * @author Misael
 *
 * Bean administrable
 *
 */
@Named(value = "acceso")
@SessionScoped
public class Acceso implements Serializable {

    @EJB
    private Usuario_ln usuario_ln;
    @EJB
    private Medicion_ln medicion_ln;

    //atributos entity
    private Usuario user;
    private Medicion medicion;

    //atributos para autenticarse
    private String nameUser;
    private String password;

    public Acceso() {
        user = new Usuario();
        medicion = new Medicion();
    }

    //MÉTODOS SET Y GET
    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Medicion getMedicion() {
        return medicion;
    }

    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }

    //MÉTODOS DEL BEAN ADMINISTRABLE
    public void autenticarse() throws IOException {
        user = usuario_ln.recuperaUsuario(nameUser, password);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("ingresar_medidas.xhtml");
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales invalidas", "Credenciales invalidas");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void registrarse() throws IOException {
        usuario_ln.guardar(user);
        FacesContext.getCurrentInstance().getExternalContext().redirect("inicio_sesion.xhtml");
    }

    public void registroMediciones() {
        medicion.setFecha(obtenerFecha());
        medicion.setUsuario(user);
        medicion_ln.guardar(medicion);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registraron los datos con exito", "Se registraron los datos con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private Date obtenerFecha() {
        long miliseconds = System.currentTimeMillis();
        Date date = new Date(miliseconds);
        return date;
    }
}
