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
@Table(name = "GRUPOALIMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupoalimentos.findAll", query = "SELECT g FROM Grupoalimentos g"),
    @NamedQuery(name = "Grupoalimentos.findByIdgrupo", query = "SELECT g FROM Grupoalimentos g WHERE g.idgrupo = :idgrupo"),
    @NamedQuery(name = "Grupoalimentos.findByNombre", query = "SELECT g FROM Grupoalimentos g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupoalimentos.findByEnergia", query = "SELECT g FROM Grupoalimentos g WHERE g.energia = :energia"),
    @NamedQuery(name = "Grupoalimentos.findByUnienergia", query = "SELECT g FROM Grupoalimentos g WHERE g.unienergia = :unienergia"),
    @NamedQuery(name = "Grupoalimentos.findByHidratos", query = "SELECT g FROM Grupoalimentos g WHERE g.hidratos = :hidratos"),
    @NamedQuery(name = "Grupoalimentos.findByUnihidratos", query = "SELECT g FROM Grupoalimentos g WHERE g.unihidratos = :unihidratos"),
    @NamedQuery(name = "Grupoalimentos.findByGrasas", query = "SELECT g FROM Grupoalimentos g WHERE g.grasas = :grasas"),
    @NamedQuery(name = "Grupoalimentos.findByUnigrasas", query = "SELECT g FROM Grupoalimentos g WHERE g.unigrasas = :unigrasas"),
    @NamedQuery(name = "Grupoalimentos.findByProteinas", query = "SELECT g FROM Grupoalimentos g WHERE g.proteinas = :proteinas"),
    @NamedQuery(name = "Grupoalimentos.findByUniproteinas", query = "SELECT g FROM Grupoalimentos g WHERE g.uniproteinas = :uniproteinas"),
    @NamedQuery(name = "Grupoalimentos.findBySales", query = "SELECT g FROM Grupoalimentos g WHERE g.sales = :sales"),
    @NamedQuery(name = "Grupoalimentos.findByUnisales", query = "SELECT g FROM Grupoalimentos g WHERE g.unisales = :unisales"),
    @NamedQuery(name = "Grupoalimentos.findByAzucares", query = "SELECT g FROM Grupoalimentos g WHERE g.azucares = :azucares"),
    @NamedQuery(name = "Grupoalimentos.findByUniazucares", query = "SELECT g FROM Grupoalimentos g WHERE g.uniazucares = :uniazucares")})
public class Grupoalimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDGRUPO")
    private Integer idgrupo;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ENERGIA")
    private Integer energia;
    @Size(max = 30)
    @Column(name = "UNIENERGIA")
    private String unienergia;
    @Column(name = "HIDRATOS")
    private Integer hidratos;
    @Size(max = 30)
    @Column(name = "UNIHIDRATOS")
    private String unihidratos;
    @Column(name = "GRASAS")
    private Integer grasas;
    @Size(max = 30)
    @Column(name = "UNIGRASAS")
    private String unigrasas;
    @Column(name = "PROTEINAS")
    private Integer proteinas;
    @Size(max = 30)
    @Column(name = "UNIPROTEINAS")
    private String uniproteinas;
    @Column(name = "SALES")
    private Integer sales;
    @Size(max = 30)
    @Column(name = "UNISALES")
    private String unisales;
    @Column(name = "AZUCARES")
    private Integer azucares;
    @Size(max = 30)
    @Column(name = "UNIAZUCARES")
    private String uniazucares;
    @OneToMany(mappedBy = "grupoalimento")
    private Collection<Alimento> alimentoCollection;

    public Grupoalimentos() {
    }

    public Grupoalimentos(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public String getUnienergia() {
        return unienergia;
    }

    public void setUnienergia(String unienergia) {
        this.unienergia = unienergia;
    }

    public Integer getHidratos() {
        return hidratos;
    }

    public void setHidratos(Integer hidratos) {
        this.hidratos = hidratos;
    }

    public String getUnihidratos() {
        return unihidratos;
    }

    public void setUnihidratos(String unihidratos) {
        this.unihidratos = unihidratos;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public String getUnigrasas() {
        return unigrasas;
    }

    public void setUnigrasas(String unigrasas) {
        this.unigrasas = unigrasas;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public String getUniproteinas() {
        return uniproteinas;
    }

    public void setUniproteinas(String uniproteinas) {
        this.uniproteinas = uniproteinas;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getUnisales() {
        return unisales;
    }

    public void setUnisales(String unisales) {
        this.unisales = unisales;
    }

    public Integer getAzucares() {
        return azucares;
    }

    public void setAzucares(Integer azucares) {
        this.azucares = azucares;
    }

    public String getUniazucares() {
        return uniazucares;
    }

    public void setUniazucares(String uniazucares) {
        this.uniazucares = uniazucares;
    }

    @XmlTransient
    public Collection<Alimento> getAlimentoCollection() {
        return alimentoCollection;
    }

    public void setAlimentoCollection(Collection<Alimento> alimentoCollection) {
        this.alimentoCollection = alimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrupo != null ? idgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoalimentos)) {
            return false;
        }
        Grupoalimentos other = (Grupoalimentos) object;
        if ((this.idgrupo == null && other.idgrupo != null) || (this.idgrupo != null && !this.idgrupo.equals(other.idgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Grupoalimentos[ idgrupo=" + idgrupo + " ]";
    }
    
}
