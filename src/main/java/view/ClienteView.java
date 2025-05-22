package view;

import dao.ClienteDao;
import model.Cliente;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClienteView {
    public static String consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        List<Cliente> todosRegistros = clienteDao.buscarTodos();
        int totalRegistros = todosRegistros.size();
        String resultado = "ID - Nome - dataNascimento - fone - email\n";
        for (int i = 0; i < totalRegistros; i++) {
            resultado += todosRegistros.get(i).getIdCliente() + " - " +
                    todosRegistros.get(i).getNome() + " - " +
                    todosRegistros.get(i).getDataNacimento() + " - " +
                    todosRegistros.get(i).getFone() + " - " +
                    todosRegistros.get(i).getEmail() + "\n";
        }
        return resultado;
    }

    public static void cadastrar() {
        ClienteView clienteView = new ClienteView();
        String nome = JOptionPane.showInputDialog("Digite seu Nome");
        Date dataNascimento;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataDigitada = JOptionPane.showInputDialog("Digite sua data de nascimento (dd/MM/yyyy");
        try { // tente parsear a data senão executa a exceção
            dataNascimento = sdfData.parse(dataDigitada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String fone = JOptionPane.showInputDialog("Digite o  seu fone");
        String email = JOptionPane.showInputDialog("Digite o seu email");
        Cliente cliente = new Cliente(nome, dataNascimento, fone, email);
        // conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        // iniciar a sessão
        em.getTransaction().begin();
        // cadastrar
        clienteDao.cadastrar(cliente);
        // validar
        em.getTransaction().commit();
        em.close();
    }
    public static void remover(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(id);
        em.getTransaction().begin();
        clienteDao.remover(cliente);
        em.getTransaction().commit();
        em.close();
    }
    public static void alterar(int id) {
        ClienteView clienteView = new ClienteView();
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(id);
        String nome = JOptionPane.showInputDialog("Nome");
        Date dataNascimento;
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        String dataDigitada = JOptionPane.showInputDialog("Digite sua data de nascimento (dd/MM/yyyy");
        try { // tente parsear a data senão executa a exceção
            dataNascimento = sdfData.parse(dataDigitada);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String fone = JOptionPane.showInputDialog("Digite o  seu fone");
        String email = JOptionPane.showInputDialog("Digite o seu email");
        em.getTransaction().begin();
        clienteDao.alterar(cliente);
        cliente.setNome(nome);
        cliente.setDataNacimento(dataNascimento);
        cliente.setFone(fone);
        cliente.setEmail(email);
        em.getTransaction().commit();
        em.close();
    }
}

