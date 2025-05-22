package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSala;
    private double numero;
    private int capacidade;

    public Sala() {
    }

    public Sala(int idSala, double numero, int capacidade) {
        this.idSala = idSala;
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
