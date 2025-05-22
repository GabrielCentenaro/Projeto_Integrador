package view;

import dao.EstiloDao;
import dao.FilmeDao;
import model.Estilo;
import model.Filme;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilmeView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);
        EstiloDao estiloDao = new EstiloDao(em);
        SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm");
        List<Filme> todosRegistros = filmeDao.buscarTodos();
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - NOME - CLASSIFICAÇÃO - DURAÇÃO -\n";
        for (int i = 0; i < totalRegistros; i++) {
            Estilo estilo = estiloDao.buscarPorId(todosRegistros.get(i).getIdestilo());
            resultado += todosRegistros.get(i).getIdfilme() + " - " +
                    todosRegistros.get(i).getNome() + " - " +
                    todosRegistros.get(i).getClassificacao() + " - " +
                    sdfHora.format(todosRegistros.get(i).getDuracao()) + " - " +
                    estilo.getDescricao() + "\n";
        }
        return resultado;
    }
    public static void cadastrar() {
        EstiloView estiloView = new EstiloView();
        String nome = JOptionPane.showInputDialog("Digite o nome do Filme");
        String classificacao = JOptionPane.showInputDialog("Digite a classificação indicativa");
        Date horasessao;
        String horadigitada = JOptionPane.showInputDialog(null, "Digite o Horário da Sessão");
        try {
            horasessao = new SimpleDateFormat("hh:mm").parse(horadigitada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int idEstilo = Integer.parseInt(JOptionPane.showInputDialog(
                estiloView.consultar() + "\n Informe o id do estilo do filme"));
        Filme filme = new Filme(nome, classificacao, horasessao, idEstilo);
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);
        em.getTransaction().begin();
        filmeDao.cadastrar(filme);
        em.getTransaction().commit();
        em.close();
    }
    public static void remover(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);
        Filme filme = filmeDao.buscarPorId(id);
        em.getTransaction().begin();
        FilmeDao.remover(filme);
        em.getTransaction().commit();
        em.close();
    }
    public static void alterar (int id) {
        FilmeView filmeView = new FilmeView();
        EntityManager em = JPAUtil.getEntityManager();
        FilmeDao filmeDao = new FilmeDao(em);
        Filme filme = filmeDao.buscarPorId(id);
        String nome = JOptionPane.showInputDialog("Nome do filme");
        String classificacao = JOptionPane.showInputDialog("Digite a classificação");
        int idEstilo = Integer.parseInt(JOptionPane.showInputDialog(
                EstiloView.consultar() + "\n Informe o id do tipo do Produto"));
        em.getTransaction().begin();
        filmeDao.aletar(filme);
        filme.setNome(nome);
        filme.setIdestilo(idEstilo);
        filme.setClassificacao(classificacao);
        em.getTransaction().commit();
        em.close();
    }
}
