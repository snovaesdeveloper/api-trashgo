package com.hackaton.hackaton2023.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackaton.hackaton2023.domain.enumeration.PerfilUsuario;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Usuario.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private PerfilUsuario perfil;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = { "usuario", "coletas" }, allowSetters = true)
    private Set<Cooperativa> cooperativas = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties(value = { "endereco", "usuario", "relacaoLocalColetas" }, allowSetters = true)
    private Set<Local> locals = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario id(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return this.nome;
    }

    public Usuario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PerfilUsuario getPerfil() {
        return this.perfil;
    }

    public Usuario perfil(PerfilUsuario perfil) {
        this.perfil = perfil;
        return this;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getLogin() {
        return this.login;
    }

    public Usuario login(String login) {
        this.login = login;
        return this;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public Usuario senha(String senha) {
        this.senha = senha;
        return this;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public User getUser() {
        return this.user;
    }

    public Usuario user(User user) {
        this.setUser(user);
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Cooperativa> getCooperativas() {
        return this.cooperativas;
    }

    public Usuario cooperativas(Set<Cooperativa> cooperativas) {
        this.setCooperativas(cooperativas);
        return this;
    }

    public Usuario addCooperativa(Cooperativa cooperativa) {
        this.cooperativas.add(cooperativa);
        cooperativa.setUsuario(this);
        return this;
    }

    public Usuario removeCooperativa(Cooperativa cooperativa) {
        this.cooperativas.remove(cooperativa);
        cooperativa.setUsuario(null);
        return this;
    }

    public void setCooperativas(Set<Cooperativa> cooperativas) {
        if (this.cooperativas != null) {
            this.cooperativas.forEach(i -> i.setUsuario(null));
        }
        if (cooperativas != null) {
            cooperativas.forEach(i -> i.setUsuario(this));
        }
        this.cooperativas = cooperativas;
    }

    public Set<Local> getLocals() {
        return this.locals;
    }

    public Usuario locals(Set<Local> locals) {
        this.setLocals(locals);
        return this;
    }

    public Usuario addLocal(Local local) {
        this.locals.add(local);
        local.setUsuario(this);
        return this;
    }

    public Usuario removeLocal(Local local) {
        this.locals.remove(local);
        local.setUsuario(null);
        return this;
    }

    public void setLocals(Set<Local> locals) {
        if (this.locals != null) {
            this.locals.forEach(i -> i.setUsuario(null));
        }
        if (locals != null) {
            locals.forEach(i -> i.setUsuario(this));
        }
        this.locals = locals;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return id != null && id.equals(((Usuario) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", perfil='" + getPerfil() + "'" +
            ", login='" + getLogin() + "'" +
            ", senha='" + getSenha() + "'" +
            "}";
    }
}
