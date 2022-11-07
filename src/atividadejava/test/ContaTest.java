package atividadejava.test;

//<editor-fold defaultstate="collapsed" desc="Imports">

import atividadejava.dominio.Conta;
import atividadejava.dominio.Titular;
import java.util.Scanner;
//</editor-fold>

public class ContaTest {
    public static void main(String[] args) {
        int num, resp;
        //<editor-fold defaultstate="collapsed" desc="Scanners">
        Scanner respostaString = new Scanner(System.in);
        Scanner respostaInt = new Scanner(System.in);
        Scanner respostaDouble = new Scanner(System.in);
        Scanner respostaLong = new Scanner(System.in);
        //</editor-fold>

        System.out.println("-----------------------------");
        System.out.println("Bem-vindo!\n");
        boolean exit = true;
        do {
             try {
                 System.out.println("Deseja cadastrar uma nova conta?\n1 - SIM \n2 - NÃO");
                 num = respostaInt.nextInt();
                 if(num < 1 || num > 2){
                     throw new Exception("Opção Invalida");
                 }
                 System.out.println("-----------------------------");
             } catch (Exception es){
                 System.out.println(es.getMessage());
                 respostaInt.nextLine();
                 exit = false;
             }
           } while (!exit);

           // throw new RuntimeException();

                //<editor-fold defaultstate="collapsed" desc="Tela Cadastro">
                Titular titular = new Titular();
                Conta conta = new Conta();
                System.out.println("Cadastro do Titular: \n");
                System.out.println("Digite seu nome: ");
                titular.setNome(respostaString.nextLine());
                System.out.println("Digite seu sobrenome: ");
                titular.setSobrenome(respostaString.nextLine());
                System.out.println("Digite seu endereço: ");
                titular.setEndereco(respostaString.nextLine());
                System.out.println("Data de nascimento: ");
                titular.setDataNascimento(respostaString.nextLine());
                System.out.println("Digite seu CPF: ");
                titular.setCpf(respostaString.nextLine());
                System.out.println("Cadastro Finalizado!");
                System.out.println("-----------------------------");
                System.out.println("Digite uma nova senha: \n(obs: Senha numérica de 4 dígitos)");
                conta.setSenha(respostaLong.nextLong());
                do {
                    System.out.println("Confirme sua senha: ");

                } while (respostaLong.nextLong() != conta.getSenha());
                conta.setLimiteSaque(50D);
                conta.setSaldo(100D);
                conta.setNumero(2550);
                conta.setTitular(titular);
                System.out.println("-----------------------------");
                System.out.println("Bem-vindo, " + titular.getNome());
                do {
                    System.out.println("\nEscolha uma opção: ");
                    System.out.println("1 - Realizar um saque \n2 - Realizar um depósito \n3 - Consultar seus dados \n4 - Sair da conta ");
                    System.out.println("-----------------------------");
                    resp = respostaInt.nextInt();
                    switch (resp) {
                        case 1:
                            do {
                                System.out.println("Digite o valor do saque: ");
                                conta.setValor(respostaDouble.nextDouble());
                                conta.sacar();
                            } while(conta.getValor() > conta.getLimiteSaque());
                            break;
                        case 2:
                            System.out.println("Digite o valor do depósito: ");
                            conta.setValor(respostaDouble.nextDouble());
                            conta.depositar();
                            break;
                        case 3:
                            conta.consultar();
                            break;
                        case 4:
                            conta.sair();
                            break;
                    }
                } while (resp <= 0 || resp > 4);
            System.out.println("\nFINALIZAMOS O SEU ATENDIMENTO!\n\n");
        }

    }