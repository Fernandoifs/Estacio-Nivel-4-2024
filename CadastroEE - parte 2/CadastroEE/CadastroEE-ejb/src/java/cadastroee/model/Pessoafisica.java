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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author idelm
 */
@Entity
@Table(name = "pessoafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoafisica.findAll", query = "SELECT p FROM Pessoafisica p"),
    @NamedQuery(name = "Pessoafisica.findByIdpessoafisica", query = "SELECT p FROM Pessoafisica p WHERE p.idpessoafisica = :idpessoafisica"),
    @NamedQuery(name = "Pessoafisica.findByCpf", query = "SELECT p FROM Pessoafisica p WHERE p.cpf = :cpf")})
public class Pessoafisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoafisica")
    private Integer idpessoafisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpf")
    private String cpf;
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne(optional = false)
    private Pessoa idpessoa;

    public Pessoafisica() {
    }

    public Pessoafisica(Integer idpessoafisica) {
        this.idpessoafisica = idpessoafisica;
    }

    public Pessoafisica(Integer idpessoafisica, String cpf) {
        this.idpessoafisica = idpessoafisica;
        this.cpf = cpf;
    }

    public Integer getIdpessoafisica() {
        return idpessoafisica;
    }

    public void setIdpessoafisica(Integer idpessoafisica) {
        this.idpessoafisica = idpessoafisica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoafisica != null ? idpessoafisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoafisica)) {
            return false;
        }
        Pessoafisica other = (Pessoafisica) object;
        if ((this.idpessoafisica == null && other.idpessoafisica != null) || (this.idpessoafisica != null && !this.idpessoafisica.equals(other.idpessoafisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Pessoafisica[ idpessoafisica=" + idpessoafisica + " ]";
    }
    
}
