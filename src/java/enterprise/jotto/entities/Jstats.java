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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jessica
 */
@Entity
@Table(name = "JSTATS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jstats.findAll", query = "SELECT j FROM Jstats j"),
    @NamedQuery(name = "Jstats.findById", query = "SELECT j FROM Jstats j WHERE j.id = :id"),
    @NamedQuery(name = "Jstats.findByJuserId", query ="SELECT j FROM Jstats j WHERE j.juserid.id = :juserid"),
    @NamedQuery(name = "Jstats.findByGamesplayed", query = "SELECT j FROM Jstats j WHERE j.gamesplayed = :gamesplayed"),
    @NamedQuery(name = "Jstats.findByWins", query = "SELECT j FROM Jstats j WHERE j.wins = :wins"),
    @NamedQuery(name = "Jstats.findByLosses", query = "SELECT j FROM Jstats j WHERE j.losses = :losses"),
    @NamedQuery(name = "Jstats.findByFewestguessesjgameid", query = "SELECT j FROM Jstats j WHERE j.fewestguessesjgameid = :fewestguessesjgameid"),
    @NamedQuery(name = "Jstats.findByFastestwinjgameid", query = "SELECT j FROM Jstats j WHERE j.fastestwinjgameid = :fastestwinjgameid")})
public class Jstats implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAMESPLAYED", nullable = false)
    private int gamesplayed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WINS", nullable = false)
    private int wins;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOSSES", nullable = false)
    private int losses;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEWESTGUESSESJGAMEID", nullable = false)
    private int fewestguessesjgameid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FASTESTWINJGAMEID", nullable = false)
    private int fastestwinjgameid;
    @JoinColumn(name = "JUSERID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Juser juserid;

    public Jstats() {
    }

    public Jstats(Integer id) {
        this.id = id;
    }

    public Jstats(Integer id, int gamesplayed, int wins, int losses, int fewestguessesjgameid, int fastestwinjgameid) {
        this.id = id;
        this.gamesplayed = gamesplayed;
        this.wins = wins;
        this.losses = losses;
        this.fewestguessesjgameid = fewestguessesjgameid;
        this.fastestwinjgameid = fastestwinjgameid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(int gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getFewestguessesjgameid() {
        return fewestguessesjgameid;
    }

    public void setFewestguessesjgameid(int fewestguessesjgameid) {
        this.fewestguessesjgameid = fewestguessesjgameid;
    }

    public int getFastestwinjgameid() {
        return fastestwinjgameid;
    }

    public void setFastestwinjgameid(int fastestwinjgameid) {
        this.fastestwinjgameid = fastestwinjgameid;
    }
    
    public Juser getJuserid() {
        return juserid;
    }

    public void setJuserid(Juser juserid) {
        this.juserid = juserid;
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
        if (!(object instanceof Jstats)) {
            return false;
        }
        Jstats other = (Jstats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.jotto.entities.Jstats[ id=" + id + " ]";
    }
    
}
