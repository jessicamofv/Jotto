/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.jotto.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "JWORD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jword.findAll", query = "SELECT j FROM Jword j"),
    @NamedQuery(name = "Jword.findById", query = "SELECT j FROM Jword j WHERE j.id = :id"),
    @NamedQuery(name = "Jword.findByWord", query = "SELECT j FROM Jword j WHERE j.word = :word")})
public class Jword implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "WORD")
    private String word;

    public Jword() {
    }

    public Jword(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
        if (!(object instanceof Jword)) {
            return false;
        }
        Jword other = (Jword) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.jotto.entities.Jword[ id=" + id + " ]";
    }
    
}
