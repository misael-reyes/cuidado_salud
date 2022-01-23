/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
    protected static Usuario user;
    private Medicion medicion;

    //atributos para autenticarse
    private String nameUser;
    private String password;

    //atributo para callcular los indices
    private String fecha;
    private double IMC = 0.0;
    private double ICC = 0.0;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double getICC() {
        return ICC;
    }

    public void setICC(double ICC) {
        this.ICC = ICC;
    }

    //MÉTODOS DEL BEAN ADMINISTRABLE
    public void autenticarse() throws IOException {
        user = usuario_ln.recuperaUsuario(nameUser, password);
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("acceso.xhtml");
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales invalidas", "Credenciales invalidas");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void registrarse() throws IOException {
        usuario_ln.guardar(user);
        FacesContext.getCurrentInstance().getExternalContext().redirect("autenticar.xhtml");
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

    public List<Medicion> lista_m() {
        return medicion_ln.listam(user.getIdusuario());
    }

    public List<java.util.Date> lista_fechas() {
        List<Medicion> list_med = lista_m();
        List<java.util.Date> list_date = new ArrayList<java.util.Date>();
        for (Medicion med : list_med) {
            list_date.add(med.getFecha());
        }
        return list_date;
    }

    public void calcularIndices() {
        List<Medicion> lista = lista_m();
        List<Medicion> listam = new ArrayList<Medicion>();
        for (Medicion m : lista) {
            String fe = m.getFecha().toString();
            if(fe.equals(fecha))
                listam.add(m);
        }
        int peso = listam.get(0).getPeso();
        int altura = user.getEstatura();
        int cintura = listam.get(0).getCintura();
        int cadera = listam.get(0).getCadera();
        IMC = calculaIMC(peso, altura);
        ICC = calculaICC(cadera, cintura);
    }
    
    private double calculaIMC(int peso, int altura) {
        double alturametros = (double)altura/100;
        return peso/(Math.pow(alturametros, 2));
    }
    
    private double calculaICC(int cadera, int cintura) {
        return (double) cintura/cadera;
    }
}
