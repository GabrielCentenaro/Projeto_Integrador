package view;

import dao.SalaDao;
import model.Sala;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class SalaView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        SalaDao salaDao = new SalaDao(em);
        List<Sala> todosRegistros = salaDao.buscarTodos();
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - Numero - capacidade -\n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdSala() + " - " +
                    todosRegistros.get(i).getNumero() + " - " +
                    todosRegistros.get(i).getCapacidade() + "\n";
        }
        return resultado;
    }
}

