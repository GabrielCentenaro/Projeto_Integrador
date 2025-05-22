package view;

import dao.FormaPagamentoDao;
import model.FormaPagamento;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        List<FormaPagamento> todosRegistros = FormaPagamentoDao.buscarTodos();
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - descricaopag-\n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdFormaPagamento() + " - " +
                    todosRegistros.get(i).getDescricaopag() + "\n";
        }
        return resultado;
    }
}
