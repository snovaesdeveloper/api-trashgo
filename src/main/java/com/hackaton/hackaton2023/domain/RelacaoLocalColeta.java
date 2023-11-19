package com.hackaton.hackaton2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A RelacaoLocalColeta.
 */
@Entity
@Table(name = "relacao_local_coleta")
public class RelacaoLocalColeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties(value = { "endereco", "usuario", "relacaoLocalColetas" }, allowSetters = true)
    private Local local;

    @ManyToOne
    @JsonIgnoreProperties(value = { "cooperativa", "pontosColetas" }, allowSetters = true)
    private Coleta coleta;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RelacaoLocalColeta id(Long id) {
        this.id = id;
        return this;
    }

    public Local getLocal() {
        return this.local;
    }

    public RelacaoLocalColeta local(Local local) {
        this.setLocal(local);
        return this;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Coleta getColeta() {
        return this.coleta;
    }

    public RelacaoLocalColeta coleta(Coleta coleta) {
        this.setColeta(coleta);
        return this;
    }

    public void setColeta(Coleta coleta) {
        this.coleta = coleta;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RelacaoLocalColeta)) {
            return false;
        }
        return id != null && id.equals(((RelacaoLocalColeta) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RelacaoLocalColeta{" +
            "id=" + getId() +
            "}";
    }
}
