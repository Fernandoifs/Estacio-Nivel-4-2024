package cadastroee.model;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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


@Entity
@Table(name = "bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b"),
    @NamedQuery(name = "Bairro.findByIdbairro", query = "SELECT b FROM Bairro b WHERE b.idbairro = :idbairro"),
    @NamedQuery(name = "Bairro.findByBairro", query = "SELECT b FROM Bairro b WHERE b.bairro = :bairro")})
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbairro")
    private Integer idbairro;
    @Size(max = 50)
    @Column(name = "bairro")
    private String bairro;
    @OneToMany(mappedBy = "bairro")
    private Collection<Pessoa> pessoaCollection;
    @JoinColumn(name = "cidade", referencedColumnName = "idcidade")
    @ManyToOne
    private Cidade cidade;
    @OneToMany(mappedBy = "bairro")
    private Collection<Logradouro> logradouroCollection;

    public Bairro() {
    }

    public Bairro(Integer idbairro) {
        this.idbairro = idbairro;
    }

    public Integer getIdbairro() {
        return idbairro;
    }

    public void setIdbairro(Integer idbairro) {
        this.idbairro = idbairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @XmlTransient
    public Collection<Logradouro> getLogradouroCollection() {
        return logradouroCollection;
    }

    public void setLogradouroCollection(Collection<Logradouro> logradouroCollection) {
        this.logradouroCollection = logradouroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbairro != null ? idbairro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.idbairro == null && other.idbairro != null) || (this.idbairro != null && !this.idbairro.equals(other.idbairro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Bairro[ idbairro=" + idbairro + " ]";
    }
    
}
