package dao;

import model.Sessao;

import javax.persistence.EntityManager;
import java.util.List;

public class SessaoDao {

    private static EntityManager em;
    public SessaoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Sessao sessao) {
        this.em.persist(sessao);
    }
    public List<Sessao> buscarTodos() {
        String jpql = "Select s From Sessao s";
        return em.createQuery(jpql, Sessao.class).getResultList();
    }
    public static Sessao buscarPorId(int id) {
        return em.find(Sessao.class, id);
    }
    public static void remover (Sessao sessao) {
        em.merge(sessao);
        em.remove(sessao);
    }
    public void aletar (Sessao sessao) {
        em.merge(sessao);
    }
}
