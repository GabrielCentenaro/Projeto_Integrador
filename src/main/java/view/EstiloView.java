package view;

import dao.EstiloDao;
import model.Estilo;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;

public class EstiloView {
     public void cadastrar() {
         //conexao
         EntityManager em = JPAUtil.getEntityManager();
         EstiloDao estiloDao = new EstiloDao(em);
         // digitação dos campos
         String descricao = JOptionPane.showInputDialog("Digite a descrição");
         // instanciar a classe
         Estilo estilo = new Estilo(descricao);

         //iniciar a transacao
         em.getTransaction().begin();
         estiloDao.cadastrar(estilo);
         em.getTransaction().commit();
         em.close();
     }
    public static String consultar() {
        // conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        EstiloDao estiloDao = new EstiloDao(em);
        List<Estilo> todosRegistros = estiloDao.buscarTodos();
        int totalRegistros = todosRegistros.size(); // quantos registros
        String resultado = "ID - Descrição" + "\n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdestilo() + "_" +
                    todosRegistros.get(i).getDescricao() + "\n";
        }
        return resultado;
    }

    public void alterar(int id) {
        // conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        EstiloDao estiloDao = new EstiloDao(em);
        String descricao = JOptionPane.showInputDialog("Digite a Descrição");
        Estilo estilo = estiloDao.buscarPorId(id);
        em.getTransaction().begin();
        estilo.setDescricao(descricao);
        em.getTransaction().commit();
        em.close();
    }

    public  void remover(int id) {
        // conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        EstiloDao estiloDao = new EstiloDao(em);
        Estilo estilo = estiloDao.buscarPorId(id);
        em.getTransaction().begin();
        em.remove(estilo);
        em.getTransaction().commit();
        em.close();

    }
}
