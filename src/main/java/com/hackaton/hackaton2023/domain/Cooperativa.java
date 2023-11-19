package com.hackaton.hackaton2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Cooperativa.
 */
@Entity
@Table(name = "cooperativa")
public class Cooperativa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JsonIgnoreProperties(value = { "user", "cooperativas", "locals" }, allowSetters = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "cooperativa")
    @JsonIgnoreProperties(value = { "cooperativa", "pontosColetas" }, allowSetters = true)
    private Set<Coleta> coletas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cooperativa id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Cooperativa nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public Cooperativa usuario(Usuario usuario) {
        this.setUsuario(usuario);
        return this;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Coleta> getColetas() {
        return this.coletas;
    }

    public Cooperativa coletas(Set<Coleta> coletas) {
        this.setColetas(coletas);
        return this;
    }

    public Cooperativa addColeta(Coleta coleta) {
        this.coletas.add(coleta);
        coleta.setCooperativa(this);
        return this;
    }

    public Cooperativa removeColeta(Coleta coleta) {
        this.coletas.remove(coleta);
        coleta.setCooperativa(null);
        return this;
    }

    public void setColetas(Set<Coleta> coletas) {
        if (this.coletas != null) {
            this.coletas.forEach(i -> i.setCooperativa(null));
        }
        if (coletas != null) {
            coletas.forEach(i -> i.setCooperativa(this));
        }
        this.coletas = coletas;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cooperativa)) {
            return false;
        }
        return id != null && id.equals(((Cooperativa) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cooperativa{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            "}";
    }
}
