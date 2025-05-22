package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nome, fone, email;
    private Date dataNascimento;

    public Cliente() {
    }

    public Cliente(String nome, Date dataNacimento, String fone, String email) {
        this.nome = nome;
        this.dataNascimento = dataNacimento;
        this.fone = fone;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNacimento() {
        return dataNascimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNascimento = dataNacimento;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
