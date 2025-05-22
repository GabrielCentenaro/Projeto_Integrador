package model;

import javax.persistence.*;

@Entity
@Table(name = "FormaPagamento")
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;
    private String descricaopag;

    public FormaPagamento() {
    }

    public FormaPagamento(int idFormaPagamento, String descricaopag) {
        this.idFormaPagamento = idFormaPagamento;
        this.descricaopag = descricaopag;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getDescricaopag() {
        return descricaopag;
    }

    public void setDescricaopag(String descricaopag) {
        this.descricaopag = descricaopag;
    }
}
