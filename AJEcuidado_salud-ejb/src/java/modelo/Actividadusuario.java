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
@Table(name = "ACTIVIDADUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividadusuario.findAll", query = "SELECT a FROM Actividadusuario a"),
    @NamedQuery(name = "Actividadusuario.findByIdau", query = "SELECT a FROM Actividadusuario a WHERE a.idau = :idau"),
    @NamedQuery(name = "Actividadusuario.findByDescripcion", query = "SELECT a FROM Actividadusuario a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividadusuario.findByFecha1", query = "SELECT a FROM Actividadusuario a WHERE a.fecha1 = :fecha1"),
    @NamedQuery(name = "Actividadusuario.findByFecha2", query = "SELECT a FROM Actividadusuario a WHERE a.fecha2 = :fecha2")})
public class Actividadusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAU")
    private Integer idau;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA1")
    @Temporal(TemporalType.DATE)
    private Date fecha1;
    @Column(name = "FECHA2")
    @Temporal(TemporalType.DATE)
    private Date fecha2;
    @JoinColumn(name = "TIPOACTIVIDAD", referencedColumnName = "IDTIPOACTIVIDAD")
    @ManyToOne
    private Tipoactividad tipoactividad;
    @JoinColumn(name = "USUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne
    private Usuario usuario;

    public Actividadusuario() {
    }

    public Actividadusuario(Integer idau) {
        this.idau = idau;
    }

    public Integer getIdau() {
        return idau;
    }

    public void setIdau(Integer idau) {
        this.idau = idau;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Tipoactividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(Tipoactividad tipoactividad) {
        this.tipoactividad = tipoactividad;
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
        hash += (idau != null ? idau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadusuario)) {
            return false;
        }
        Actividadusuario other = (Actividadusuario) object;
        if ((this.idau == null && other.idau != null) || (this.idau != null && !this.idau.equals(other.idau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Actividadusuario[ idau=" + idau + " ]";
    }
    
}
