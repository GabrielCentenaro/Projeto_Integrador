package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReservaView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        SessaoDao sessaoDao = new SessaoDao(em);
        SalaDao salaDao = new SalaDao(em);
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
        List<Reserva> todosRegistros = reservaDao.buscarTodos();
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - CLIENTE - SESSAO - SALA - FORMA DE PAGAMENTO - \n";
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < totalRegistros; i++) {
            Cliente cliente = clienteDao.buscarPorId(todosRegistros.get(i).getIdCliente());
            Sessao sessao = sessaoDao.buscarPorId(todosRegistros.get(i).getIdSessao());
            Sala sala = salaDao.buscarPorId(todosRegistros.get(i).getIdSala());
            FormaPagamento formaPagamento = formaPagamentoDao.buscarPorId(todosRegistros.get(i).getIdFormaPagamento());
            resultado += todosRegistros.get(i).getIdReserva() + " - " +
                    cliente.getNome() + " - " +
                    sdfData.format(sessao.getData() )+ " - " +
                    sessao.getHorario() + " - " +
                    sala.getNumero()+ " - " +
                    formaPagamento.getDescricaopag()+ "\n";
        }
        return resultado;
    }
    public static void cadastrar() {
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em);
        ClienteView clienteView = new ClienteView();
        SessaoView sessaoView = new SessaoView();
        SalaView salaView = new SalaView();
        FormaPagamentoView formaPagamentoView = new FormaPagamentoView();
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(
                clienteView.consultar() + "\n Informe o seu id de cliente"));
        int idSessao = Integer.parseInt(JOptionPane.showInputDialog(
                sessaoView.consultar() + "\n Informe o id da Sessão"));
        int idSala = Integer.parseInt(JOptionPane.showInputDialog(
                salaView.consultar() + "\n Informe o id da sala "));
        int idFormaPagamento = Integer.parseInt(JOptionPane.showInputDialog(
                formaPagamentoView.consultar() + "\n Informe a forma de pagamento"));
        Reserva reserva = new Reserva(idCliente, idSessao, idSala, idFormaPagamento);
        em.getTransaction().begin();
        reservaDao.cadastrar(reserva);
        em.getTransaction().commit();
        em.close();
    }
    public static void remover (int id) {
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em);
        Reserva reserva = ReservaDao.buscarPorId(id);
        em.getTransaction().begin();
        ReservaDao.remover(reserva);
        em.getTransaction().commit();
        em.close();
    }
    public static void alterar (int id) {
        ReservaView reservaView = new ReservaView();
        EntityManager em = JPAUtil.getEntityManager();
        ReservaDao reservaDao = new ReservaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        SessaoDao sessaoDao = new SessaoDao(em);
        SalaDao salaDao = new SalaDao(em);
        FormaPagamentoDao formaPagamentoDao = new FormaPagamentoDao(em);
    }
}
