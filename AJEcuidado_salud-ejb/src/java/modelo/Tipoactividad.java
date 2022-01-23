/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Misael
 */
@Entity
@Table(name = "TIPOACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoactividad.findAll", query = "SELECT t FROM Tipoactividad t"),
    @NamedQuery(name = "Tipoactividad.findByIdtipoactividad", query = "SELECT t FROM Tipoactividad t WHERE t.idtipoactividad = :idtipoactividad"),
    @NamedQuery(name = "Tipoactividad.findByDescripcion", query = "SELECT t FROM Tipoactividad t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipoactividad.findByFactorm", query = "SELECT t FROM Tipoactividad t WHERE t.factorm = :factorm"),
    @NamedQuery(name = "Tipoactividad.findByFactorf", query = "SELECT t FROM Tipoactividad t WHERE t.factorf = :factorf")})
public class Tipoactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPOACTIVIDAD")
    private Integer idtipoactividad;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACTORM")
    private Double factorm;
    @Column(name = "FACTORF")
    private Double factorf;
    @OneToMany(mappedBy = "tipoactividad")
    private Collection<Actividadusuario> actividadusuarioCollection;

    public Tipoactividad() {
    }

    public Tipoactividad(Integer idtipoactividad) {
        this.idtipoactividad = idtipoactividad;
    }

    public Integer getIdtipoactividad() {
        return idtipoactividad;
    }

    public void setIdtipoactividad(Integer idtipoactividad) {
        this.idtipoactividad = idtipoactividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getFactorm() {
        return factorm;
    }

    public void setFactorm(Double factorm) {
        this.factorm = factorm;
    }

    public Double getFactorf() {
        return factorf;
    }

    public void setFactorf(Double factorf) {
        this.factorf = factorf;
    }

    @XmlTransient
    public Collection<Actividadusuario> getActividadusuarioCollection() {
        return actividadusuarioCollection;
    }

    public void setActividadusuarioCollection(Collection<Actividadusuario> actividadusuarioCollection) {
        this.actividadusuarioCollection = actividadusuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoactividad != null ? idtipoactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoactividad)) {
            return false;
        }
        Tipoactividad other = (Tipoactividad) object;
        if ((this.idtipoactividad == null && other.idtipoactividad != null) || (this.idtipoactividad != null && !this.idtipoactividad.equals(other.idtipoactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoactividad[ idtipoactividad=" + idtipoactividad + " ]";
    }
    
}
