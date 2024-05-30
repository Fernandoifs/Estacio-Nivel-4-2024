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
@Table(name = "pessoajuridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoajuridica.findAll", query = "SELECT p FROM Pessoajuridica p"),
    @NamedQuery(name = "Pessoajuridica.findByIdpessoajuridica", query = "SELECT p FROM Pessoajuridica p WHERE p.idpessoajuridica = :idpessoajuridica"),
    @NamedQuery(name = "Pessoajuridica.findByCnpj", query = "SELECT p FROM Pessoajuridica p WHERE p.cnpj = :cnpj")})
public class Pessoajuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoajuridica")
    private Integer idpessoajuridica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cnpj")
    private String cnpj;
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne
    private Pessoa idpessoa;

    public Pessoajuridica() {
    }

    public Pessoajuridica(Integer idpessoajuridica) {
        this.idpessoajuridica = idpessoajuridica;
    }

    public Pessoajuridica(Integer idpessoajuridica, String cnpj) {
        this.idpessoajuridica = idpessoajuridica;
        this.cnpj = cnpj;
    }

    public Integer getIdpessoajuridica() {
        return idpessoajuridica;
    }

    public void setIdpessoajuridica(Integer idpessoajuridica) {
        this.idpessoajuridica = idpessoajuridica;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        hash += (idpessoajuridica != null ? idpessoajuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoajuridica)) {
            return false;
        }
        Pessoajuridica other = (Pessoajuridica) object;
        if ((this.idpessoajuridica == null && other.idpessoajuridica != null) || (this.idpessoajuridica != null && !this.idpessoajuridica.equals(other.idpessoajuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Pessoajuridica[ idpessoajuridica=" + idpessoajuridica + " ]";
    }
    
}
