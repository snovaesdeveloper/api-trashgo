package com.hackaton.hackaton2023.service.criteria;

import com.hackaton.hackaton2023.domain.enumeration.TipoLocal;
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
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Local} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.LocalResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /locals?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class LocalCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TipoLocal
     */
    public static class TipoLocalFilter extends Filter<TipoLocal> {

        public TipoLocalFilter() {}

        public TipoLocalFilter(TipoLocalFilter filter) {
            super(filter);
        }

        @Override
        public TipoLocalFilter copy() {
            return new TipoLocalFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private TipoLocalFilter tipo;

    private LongFilter enderecoId;

    private LongFilter usuarioId;

    private LongFilter relacaoLocalColetaId;

    public LocalCriteria() {}

    public LocalCriteria(LocalCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nome = other.nome == null ? null : other.nome.copy();
        this.tipo = other.tipo == null ? null : other.tipo.copy();
        this.enderecoId = other.enderecoId == null ? null : other.enderecoId.copy();
        this.usuarioId = other.usuarioId == null ? null : other.usuarioId.copy();
        this.relacaoLocalColetaId = other.relacaoLocalColetaId == null ? null : other.relacaoLocalColetaId.copy();
    }

    @Override
    public LocalCriteria copy() {
        return new LocalCriteria(this);
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

    public TipoLocalFilter getTipo() {
        return tipo;
    }

    public TipoLocalFilter tipo() {
        if (tipo == null) {
            tipo = new TipoLocalFilter();
        }
        return tipo;
    }

    public void setTipo(TipoLocalFilter tipo) {
        this.tipo = tipo;
    }

    public LongFilter getEnderecoId() {
        return enderecoId;
    }

    public LongFilter enderecoId() {
        if (enderecoId == null) {
            enderecoId = new LongFilter();
        }
        return enderecoId;
    }

    public void setEnderecoId(LongFilter enderecoId) {
        this.enderecoId = enderecoId;
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

    public LongFilter getRelacaoLocalColetaId() {
        return relacaoLocalColetaId;
    }

    public LongFilter relacaoLocalColetaId() {
        if (relacaoLocalColetaId == null) {
            relacaoLocalColetaId = new LongFilter();
        }
        return relacaoLocalColetaId;
    }

    public void setRelacaoLocalColetaId(LongFilter relacaoLocalColetaId) {
        this.relacaoLocalColetaId = relacaoLocalColetaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LocalCriteria that = (LocalCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(tipo, that.tipo) &&
            Objects.equals(enderecoId, that.enderecoId) &&
            Objects.equals(usuarioId, that.usuarioId) &&
            Objects.equals(relacaoLocalColetaId, that.relacaoLocalColetaId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tipo, enderecoId, usuarioId, relacaoLocalColetaId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "LocalCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nome != null ? "nome=" + nome + ", " : "") +
            (tipo != null ? "tipo=" + tipo + ", " : "") +
            (enderecoId != null ? "enderecoId=" + enderecoId + ", " : "") +
            (usuarioId != null ? "usuarioId=" + usuarioId + ", " : "") +
            (relacaoLocalColetaId != null ? "relacaoLocalColetaId=" + relacaoLocalColetaId + ", " : "") +
            "}";
    }
}
