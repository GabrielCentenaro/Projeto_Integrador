package view;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String resultado = "";
        String botaoPrincipal[] = {"Cadastrar", "Consultar", "Alterar", "Remover", "Sair"};
        int opcaoPrincipal = 0, opcaoCadastro = 0;
        String botaoTabelas[] = {"Estilo", "Cliente", "Filme", "Sessão", "Reserva", "Voltar"};
        do {
            EstiloView estiloView = new EstiloView();
            ClienteView clienteView = new ClienteView();
            FilmeView filmeView = new FilmeView();
            SessaoView sessaoView = new SessaoView();
            ReservaView reservaView = new ReservaView();
            opcaoPrincipal = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção", "cine_kal-el",
                    0, 3, null, botaoPrincipal, 0);
            switch (opcaoPrincipal) {
                case 0: // cadastrar
                    opcaoCadastro = JOptionPane.showOptionDialog(null,
                            "Escolha uma opção", "CADASTRO",
                            0, 3, null, botaoTabelas, 0);
                    switch (opcaoCadastro) {
                        case 0: // Estilo
                            estiloView.cadastrar();
                            break;
                        case 1: // Cliente
                            clienteView.cadastrar();
                            break;
                        case 2: // Filme
                            filmeView.cadastrar();
                            break;
                        case 3: // sessao
                            sessaoView.cadastrar();
                            break;
                        case 4: // reserva
                            reservaView.cadastrar();
                    }
                    JOptionPane.showMessageDialog(null, "Registro cadastrado com êxito!");
                    break;
                case 1: // consultar
                    opcaoCadastro = JOptionPane.showOptionDialog(null,
                            "Escolha uma opção", "CONSULTAR",
                            0, 3, null, botaoTabelas, 0);
                    switch (opcaoCadastro) {
                        case 0: // Estilo
                            resultado =estiloView.consultar();
                            JOptionPane.showMessageDialog(null,resultado);
                            break;
                        case 1: // cliente
                            resultado =clienteView.consultar();
                            JOptionPane.showMessageDialog(null,resultado);
                            break;
                        case 2: // filme
                            resultado =filmeView.consultar();
                            JOptionPane.showMessageDialog(null,resultado);
                            break;
                        case 3: // sessao
                            resultado= sessaoView.consultar();
                            JOptionPane.showMessageDialog(null,resultado);
                            break;
                        case 4: // reserva
                            resultado = reservaView.consultar();
                            JOptionPane.showMessageDialog(null,resultado);
                            break;
                    }
                    break;
                case 2: // alterar
                    opcaoCadastro = JOptionPane.showOptionDialog(null,
                            "Escolha uma opção", "alterar",
                            0, 3, null, botaoTabelas, 0);
                    switch (opcaoCadastro) {
                        case 0: // Estilo
                            resultado =estiloView.consultar();
                            int id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja alterar"));
                            estiloView.alterar(id);
                            break;
                        case 1: // cliente
                            resultado = clienteView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja alterar"));
                            clienteView.alterar(id);
                            break;
                        case 2:// filme
                            resultado = filmeView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja alterar"));
                            filmeView.alterar(id);
                            break;
                        case 3: // sessao
                            resultado = sessaoView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja alterar"));
                            sessaoView.alterar(id);
                            break;
                    }
                    JOptionPane.showMessageDialog(null, "Registro alterado com êxito!");
                    break;
                case 3: // remover
                    opcaoCadastro = JOptionPane.showOptionDialog(null,
                            "Escolha uma opção", "CONSULTAR",
                            0, 3, null, botaoTabelas, 0);
                    switch (opcaoCadastro) {
                        case 0: // Estilo
                            resultado = estiloView.consultar();
                            int id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja excluir"));
                            estiloView.remover(id);
                            break;
                        case 1: // cliente
                            resultado = clienteView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja excluir"));
                            clienteView.remover(id);
                            break;
                        case 2: // Filme
                            resultado = filmeView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite o id que deseja alterar"));
                            filmeView.remover(id);
                            break;
                        case 3: // sessao
                            resultado = sessaoView.consultar();
                            id = Integer.parseInt(JOptionPane.showInputDialog(
                                    resultado + "\nDigite oque deseja alterar"));
                            sessaoView.remover(id);
                            break;
                    }
                    JOptionPane.showMessageDialog(null,"Registro excluído com êxito!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Obrigado pela preferência ao cine_kal-el. Volte sempre!");
            }
        } while (opcaoPrincipal != 4) ;
    }
}
