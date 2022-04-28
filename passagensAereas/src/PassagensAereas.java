import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PassagensAereas {

    public static void main(String[] args) {

        Usuario usuario = null;
        List<Usuario> usuarioList = new ArrayList<>();

        // acrescentar item no menu principal de visualizar rotas reservadas

        Rota r1 = new Rota(1, "GRU - VCP", 500, 100);
        Rota r2 = new Rota(2, "VCP - GRU", 500, 100);
        Rota r3 = new Rota(3, "SSA - GRU", 800, 100);
        Rota r4 = new Rota(4, "GRU - SSA", 800, 100);
        Rota r5 = new Rota(5, "SSA - VCP", 900, 100);
        Rota r6 = new Rota(6, "VCP - SSA", 900, 100);
        Rota r7 = new Rota(7, "CGH - VCP", 600, 100);
        Rota r8 = new Rota(8, "VCP - CGH", 600, 100);
        Rota r9 = new Rota(9, "CGH - GRU", 600, 100);
        Rota r10 = new Rota(10, "GRU - CGH", 600, 100);
        Rota r11 = new Rota(11, "AJU - VCP", 900, 100);
        Rota r12 = new Rota(12, "SDU - VCP", 500, 100);
        Rota r13 = new Rota(13, "VCP - SDU", 500, 100);
        Rota r14 = new Rota(14, "SDU - GRU", 500, 100);
        Rota r15 = new Rota(15, "GRU - SDU", 500, 100);
        Rota r16 = new Rota(16, "SDU - SSA", 900, 100);
        Rota r17 = new Rota(17, "SSA - SDU", 900, 100);
        Rota r18 = new Rota(18, "AJU - SDU", 900, 100);
        Rota r19 = new Rota(19, "AJU - CGH", 900, 100);

        List<Rota> rotas = new ArrayList<>();
        rotas.add(r1);
        rotas.add(r2);
        rotas.add(r3);
        rotas.add(r4);
        rotas.add(r5);
        rotas.add(r6);
        rotas.add(r7);
        rotas.add(r8);
        rotas.add(r9);
        rotas.add(r10);
        rotas.add(r11);
        rotas.add(r12);
        rotas.add(r13);
        rotas.add(r14);
        rotas.add(r15);
        rotas.add(r16);
        rotas.add(r17);
        rotas.add(r18);
        rotas.add(r19);

        int valor = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(
                    "0- Sair \n1- Login\n2- Criar novo Usuário \n3- Visualizar rota \n4- Reservar Voo \n5- visualizar reservas \n6- Cancelar Voo \n7- log out");
            valor = sc.nextInt();
            if (valor == 1) {

                System.out.println("****************LOGIN***************");
                System.out.println("Cpf do Usuário: ");
                String cpf = sc.next();
                System.out.println("Senha: ");
                String senha = sc.next();
                System.out.println("************************************");

                usuario = null;
                for (Usuario usuariologado : usuarioList) {
                    if (usuariologado.getCpf().equals(cpf)) {
                        usuario = usuariologado;
                        break;
                    }
                }
                if (usuario == null) {
                    System.out.println("Usuário não existe");
                }
                try {
                    if (usuario.getCpf() == null && usuario.getSenha() == null) {
                        System.out.println("Usuário inválido ");
                    } else if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                        usuario.setAutenticado(true);
                        System.out.println("autenticado");
                    } else {
                        usuario.setAutenticado(false);
                        System.out.println("Usuário ou senha Inválida");
                    }

                } catch (NullPointerException e) {
                }
            }

            if (valor == 2) {
                System.out.println("Insira o nome do usuário: ");
                String nome = sc.next();

                System.out.println("\n Insira o CPF");
                String cpf = sc.next();

                System.out.println("\n Defina uma senha");
                String senha = sc.next();

                usuario = new Usuario(nome, cpf, senha, false);
                if (usuarioList.contains(usuario)) {
                    System.out.println("Usuario já existe!");
                } else {
                    usuarioList.add(usuario);
                }
            }

            if (valor == 3) {
                System.out.println("Rotas Disponíveis");
                for (Rota rota : rotas) {
                    System.out.println(rota);

                }
                System.out.println("\n");
            }

            if (valor == 4) {
                if (usuario == null) {
                    System.out.println("Usuário não autenticado, favor fazer login");
                } else {
                    System.out.println("*** ROTAS ***");
                    for (Rota rota : rotas) {
                        System.out.println(rota);
                    }
                    System.out.println("\n");

                    System.out.println("Insira o ID da sua Reserva: ");
                    int reservaEscolhida = sc.nextInt();

                    for (Rota rota : rotas) {
                        if (rota.getId() == reservaEscolhida) {
                            usuario.getReserva().add(rota);
                            System.out.println("\nRota reservada!\n");
                        }
                    }
                }
            }

            if (valor == 5) {
                if (usuario == null) {
                    System.out.println("Usuário não autenticado, favor fazer login");
                } else {
                    System.out.println(usuario.rotaFormat());
                }
            }

            if (valor == 6) {
                if (usuario == null) {
                    System.out.println("Usuário não autenticado, favor fazer login");
                } else {
                    System.out.println(usuario.rotaFormat());
                    System.out.println("\n");
                    System.out.println("insira id de reserva à cancelar");
                    int reservaEscolhida = sc.nextInt();
                    Rota rotaTemp = usuario.buscarRota(reservaEscolhida);
                    if (rotaTemp != null) {
                        usuario.getReserva().remove(rotaTemp);
                        System.out.println("reserva cancelada");
                    } else {
                        System.out.println("id reserva inexistente!");
                    }
                }

            }
            if (valor == 7) {
                usuario = null;
                System.out.println("log out realizado com sucesso!");
            }

        } while (valor != 0);
        sc.close();

    }
}