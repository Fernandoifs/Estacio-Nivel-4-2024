/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author idelm
 */
@Entity
@Table(name = "logradouro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouro.findAll", query = "SELECT l FROM Logradouro l"),
    @NamedQuery(name = "Logradouro.findByIdlogradouro", query = "SELECT l FROM Logradouro l WHERE l.idlogradouro = :idlogradouro"),
    @NamedQuery(name = "Logradouro.findByLogradouro", query = "SELECT l FROM Logradouro l WHERE l.logradouro = :logradouro")})
public class Logradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogradouro")
    private Integer idlogradouro;
    @Size(max = 50)
    @Column(name = "logradouro")
    private String logradouro;
    @OneToMany(mappedBy = "logradouro")
    private Collection<Pessoa> pessoaCollection;
    @JoinColumn(name = "bairro", referencedColumnName = "idbairro")
    @ManyToOne
    private Bairro bairro;
    @OneToMany(mappedBy = "logradouro")
    private Collection<Cep> cepCollection;

    public Logradouro() {
    }

    public Logradouro(Integer idlogradouro) {
        this.idlogradouro = idlogradouro;
    }

    public Integer getIdlogradouro() {
        return idlogradouro;
    }

    public void setIdlogradouro(Integer idlogradouro) {
        this.idlogradouro = idlogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @XmlTransient
    public Collection<Cep> getCepCollection() {
        return cepCollection;
    }

    public void setCepCollection(Collection<Cep> cepCollection) {
        this.cepCollection = cepCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogradouro != null ? idlogradouro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouro)) {
            return false;
        }
        Logradouro other = (Logradouro) object;
        if ((this.idlogradouro == null && other.idlogradouro != null) || (this.idlogradouro != null && !this.idlogradouro.equals(other.idlogradouro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Logradouro[ idlogradouro=" + idlogradouro + " ]";
    }
    
}
