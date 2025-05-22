package dao;


import model.FormaPagamento;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoDao {

    private static EntityManager em;
    public FormaPagamentoDao (EntityManager em) {
        this.em = em;
    }
    public static List<FormaPagamento> buscarTodos() {
        String jpql = "Select f From FormaPagamento f";
        return em.createQuery(jpql, FormaPagamento.class).getResultList();
    }
    public FormaPagamento buscarPorId(int id) {
        return em.find(FormaPagamento.class, id);
    }
}
