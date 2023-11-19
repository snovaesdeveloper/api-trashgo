package com.hackaton.hackaton2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.hackaton2023.domain.enumeration.StatusColeta;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Coleta.
 */
@Entity
@Table(name = "coleta")
public class Coleta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "pontos_coleta")
    private Integer pontosColeta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusColeta status;

    @ManyToOne
    @JsonIgnoreProperties(value = { "usuario", "coletas" }, allowSetters = true)
    private Cooperativa cooperativa;

    @OneToMany(mappedBy = "coleta")
    @JsonIgnoreProperties(value = { "local", "coleta" }, allowSetters = true)
    private Set<RelacaoLocalColeta> pontosColetas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coleta id(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Coleta data(LocalDate data) {
        this.data = data;
        return this;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getPontosColeta() {
        return this.pontosColeta;
    }

    public Coleta pontosColeta(Integer pontosColeta) {
        this.pontosColeta = pontosColeta;
        return this;
    }

    public void setPontosColeta(Integer pontosColeta) {
        this.pontosColeta = pontosColeta;
    }

    public StatusColeta getStatus() {
        return this.status;
    }

    public Coleta status(StatusColeta status) {
        this.status = status;
        return this;
    }

    public void setStatus(StatusColeta status) {
        this.status = status;
    }

    public Cooperativa getCooperativa() {
        return this.cooperativa;
    }

    public Coleta cooperativa(Cooperativa cooperativa) {
        this.setCooperativa(cooperativa);
        return this;
    }

    public void setCooperativa(Cooperativa cooperativa) {
        this.cooperativa = cooperativa;
    }

    public Set<RelacaoLocalColeta> getPontosColetas() {
        return this.pontosColetas;
    }

    public Coleta pontosColetas(Set<RelacaoLocalColeta> relacaoLocalColetas) {
        this.setPontosColetas(relacaoLocalColetas);
        return this;
    }

    public Coleta addPontosColeta(RelacaoLocalColeta relacaoLocalColeta) {
        this.pontosColetas.add(relacaoLocalColeta);
        relacaoLocalColeta.setColeta(this);
        return this;
    }

    public Coleta removePontosColeta(RelacaoLocalColeta relacaoLocalColeta) {
        this.pontosColetas.remove(relacaoLocalColeta);
        relacaoLocalColeta.setColeta(null);
        return this;
    }

    public void setPontosColetas(Set<RelacaoLocalColeta> relacaoLocalColetas) {
        if (this.pontosColetas != null) {
            this.pontosColetas.forEach(i -> i.setColeta(null));
        }
        if (relacaoLocalColetas != null) {
            relacaoLocalColetas.forEach(i -> i.setColeta(this));
        }
        this.pontosColetas = relacaoLocalColetas;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coleta)) {
            return false;
        }
        return id != null && id.equals(((Coleta) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Coleta{" +
            "id=" + getId() +
            ", data='" + getData() + "'" +
            ", pontosColeta=" + getPontosColeta() +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
