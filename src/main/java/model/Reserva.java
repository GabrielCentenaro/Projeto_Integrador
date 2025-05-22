package model;

import javax.persistence.*;

@Entity
@Table (name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idReserva;
    private int idCliente;
    private int idSessao;
    private int idSala;
    private int idFormaPagamento;

    public Reserva() {
    }

    public Reserva(int idCliente, int idSessao, int idSala, int idFormaPagamento) {
        this.idCliente = idCliente;
        this.idSessao = idSessao;
        this.idSala = idSala;
        this.idFormaPagamento = idFormaPagamento;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }
}
