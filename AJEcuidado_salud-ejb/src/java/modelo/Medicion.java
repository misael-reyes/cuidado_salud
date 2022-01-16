/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misael
 */
@Entity
@Table(name = "MEDICION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicion.findAll", query = "SELECT m FROM Medicion m"),
    @NamedQuery(name = "Medicion.findByIdmedicion", query = "SELECT m FROM Medicion m WHERE m.idmedicion = :idmedicion"),
    @NamedQuery(name = "Medicion.findByFecha", query = "SELECT m FROM Medicion m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Medicion.findByPeso", query = "SELECT m FROM Medicion m WHERE m.peso = :peso"),
    @NamedQuery(name = "Medicion.findByCintura", query = "SELECT m FROM Medicion m WHERE m.cintura = :cintura"),
    @NamedQuery(name = "Medicion.findByCadera", query = "SELECT m FROM Medicion m WHERE m.cadera = :cadera"),
    @NamedQuery(name = "Medicion.findByActividad", query = "SELECT m FROM Medicion m WHERE m.actividad = :actividad")})
public class Medicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICION")
    private Integer idmedicion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "PESO")
    private Integer peso;
    @Column(name = "CINTURA")
    private Integer cintura;
    @Column(name = "CADERA")
    private Integer cadera;
    @Size(max = 100)
    @Column(name = "ACTIVIDAD")
    private String actividad;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario usuario;

    public Medicion() {
    }

    public Medicion(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Integer getIdmedicion() {
        return idmedicion;
    }

    public void setIdmedicion(Integer idmedicion) {
        this.idmedicion = idmedicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getCintura() {
        return cintura;
    }

    public void setCintura(Integer cintura) {
        this.cintura = cintura;
    }

    public Integer getCadera() {
        return cadera;
    }

    public void setCadera(Integer cadera) {
        this.cadera = cadera;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicion != null ? idmedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicion)) {
            return false;
        }
        Medicion other = (Medicion) object;
        if ((this.idmedicion == null && other.idmedicion != null) || (this.idmedicion != null && !this.idmedicion.equals(other.idmedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Medicion[ idmedicion=" + idmedicion + " ]";
    }
    
}
