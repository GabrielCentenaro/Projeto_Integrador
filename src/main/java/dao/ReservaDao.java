package dao;

import model.Reserva;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservaDao {

    private static EntityManager em;
    public ReservaDao (EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Reserva reserva) {
        this.em.persist(reserva);
    }
    public List<Reserva> buscarTodos() {
        String jpql = "Select r From Reserva r";
        return em.createQuery(jpql, Reserva.class).getResultList();
    }
    public static Reserva buscarPorId(int id) {
        return em.find(Reserva.class,id);
    }
    public static void remover (Reserva reserva) {
        em.merge(reserva);
        em.remove(reserva);
    }
    public void alterar (Reserva reserva) {
        em.merge(reserva);
    }
}
