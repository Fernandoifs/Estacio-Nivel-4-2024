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
import java.math.BigDecimal;

/**
 *
 * @author idelm
 */
@Entity
@Table(name = "negociacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Negociacao.findAll", query = "SELECT n FROM Negociacao n"),
    @NamedQuery(name = "Negociacao.findByIdnegociacao", query = "SELECT n FROM Negociacao n WHERE n.idnegociacao = :idnegociacao"),
    @NamedQuery(name = "Negociacao.findByTipo", query = "SELECT n FROM Negociacao n WHERE n.tipo = :tipo"),
    @NamedQuery(name = "Negociacao.findByValorUnitario", query = "SELECT n FROM Negociacao n WHERE n.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Negociacao.findByQuantidade", query = "SELECT n FROM Negociacao n WHERE n.quantidade = :quantidade")})
public class Negociacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnegociacao")
    private Integer idnegociacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorUnitario")
    private BigDecimal valorUnitario;
    @Column(name = "quantidade")
    private Integer quantidade;
    @JoinColumn(name = "pessoa", referencedColumnName = "idpessoa")
    @ManyToOne
    private Pessoa pessoa;
    @JoinColumn(name = "produto", referencedColumnName = "idproduto")
    @ManyToOne
    private Produto produto;
    @JoinColumn(name = "usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuario;

    public Negociacao() {
    }

    public Negociacao(Integer idnegociacao) {
        this.idnegociacao = idnegociacao;
    }

    public Negociacao(Integer idnegociacao, String tipo, BigDecimal valorUnitario) {
        this.idnegociacao = idnegociacao;
        this.tipo = tipo;
        this.valorUnitario = valorUnitario;
    }

    public Integer getIdnegociacao() {
        return idnegociacao;
    }

    public void setIdnegociacao(Integer idnegociacao) {
        this.idnegociacao = idnegociacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        hash += (idnegociacao != null ? idnegociacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Negociacao)) {
            return false;
        }
        Negociacao other = (Negociacao) object;
        if ((this.idnegociacao == null && other.idnegociacao != null) || (this.idnegociacao != null && !this.idnegociacao.equals(other.idnegociacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Negociacao[ idnegociacao=" + idnegociacao + " ]";
    }
    
}
