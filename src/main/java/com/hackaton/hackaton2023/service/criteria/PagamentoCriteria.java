package com.hackaton.hackaton2023.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LocalDateFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Pagamento} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.PagamentoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /pagamentos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PagamentoCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LocalDateFilter data;

    private DoubleFilter valor;

    private DoubleFilter taxa;

    public PagamentoCriteria() {}

    public PagamentoCriteria(PagamentoCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.data = other.data == null ? null : other.data.copy();
        this.valor = other.valor == null ? null : other.valor.copy();
        this.taxa = other.taxa == null ? null : other.taxa.copy();
    }

    @Override
    public PagamentoCriteria copy() {
        return new PagamentoCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LocalDateFilter getData() {
        return data;
    }

    public LocalDateFilter data() {
        if (data == null) {
            data = new LocalDateFilter();
        }
        return data;
    }

    public void setData(LocalDateFilter data) {
        this.data = data;
    }

    public DoubleFilter getValor() {
        return valor;
    }

    public DoubleFilter valor() {
        if (valor == null) {
            valor = new DoubleFilter();
        }
        return valor;
    }

    public void setValor(DoubleFilter valor) {
        this.valor = valor;
    }

    public DoubleFilter getTaxa() {
        return taxa;
    }

    public DoubleFilter taxa() {
        if (taxa == null) {
            taxa = new DoubleFilter();
        }
        return taxa;
    }

    public void setTaxa(DoubleFilter taxa) {
        this.taxa = taxa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PagamentoCriteria that = (PagamentoCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(data, that.data) &&
            Objects.equals(valor, that.valor) &&
            Objects.equals(taxa, that.taxa)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, valor, taxa);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PagamentoCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (data != null ? "data=" + data + ", " : "") +
            (valor != null ? "valor=" + valor + ", " : "") +
            (taxa != null ? "taxa=" + taxa + ", " : "") +
            "}";
    }
}
