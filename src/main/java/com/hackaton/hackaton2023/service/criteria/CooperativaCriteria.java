package com.hackaton.hackaton2023.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Cooperativa} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.CooperativaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cooperativas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CooperativaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private LongFilter usuarioId;

    private LongFilter coletaId;

    public CooperativaCriteria() {}

    public CooperativaCriteria(CooperativaCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nome = other.nome == null ? null : other.nome.copy();
        this.usuarioId = other.usuarioId == null ? null : other.usuarioId.copy();
        this.coletaId = other.coletaId == null ? null : other.coletaId.copy();
    }

    @Override
    public CooperativaCriteria copy() {
        return new CooperativaCriteria(this);
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

    public StringFilter getNome() {
        return nome;
    }

    public StringFilter nome() {
        if (nome == null) {
            nome = new StringFilter();
        }
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public LongFilter getUsuarioId() {
        return usuarioId;
    }

    public LongFilter usuarioId() {
        if (usuarioId == null) {
            usuarioId = new LongFilter();
        }
        return usuarioId;
    }

    public void setUsuarioId(LongFilter usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LongFilter getColetaId() {
        return coletaId;
    }

    public LongFilter coletaId() {
        if (coletaId == null) {
            coletaId = new LongFilter();
        }
        return coletaId;
    }

    public void setColetaId(LongFilter coletaId) {
        this.coletaId = coletaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CooperativaCriteria that = (CooperativaCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(usuarioId, that.usuarioId) &&
            Objects.equals(coletaId, that.coletaId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, usuarioId, coletaId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CooperativaCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nome != null ? "nome=" + nome + ", " : "") +
            (usuarioId != null ? "usuarioId=" + usuarioId + ", " : "") +
            (coletaId != null ? "coletaId=" + coletaId + ", " : "") +
            "}";
    }
}
