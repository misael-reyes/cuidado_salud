/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package controlador;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logica_negocio.ActividadUser_ln;
import logica_negocio.Medicion_ln;
import logica_negocio.TipoAct_ln;
import modelo.Actividadusuario;
import modelo.Medicion;
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author Misael
 *
 * bean administrable para calcular las kilocalorias y las porciones de alimento
 *
 */
@Named(value = "calculadora")
@SessionScoped
public class Calculadora implements Serializable {

    //atributos de sesion bean
    @EJB
    private ActividadUser_ln actuser_ln;
    @EJB
    private TipoAct_ln tipoact_ln;
    @EJB
    private Medicion_ln medicion_ln;

    //atributos de entidades
    private Usuario usuario;
    private Actividadusuario actUsuario;

    //atributos para el registro de actividades
    private int idTA;
    private int idAU;
    private double kilocalorias = 0.0;

    public Calculadora() {
        //recuperamos el usuario que ha iniciado sesión
        usuario = Acceso.user;
        actUsuario = new Actividadusuario();
    }

    //métodos set y get
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividadusuario getActUsuario() {
        return actUsuario;
    }

    public void setActUsuario(Actividadusuario actUsuario) {
        this.actUsuario = actUsuario;
    }

    public int getIdTA() {
        return idTA;
    }

    public void setIdTA(int idTA) {
        this.idTA = idTA;
    }

    public int getIdAU() {
        return idAU;
    }

    public void setIdAU(int idAU) {
        this.idAU = idAU;
    }

    public double getKilocalorias() {
        return kilocalorias;
    }

    public void setKilocalorias(double kilocalorias) {
        this.kilocalorias = kilocalorias;
    }

    //métodos del bean
    public void registrarActividad() {
        Tipoactividad tipo = tipoact_ln.recuperaTipoAct(idTA);
        actUsuario.setTipoactividad(tipo);
        actUsuario.setUsuario(usuario);
        actuser_ln.guardar(actUsuario);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro la actividad con exito", "Se registro la actividad con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * lista de los diferentes tipos de actividades
     *
     * @return
     */
    public List<Tipoactividad> lista_act() {
        return tipoact_ln.lista_act();
    }

    /**
     * lista de las actividades de los usuarios
     *
     * @return
     */
    public List<Actividadusuario> lista_actuser() {
        return actuser_ln.listaa(usuario.getIdusuario());
    }

    public List<Integer> lista_idActividades() {
        List<Actividadusuario> listaact = lista_actuser();
        List<Integer> listaid = new ArrayList<Integer>();
        for (Actividadusuario au : listaact) {
            listaid.add(au.getIdau());
        }
        return listaid;
    }

    /**
     * metodo para calcular las kilocalorias que require el usario
     */
    public void calcularKilocalorias() {
        int edad = calcularEdad(usuario.getFechanac());
        char sexo = usuario.getSexo();
        int estatura = usuario.getEstatura();
        List<Medicion> lista = medicion_ln.listam(usuario.getIdusuario());
        int peso = lista.get(0).getPeso();
        double MB = calcularMB(edad, sexo, estatura, peso);
        Actividadusuario au = actuser_ln.buscarActUser(idAU);
        kilocalorias = calculaRC(MB, au);
    }

    private double calculaRC(double MB, Actividadusuario au) {
        return MB * au.getTipoactividad().getFactorm();
    }

    /**
     * formula para calcular el metabolismo basal (MB)
     *
     * @param edad
     * @param sexo
     * @param estatura
     * @param peso
     * @return
     */
    private double calcularMB(int edad, char sexo, int estatura, int peso) {
        if (sexo == 'F') {
            return 66.473 + ((double) 13.751 * peso) + ((double) 5.0033 * estatura) - ((double) 6.7550 * edad); //mujer
        } else {
            return 651.1 + ((double) 9.463 * peso) + ((double) 1.8 * estatura) - ((double) 4.6756 * edad); //hombre
        }
    }

    private int calcularEdad(Date fechaN) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formato.format(fechaN);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaTexto, formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        return edad.getYears();
    }
}
