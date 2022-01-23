/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import logica_negocio.GrupoAlimento_ln;
import modelo.Grupoalimentos;
import modelo.Usuario;

/**
 *
 * @author Misael
 */

@Named(value = "estimacion")
@SessionScoped
public class Estimacion implements Serializable {
    
    //atributos de sesion bean
    @EJB
    private GrupoAlimento_ln ga_ln;
    
    //atributos de los entity class
    private Usuario usuario;
    
    //atributos para las kilicalorias
    private int kcal = 0;
    private double kcal_necesarias = 0.0;
    private int kdesayuno = 0;
    private int kcolMatutina = 0;
    private int kcomida = 0;
    private int kcolTarde = 0;
    private int kcena = 0;
    
    //arreglos para las raciones
    private Integer[] desayuno;
    private Integer[] colMatutina;
    private Integer[] comida;
    private Integer[] colTarde;
    private Integer[] cena;
    private Integer[] idGrupos;
    
    public Estimacion() {
        usuario = Acceso.user;
    }
    
    //métodos set y get
    public Usuario getUsuario() {    
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {    
        this.kcal = kcal;
    }

    public double getKcal_necesarias() {
        return kcal_necesarias;
    }

    public void setKcal_necesarias(double kcal_necesarias) {
        this.kcal_necesarias = kcal_necesarias;
    }

    public Integer[] getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(Integer[] desayuno) {
        this.desayuno = desayuno;
    }

    public Integer[] getColMatutina() {
        return colMatutina;
    }

    public void setColMatutina(Integer[] colMatutina) {
        this.colMatutina = colMatutina;
    }

    public Integer[] getComida() {
        return comida;
    }

    public void setComida(Integer[] comida) {
        this.comida = comida;
    }

    public Integer[] getColTarde() {
        return colTarde;
    }

    public void setColTarde(Integer[] colTarde) {
        this.colTarde = colTarde;
    }

    public Integer[] getCena() {
        return cena;
    }

    public void setCena(Integer[] cena) {
        this.cena = cena;
    }

    public int getKdesayuno() {
        return kdesayuno;
    }

    public void setKdesayuno(int kdesayuno) {
        this.kdesayuno = kdesayuno;
    }

    public int getKcolMatutina() {
        return kcolMatutina;
    }

    public void setKcolMatutina(int kcolMatutina) {
        this.kcolMatutina = kcolMatutina;
    }

    public int getKcomida() {
        return kcomida;
    }

    public void setKcomida(int kcomida) {
        this.kcomida = kcomida;
    }

    public int getKcolTarde() {
        return kcolTarde;
    }

    public void setKcolTarde(int kcolTarde) {
        this.kcolTarde = kcolTarde;
    }

    public int getKcena() {
        return kcena;
    }

    public void setKcena(int kcena) {
        this.kcena = kcena;
    }
    
    //métodos del bean
    public List<Grupoalimentos> lista_grupos() {
        desayuno = new Integer[ga_ln.countGrupos()];
        colMatutina = new Integer[ga_ln.countGrupos()];
        comida = new Integer[ga_ln.countGrupos()];
        colTarde = new Integer[ga_ln.countGrupos()];
        cena = new Integer[ga_ln.countGrupos()];
        idGrupos = new Integer[ga_ln.countGrupos()];
        rrellena(desayuno);
        rrellena(colMatutina);
        rrellena(comida);
        rrellena(colTarde);
        rrellena(cena);
        rellenaIdGrupos();
        return ga_ln.lista_grupos();
    }
    
    private List<Grupoalimentos> lista_grupos2() {
        return ga_ln.lista_grupos();
    }
    
    /**
     * método para calcular las kilocalorias segun las raciones ingresadas
     * por el usuario
     * 
     * se deben comparar con las kilocalorias que el usuario dijo que 
     * necesita
     */
    public void calcularKcal() {
        kdesayuno = calcularKcalTiempo(desayuno);
        kcolMatutina = calcularKcalTiempo(colMatutina);
        kcomida = calcularKcalTiempo(comida);
        kcolTarde = calcularKcalTiempo(colTarde);
        kcena = calcularKcalTiempo(cena);
        kcal = kdesayuno + kcolMatutina + kcomida + kcolTarde + kcena;
        if(kcal > kcal_necesarias) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Las raciones supero las kilocalorias necesarias que necesita, intente otro menu", "a");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Numero de porcioes aceptadas", "b");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    private int calcularKcalTiempo(Integer[] tiempo) {
        int conta = 0;
        for(int i = 0; i < idGrupos.length; i ++) {
            switch(idGrupos[i]) {
                case 1: 
                    conta += tiempo[i] * 70;
                    break;
                case 2:
                    conta += tiempo[i] * 115;
                    break;
                case 3:
                    conta += tiempo[i] * 40;
                    break;
                case 4:
                    conta += tiempo[i] * 25;
                    break;
                case 5:
                    conta += tiempo[i] * 60;
                    break;
                case 6:
                    conta += tiempo[i] * 55;
                    break;
                case 7:
                    conta += tiempo[i] * 95;
                    break;
                default:
                    conta = 10;
                    break;
            }
        }
        return conta;
    }
    
    private void rrellena(Integer[] tiempo) {
        for(int i=0; i<tiempo.length; i++) {
            tiempo[i] = 0;
        }
    }
    
    private void rellenaIdGrupos() {
        int aux = 1;
        List<Grupoalimentos> lista = lista_grupos2();
        for(int i =0; i<idGrupos.length; i++) {
            idGrupos[i] = lista.get(i).getIdgrupo();
            //idGrupos[i] = aux;
            aux ++;
        }
    }
}
