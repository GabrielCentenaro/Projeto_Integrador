package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Filme")
public class Filme {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idfilme;
    private String nome, classificacao;
    private Date duracao;
    private int idestilo;

    public Filme() {
    }

    public Filme(String nome, String classificacao, Date duracao, int idestilo) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.duracao = duracao;
        this.idestilo = idestilo;
    }

    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public int getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(int idestilo) {
        this.idestilo = idestilo;
    }
}
