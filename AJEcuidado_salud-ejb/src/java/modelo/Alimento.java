/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misael
 */
@Entity
@Table(name = "ALIMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findByIdalimento", query = "SELECT a FROM Alimento a WHERE a.idalimento = :idalimento"),
    @NamedQuery(name = "Alimento.findByNombre", query = "SELECT a FROM Alimento a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alimento.findByRacion", query = "SELECT a FROM Alimento a WHERE a.racion = :racion"),
    @NamedQuery(name = "Alimento.findByUnidad", query = "SELECT a FROM Alimento a WHERE a.unidad = :unidad")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALIMENTO")
    private Integer idalimento;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RACION")
    private Double racion;
    @Size(max = 30)
    @Column(name = "UNIDAD")
    private String unidad;
    @JoinColumn(name = "GRUPOALIMENTO", referencedColumnName = "IDGRUPO")
    @ManyToOne
    private Grupoalimentos grupoalimento;

    public Alimento() {
    }

    public Alimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getRacion() {
        return racion;
    }

    public void setRacion(Double racion) {
        this.racion = racion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Grupoalimentos getGrupoalimento() {
        return grupoalimento;
    }

    public void setGrupoalimento(Grupoalimentos grupoalimento) {
        this.grupoalimento = grupoalimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alimento[ idalimento=" + idalimento + " ]";
    }
    
}
