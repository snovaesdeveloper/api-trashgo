package com.hackaton.hackaton2023.service.criteria;

import com.hackaton.hackaton2023.domain.enumeration.PerfilUsuario;
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
 * Criteria class for the {@link com.hackaton.hackaton2023.domain.Usuario} entity. This class is used
 * in {@link com.hackaton.hackaton2023.web.rest.UsuarioResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /usuarios?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UsuarioCriteria implements Serializable, Criteria {

    /**
     * Class for filtering PerfilUsuario
     */
    public static class PerfilUsuarioFilter extends Filter<PerfilUsuario> {

        public PerfilUsuarioFilter() {}

        public PerfilUsuarioFilter(PerfilUsuarioFilter filter) {
            super(filter);
        }

        @Override
        public PerfilUsuarioFilter copy() {
            return new PerfilUsuarioFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private PerfilUsuarioFilter perfil;

    private StringFilter login;

    private StringFilter senha;

    private LongFilter userId;

    private LongFilter cooperativaId;

    private LongFilter localId;

    public UsuarioCriteria() {}

    public UsuarioCriteria(UsuarioCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nome = other.nome == null ? null : other.nome.copy();
        this.perfil = other.perfil == null ? null : other.perfil.copy();
        this.login = other.login == null ? null : other.login.copy();
        this.senha = other.senha == null ? null : other.senha.copy();
        this.userId = other.userId == null ? null : other.userId.copy();
        this.cooperativaId = other.cooperativaId == null ? null : other.cooperativaId.copy();
        this.localId = other.localId == null ? null : other.localId.copy();
    }

    @Override
    public UsuarioCriteria copy() {
        return new UsuarioCriteria(this);
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

    public PerfilUsuarioFilter getPerfil() {
        return perfil;
    }

    public PerfilUsuarioFilter perfil() {
        if (perfil == null) {
            perfil = new PerfilUsuarioFilter();
        }
        return perfil;
    }

    public void setPerfil(PerfilUsuarioFilter perfil) {
        this.perfil = perfil;
    }

    public StringFilter getLogin() {
        return login;
    }

    public StringFilter login() {
        if (login == null) {
            login = new StringFilter();
        }
        return login;
    }

    public void setLogin(StringFilter login) {
        this.login = login;
    }

    public StringFilter getSenha() {
        return senha;
    }

    public StringFilter senha() {
        if (senha == null) {
            senha = new StringFilter();
        }
        return senha;
    }

    public void setSenha(StringFilter senha) {
        this.senha = senha;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public LongFilter userId() {
        if (userId == null) {
            userId = new LongFilter();
        }
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
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
        final UsuarioCriteria that = (UsuarioCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(perfil, that.perfil) &&
            Objects.equals(login, that.login) &&
            Objects.equals(senha, that.senha) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(cooperativaId, that.cooperativaId) &&
            Objects.equals(localId, that.localId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, perfil, login, senha, userId, cooperativaId, localId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsuarioCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (nome != null ? "nome=" + nome + ", " : "") +
            (perfil != null ? "perfil=" + perfil + ", " : "") +
            (login != null ? "login=" + login + ", " : "") +
            (senha != null ? "senha=" + senha + ", " : "") +
            (userId != null ? "userId=" + userId + ", " : "") +
            (cooperativaId != null ? "cooperativaId=" + cooperativaId + ", " : "") +
            (localId != null ? "localId=" + localId + ", " : "") +
            "}";
    }
}
