package com.hackaton.hackaton2023.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * A Pagamento.
 */
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "taxa")
    private Double taxa;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pagamento id(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getData() {
        return this.data;
    }

    public Pagamento data(LocalDate data) {
        this.data = data;
        return this;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return this.valor;
    }

    public Pagamento valor(Double valor) {
        this.valor = valor;
        return this;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTaxa() {
        return this.taxa;
    }

    public Pagamento taxa(Double taxa) {
        this.taxa = taxa;
        return this;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pagamento)) {
            return false;
        }
        return id != null && id.equals(((Pagamento) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pagamento{" +
            "id=" + getId() +
            ", data='" + getData() + "'" +
            ", valor=" + getValor() +
            ", taxa=" + getTaxa() +
            "}";
    }
}
