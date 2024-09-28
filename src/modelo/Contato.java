package modelo;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Contato {

    private int id;
    private String nome;
    private String email;
    private String endereco;

    public int getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(@NotNull final String nome) {this.nome = nome;}
    public String getEmail() {
        return email;
    }
    public void setEmail(@NotNull final String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(@NotNull final String endereco) {
        this.endereco = endereco;
    }

    public Contato(final int id, @NotNull final String nome, @NotNull final String email, @NotNull final String endereco) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setEndereco(endereco);
    }

    @Override
    public String toString() {
        return "Contato{id=%d, nome='%s', email='%s', endereco='%s'}".formatted(id, nome, email, endereco);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return id == contato.id && Objects.equals(nome, contato.nome) && Objects.equals(email, contato.email) && Objects.equals(endereco, contato.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, endereco);
    }
}
