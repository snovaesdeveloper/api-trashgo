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
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Endereco} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.EnderecoResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /enderecos?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class EnderecoCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cep;

    private StringFilter uf;

    private StringFilter cidade;

    private StringFilter bairro;

    private StringFilter logradouro;

    private StringFilter numero;

    private StringFilter complemento;

    private DoubleFilter latitude;

    private DoubleFilter longitude;

    private LongFilter localId;

    public EnderecoCriteria() {}

    public EnderecoCriteria(EnderecoCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cep = other.cep == null ? null : other.cep.copy();
        this.uf = other.uf == null ? null : other.uf.copy();
        this.cidade = other.cidade == null ? null : other.cidade.copy();
        this.bairro = other.bairro == null ? null : other.bairro.copy();
        this.logradouro = other.logradouro == null ? null : other.logradouro.copy();
        this.numero = other.numero == null ? null : other.numero.copy();
        this.complemento = other.complemento == null ? null : other.complemento.copy();
        this.latitude = other.latitude == null ? null : other.latitude.copy();
        this.longitude = other.longitude == null ? null : other.longitude.copy();
        this.localId = other.localId == null ? null : other.localId.copy();
    }

    @Override
    public EnderecoCriteria copy() {
        return new EnderecoCriteria(this);
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

    public StringFilter getCep() {
        return cep;
    }

    public StringFilter cep() {
        if (cep == null) {
            cep = new StringFilter();
        }
        return cep;
    }

    public void setCep(StringFilter cep) {
        this.cep = cep;
    }

    public StringFilter getUf() {
        return uf;
    }

    public StringFilter uf() {
        if (uf == null) {
            uf = new StringFilter();
        }
        return uf;
    }

    public void setUf(StringFilter uf) {
        this.uf = uf;
    }

    public StringFilter getCidade() {
        return cidade;
    }

    public StringFilter cidade() {
        if (cidade == null) {
            cidade = new StringFilter();
        }
        return cidade;
    }

    public void setCidade(StringFilter cidade) {
        this.cidade = cidade;
    }

    public StringFilter getBairro() {
        return bairro;
    }

    public StringFilter bairro() {
        if (bairro == null) {
            bairro = new StringFilter();
        }
        return bairro;
    }

    public void setBairro(StringFilter bairro) {
        this.bairro = bairro;
    }

    public StringFilter getLogradouro() {
        return logradouro;
    }

    public StringFilter logradouro() {
        if (logradouro == null) {
            logradouro = new StringFilter();
        }
        return logradouro;
    }

    public void setLogradouro(StringFilter logradouro) {
        this.logradouro = logradouro;
    }

    public StringFilter getNumero() {
        return numero;
    }

    public StringFilter numero() {
        if (numero == null) {
            numero = new StringFilter();
        }
        return numero;
    }

    public void setNumero(StringFilter numero) {
        this.numero = numero;
    }

    public StringFilter getComplemento() {
        return complemento;
    }

    public StringFilter complemento() {
        if (complemento == null) {
            complemento = new StringFilter();
        }
        return complemento;
    }

    public void setComplemento(StringFilter complemento) {
        this.complemento = complemento;
    }

    public DoubleFilter getLatitude() {
        return latitude;
    }

    public DoubleFilter latitude() {
        if (latitude == null) {
            latitude = new DoubleFilter();
        }
        return latitude;
    }

    public void setLatitude(DoubleFilter latitude) {
        this.latitude = latitude;
    }

    public DoubleFilter getLongitude() {
        return longitude;
    }

    public DoubleFilter longitude() {
        if (longitude == null) {
            longitude = new DoubleFilter();
        }
        return longitude;
    }

    public void setLongitude(DoubleFilter longitude) {
        this.longitude = longitude;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EnderecoCriteria that = (EnderecoCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cep, that.cep) &&
            Objects.equals(uf, that.uf) &&
            Objects.equals(cidade, that.cidade) &&
            Objects.equals(bairro, that.bairro) &&
            Objects.equals(logradouro, that.logradouro) &&
            Objects.equals(numero, that.numero) &&
            Objects.equals(complemento, that.complemento) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(localId, that.localId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, uf, cidade, bairro, logradouro, numero, complemento, latitude, longitude, localId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EnderecoCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cep != null ? "cep=" + cep + ", " : "") +
            (uf != null ? "uf=" + uf + ", " : "") +
            (cidade != null ? "cidade=" + cidade + ", " : "") +
            (bairro != null ? "bairro=" + bairro + ", " : "") +
            (logradouro != null ? "logradouro=" + logradouro + ", " : "") +
            (numero != null ? "numero=" + numero + ", " : "") +
            (complemento != null ? "complemento=" + complemento + ", " : "") +
            (latitude != null ? "latitude=" + latitude + ", " : "") +
            (longitude != null ? "longitude=" + longitude + ", " : "") +
            (localId != null ? "localId=" + localId + ", " : "") +
            "}";
    }
}
