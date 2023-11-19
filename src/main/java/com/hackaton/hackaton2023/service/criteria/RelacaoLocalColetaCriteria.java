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
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.RelacaoLocalColeta} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.RelacaoLocalColetaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /relacao-local-coletas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RelacaoLocalColetaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter localId;

    private LongFilter coletaId;

    public RelacaoLocalColetaCriteria() {}

    public RelacaoLocalColetaCriteria(RelacaoLocalColetaCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.localId = other.localId == null ? null : other.localId.copy();
        this.coletaId = other.coletaId == null ? null : other.coletaId.copy();
    }

    @Override
    public RelacaoLocalColetaCriteria copy() {
        return new RelacaoLocalColetaCriteria(this);
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

    public LongFilter getLocalId() {
        return localId;
    }

    public LongFilter localId() {
        if (localId == null) {
            localId = new LongFilter();
        }
        return localId;
    }

    public void setLocalId(LongFilter localId) {
        this.localId = localId;
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
        final RelacaoLocalColetaCriteria that = (RelacaoLocalColetaCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(localId, that.localId) && Objects.equals(coletaId, that.coletaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localId, coletaId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RelacaoLocalColetaCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (localId != null ? "localId=" + localId + ", " : "") +
            (coletaId != null ? "coletaId=" + coletaId + ", " : "") +
            "}";
    }
}
