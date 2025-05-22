package dao;

import model.Filme;

import javax.persistence.EntityManager;
import java.util.List;

public class FilmeDao {

    private static EntityManager em;
    public FilmeDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Filme filme) {
        this.em.persist(filme);
    }
    public List<Filme> buscarTodos() {
        String jpql = "Select p From Filme p";
        return em.createQuery(jpql, Filme.class).getResultList();
    }
    public Filme buscarPorId (int id) {
        return em.find(Filme.class,id);
    }
    public static void remover (Filme filme) {
        em.merge(filme);
        em.remove(filme);
    }
    public void aletar (Filme filme) {
        em.merge(filme);
    }
}
