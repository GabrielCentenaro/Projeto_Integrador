package view;

import dao.ClienteDao;
import dao.SessaoDao;
import model.Sessao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SessaoView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        SessaoDao sessaoDao = new SessaoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        List<Sessao> todosRegistros = sessaoDao.buscarTodos();
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - DATA - HORÁRIO - FILME" + "\n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado +=todosRegistros.get(i).getIdsessao() + " - " +
                    sdfData.format(todosRegistros.get(i).getData()) + " - " +
                    todosRegistros.get(i).getHorario() + " - "  +
                    todosRegistros.get(i).getIdfilme() + "\n";
        }
        return resultado;
    }
    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityManager();
        SessaoDao sessaoDao = new SessaoDao(em);
        ClienteView clienteView = new ClienteView();
        FilmeView filmeView = new FilmeView();
        Date data;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataDigitada = JOptionPane.showInputDialog("Digite sua data desejada(dd/MM/yyyy");
        try {
            data = sdfData.parse(dataDigitada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String horario = JOptionPane.showInputDialog("Digite o horario desejado");
        int idcliente = Integer.parseInt(JOptionPane.showInputDialog(
                clienteView.consultar() + "\n Informe seu id do cliente"));
        int idFilme = Integer.parseInt(JOptionPane.showInputDialog(
                filmeView.consultar() + "\n Informe o id do filme"));
        Sessao sessao = new Sessao(data, horario, idcliente, idFilme);
        em.getTransaction().begin();
        sessaoDao.cadastrar(sessao);
        em.getTransaction().commit();
        em.close();
    }
    public static void remover (int id) {
        EntityManager em = JPAUtil.getEntityManager();
        SessaoDao sessaoDao = new SessaoDao(em);
        Sessao sessao = SessaoDao.buscarPorId(id);
        em.getTransaction().begin();
        SessaoDao.remover(sessao);
        em.getTransaction().commit();
        em.close();
    }
    public static void alterar (int id) {
        SessaoView sessaoView = new SessaoView();
        EntityManager em = JPAUtil.getEntityManager();
        SessaoDao sessaoDao = new SessaoDao(em);
        Sessao sessao = SessaoDao.buscarPorId(id);
        Date data;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataDigitada = JOptionPane.showInputDialog("Digite sua data desejada(dd/MM/yyyy");
        try {
            data = sdfData.parse(dataDigitada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String horario = JOptionPane.showInputDialog("Digite o horario desejado");
        int idcliente = Integer.parseInt(JOptionPane.showInputDialog(
                ClienteView.consultar() + "\n Informe o id do cliente"));
        int idFilme = Integer.parseInt(JOptionPane.showInputDialog(
                FilmeView.consultar() + "\n Informe o id do filme"));
        em.getTransaction().begin();
        SessaoDao.remover(sessao);
        sessao.setData(data);
        sessao.setHorario(horario);
        sessao.setIdcliente(idcliente);
        sessao.setIdfilme(idFilme);
        em.getTransaction().commit();
        em.close();
    }
}
