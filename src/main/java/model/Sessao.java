package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name = "Sessao")
public class Sessao {
    @Id
    @GeneratedValue
    private int idsessao;
    private Date data;
    private String horario;
    private int idcliente;
    private int idfilme;

    public Sessao() {
    }

    public Sessao(Date data, String horario, int idcliente, int idfilme) {
        this.data = data;
        this.horario = horario;
        this.idcliente = idcliente;
        this.idfilme = idfilme;
    }

    public int getIdsessao() {
        return idsessao;
    }

    public void setIdsessao(int idsessao) {
        this.idsessao = idsessao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public int getIdfilme() {
        return idfilme;
    }

    public void setIdfilme(int idfilme) {
        this.idfilme = idfilme;
    }
}
