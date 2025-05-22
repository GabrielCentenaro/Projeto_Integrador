package model;

import javax.persistence.*;

@Entity
@Table (name="estilo")
public class Estilo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idestilo;
    private String descricao;
    // construtor padrão
    public Estilo() {
    }
    // construtor sem o id
    public Estilo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdestilo() {
        return idestilo;
    }

    public void setIdestilo(int idestilo) {
        this.idestilo = idestilo;
    }
}
