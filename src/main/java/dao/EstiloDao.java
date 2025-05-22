package dao;

import model.Estilo;

import javax.persistence.EntityManager;
import java.util.List;

public class EstiloDao {
    private static EntityManager em;
    // gerenciamento da entidade
    public EstiloDao(EntityManager em) {
        this.em = em;
    }
    // metodo para cadastrar produto
    public void cadastrar(Estilo estilo) {
        this.em.persist(estilo);
    }
    // metodo para consultar o produto
    public List<Estilo> buscarTodos() {
        String jpql = "Select x from Estilo x";
        return em.createQuery(jpql,Estilo.class).getResultList();
    }
    // buscar por id
    public static Estilo buscarPorId (int id) {
        return em.find(Estilo.class, id);
    }
    // deletar registro
    public void remover(Estilo estilo) {
        // carregar no JPA
        em.merge(estilo);
        // remove produto
        em.remove(estilo);
    }
    public void alterar(Estilo estilo) {
        em.merge(estilo);
    }
}
