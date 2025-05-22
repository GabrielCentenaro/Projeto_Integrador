package dao;

import model.Estilo;
import model.Sala;

import javax.persistence.EntityManager;
import java.util.List;

public class SalaDao {

        private static EntityManager em;
        public SalaDao(EntityManager em) {
            this.em = em;
        }
        public static List<Sala> buscarTodos() {
            String jpql = "Select s From Sala s";
            return em.createQuery(jpql, Sala.class).getResultList();
        }

        public Sala buscarPorId(int id) {
            return em.find(Sala.class, id);
        }

}
