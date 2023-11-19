package com.hackaton.hackaton2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.hackaton2023.domain.enumeration.TipoLocal;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Local.
 */
@Entity
@Table(name = "local")
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoLocal tipo;

    @JsonIgnoreProperties(value = { "local" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Endereco endereco;

    @ManyToOne
    @JsonIgnoreProperties(value = { "user", "cooperativas", "locals" }, allowSetters = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "local")
    @JsonIgnoreProperties(value = { "local", "coleta" }, allowSetters = true)
    private Set<RelacaoLocalColeta> relacaoLocalColetas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Local id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Local nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoLocal getTipo() {
        return this.tipo;
    }

    public Local tipo(TipoLocal tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public Local endereco(Endereco endereco) {
        this.setEndereco(endereco);
        return this;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Local usuario(Usuario usuario) {
        this.setUsuario(usuario);
        return this;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<RelacaoLocalColeta> getRelacaoLocalColetas() {
        return this.relacaoLocalColetas;
    }

    public Local relacaoLocalColetas(Set<RelacaoLocalColeta> relacaoLocalColetas) {
        this.setRelacaoLocalColetas(relacaoLocalColetas);
        return this;
    }

    public Local addRelacaoLocalColeta(RelacaoLocalColeta relacaoLocalColeta) {
        this.relacaoLocalColetas.add(relacaoLocalColeta);
        relacaoLocalColeta.setLocal(this);
        return this;
    }

    public Local removeRelacaoLocalColeta(RelacaoLocalColeta relacaoLocalColeta) {
        this.relacaoLocalColetas.remove(relacaoLocalColeta);
        relacaoLocalColeta.setLocal(null);
        return this;
    }

    public void setRelacaoLocalColetas(Set<RelacaoLocalColeta> relacaoLocalColetas) {
        if (this.relacaoLocalColetas != null) {
            this.relacaoLocalColetas.forEach(i -> i.setLocal(null));
        }
        if (relacaoLocalColetas != null) {
            relacaoLocalColetas.forEach(i -> i.setLocal(this));
        }
        this.relacaoLocalColetas = relacaoLocalColetas;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Local)) {
            return false;
        }
        return id != null && id.equals(((Local) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Local{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }
}
