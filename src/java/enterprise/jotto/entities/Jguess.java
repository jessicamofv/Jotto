/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.jotto.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "JGUESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jguess.findAll", query = "SELECT j FROM Jguess j"),
    @NamedQuery(name = "Jguess.findById", query = "SELECT j FROM Jguess j WHERE j.id = :id"),
    @NamedQuery(name = "Jguess.findByJgameId", query ="SELECT j FROM Jguess j WHERE j.jgameid.id = :jgameid"),
    @NamedQuery(name = "Jguess.findByGuess", query = "SELECT j FROM Jguess j WHERE j.guess = :guess")})
public class Jguess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "GUESS", nullable = false)
    private String guess;
    @JoinColumn(name = "JGAMEID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Jgame jgameid;

    public Jguess() {
    }

    public Jguess(Integer id) {
        this.id = id;
    }

    public Jguess(Integer id, String guess) {
        this.id = id;
        this.guess = guess;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public Jgame getJgameid() {
        return jgameid;
    }

    public void setJgameid(Jgame jgameid) {
        this.jgameid = jgameid;
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
        if (!(object instanceof Jguess)) {
            return false;
        }
        Jguess other = (Jguess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.jotto.entities.Jguess[ id=" + id + " ]";
    }
    
}
