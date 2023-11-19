package com.hackaton.hackaton2023.service.criteria;

import com.hackaton.hackaton2023.domain.enumeration.StatusColeta;
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
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Coleta} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.ColetaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /coletas?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ColetaCriteria implements Serializable, Criteria {

    /**
     * Class for filtering StatusColeta
     */
    public static class StatusColetaFilter extends Filter<StatusColeta> {

        public StatusColetaFilter() {}

        public StatusColetaFilter(StatusColetaFilter filter) {
            super(filter);
        }

        @Override
        public StatusColetaFilter copy() {
            return new StatusColetaFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LocalDateFilter data;

    private IntegerFilter pontosColeta;

    private StatusColetaFilter status;

    private LongFilter cooperativaId;

    private LongFilter pontosColetaId;

    public ColetaCriteria() {}

    public ColetaCriteria(ColetaCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.data = other.data == null ? null : other.data.copy();
        this.pontosColeta = other.pontosColeta == null ? null : other.pontosColeta.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.cooperativaId = other.cooperativaId == null ? null : other.cooperativaId.copy();
        this.pontosColetaId = other.pontosColetaId == null ? null : other.pontosColetaId.copy();
    }

    @Override
    public ColetaCriteria copy() {
        return new ColetaCriteria(this);
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

    public IntegerFilter getPontosColeta() {
        return pontosColeta;
    }

    public IntegerFilter pontosColeta() {
        if (pontosColeta == null) {
            pontosColeta = new IntegerFilter();
        }
        return pontosColeta;
    }

    public void setPontosColeta(IntegerFilter pontosColeta) {
        this.pontosColeta = pontosColeta;
    }

    public StatusColetaFilter getStatus() {
        return status;
    }

    public StatusColetaFilter status() {
        if (status == null) {
            status = new StatusColetaFilter();
        }
        return status;
    }

    public void setStatus(StatusColetaFilter status) {
        this.status = status;
    }

    public LongFilter getCooperativaId() {
        return cooperativaId;
    }

    public LongFilter cooperativaId() {
        if (cooperativaId == null) {
            cooperativaId = new LongFilter();
        }
        return cooperativaId;
    }

    public void setCooperativaId(LongFilter cooperativaId) {
        this.cooperativaId = cooperativaId;
    }

    public LongFilter getPontosColetaId() {
        return pontosColetaId;
    }

    public LongFilter pontosColetaId() {
        if (pontosColetaId == null) {
            pontosColetaId = new LongFilter();
        }
        return pontosColetaId;
    }

    public void setPontosColetaId(LongFilter pontosColetaId) {
        this.pontosColetaId = pontosColetaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ColetaCriteria that = (ColetaCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(data, that.data) &&
            Objects.equals(pontosColeta, that.pontosColeta) &&
            Objects.equals(status, that.status) &&
            Objects.equals(cooperativaId, that.cooperativaId) &&
            Objects.equals(pontosColetaId, that.pontosColetaId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, pontosColeta, status, cooperativaId, pontosColetaId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ColetaCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (data != null ? "data=" + data + ", " : "") +
            (pontosColeta != null ? "pontosColeta=" + pontosColeta + ", " : "") +
            (status != null ? "status=" + status + ", " : "") +
            (cooperativaId != null ? "cooperativaId=" + cooperativaId + ", " : "") +
            (pontosColetaId != null ? "pontosColetaId=" + pontosColetaId + ", " : "") +
            "}";
    }
}
