package dao;

import model.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager em;
    public ClienteDao(EntityManager em) {
        this.em = em;
    }
    // metodo para cadastrar
    public void cadastrar(Cliente cliente) {
        // cria o registro no banco
        this.em.persist(cliente);
    }

    // metodo para consultar
    public List<Cliente> buscarTodos() {
        String jpql = "Select c From Cliente c";
        return em.createQuery(jpql,Cliente.class).getResultList();
    }

    // buscar apenas um registro
    public Cliente buscarPorId (int id) {
        return em.find(Cliente.class,id);
    }
    // deletar registro
    public void remover(Cliente cliente) {
        // carregar no JPA
        em.merge(cliente);
        // remove cliente
        em.remove(cliente);
    }
    public void alterar (Cliente cliente) {
        em.merge(cliente);
    }
}
