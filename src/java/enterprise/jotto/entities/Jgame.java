/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.jotto.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "JGAME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jgame.findAll", query = "SELECT j FROM Jgame j"),
    @NamedQuery(name = "Jgame.findById", query = "SELECT j FROM Jgame j WHERE j.id = :id"),
    @NamedQuery(name = "Jgame.findByJuserId", query ="SELECT j FROM Jgame j WHERE j.juserid.id = :juserid"),
    @NamedQuery(name = "Jgame.findBySecretword", query = "SELECT j FROM Jgame j WHERE j.secretword = :secretword"),
    @NamedQuery(name = "Jgame.findByGametime", query = "SELECT j FROM Jgame j WHERE j.gametime = :gametime"),
    @NamedQuery(name = "Jgame.findByNumguesses", query = "SELECT j FROM Jgame j WHERE j.numguesses = :numguesses")})
public class Jgame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SECRETWORD", nullable = false)
    private String secretword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAMETIME", nullable = false)
    private long gametime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMGUESSES", nullable = false)
    private int numguesses;
    @JoinColumn(name = "JUSERID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Juser juserid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jgameid")
    private Collection<Jguess> jguessCollection;

    public Jgame() {
    }

    public Jgame(Integer id) {
        this.id = id;
    }

    public Jgame(Integer id, String secretword, long gametime, int numguesses) {
        this.id = id;
        this.secretword = secretword;
        this.gametime = gametime;
        this.numguesses = numguesses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecretword() {
        return secretword;
    }

    public void setSecretword(String secretword) {
        this.secretword = secretword;
    }

    public long getGametime() {
        return gametime;
    }

    public void setGametime(long gametime) {
        this.gametime = gametime;
    }

    public int getNumguesses() {
        return numguesses;
    }

    public void setNumguesses(int numguesses) {
        this.numguesses = numguesses;
    }

    public Juser getJuserid() {
        return juserid;
    }

    public void setJuserid(Juser juserid) {
        this.juserid = juserid;
    }

    @XmlTransient
    public Collection<Jguess> getJguessCollection() {
        return jguessCollection;
    }

    public void setJguessCollection(Collection<Jguess> jguessCollection) {
        this.jguessCollection = jguessCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jgame)) {
            return false;
        }
        Jgame other = (Jgame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.jotto.entities.Jgame[ id=" + id + " ]";
    }
    
}
