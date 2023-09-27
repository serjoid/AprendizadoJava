import java.util.Scanner;

public class AppBanco {
    public static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String cliente1 = "Sergio de Araujo Vilela";
        String cliente2 = "Miguel de Araujo Vilela";
        String tipoContaCliente1 = "Corrente";
        String tipoContaCliente2 = "Poupança";

        int contaCliente1 = 100;
        int contaCliente2 = 101;

        String senhaCliente1 = "abc123";
        String senhaCliente2 = "abc321";

        double saldoConta1 = 0;
        double saldoConta2 = 0;

        Scanner scanner = new Scanner(System.in);

        boolean saidaPrincipal = true;

        while (saidaPrincipal) {
            limparTela();
            System.out.println("****************************************");
            System.out.println("Bem vindo ao Banco Java");
            System.out.println("****************************************");
            System.out.println("Digite sua conta ou digite 0 para sair");
            int conta = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            if (conta == 0) {
                saidaPrincipal = false;
                continue;
            }

            boolean saidaInterna = true;

            if (conta == contaCliente1) {
                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();
                if (senha.equals(senhaCliente1)) {
                    while (saidaInterna) {
                        System.out.println("****************************************");
                        System.out.println("Seja bem vindo " + cliente1);
                        System.out.println("Tipo de conta: " + tipoContaCliente1);
                        System.out.println("Seu saldo é R$ " + saldoConta1);
                        System.out.println("Digite a opção desejada: ");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Transferir");
                        System.out.println("3 - Sair");
                        int opcao = scanner.nextInt();
                        if (opcao == 1) {
                            System.out.println("Qual valor deseja depositar: ");
                            double deposito = scanner.nextDouble();
                            System.out.println("Depósito realizado com sucesso!");
                            saldoConta1 = saldoConta1 + deposito;
                            System.out.println("Seu novo saldo é: R$" + saldoConta1);
                        } else if (opcao == 2) {
                            System.out.println("Para qual conta deseja transferir: ");
                            int contaDestino = scanner.nextInt();

                            if (contaDestino == contaCliente2) {
                                System.out.println("Quanto deseja transferir: ");
                                double valorTransferido = scanner.nextDouble();
                                if (valorTransferido <= saldoConta1) {
                                    saldoConta1 = saldoConta1 - valorTransferido;
                                    saldoConta2 = saldoConta2 + valorTransferido;
                                    System.out.println("Transferência realizada com sucesso, seu novo saldo é R$ " + saldoConta1);
                                } else {
                                    System.out.println("Saldo insuficiente!");
                                }
                            } else {
                                System.out.println("Conta não encontrada!");
                            }
                        } else if (opcao == 3) {
                            saidaInterna = false;
                        } else {
                            System.out.println("Opção Inválida!");
                        }
                    }
                } else {
                    System.out.println("Senha incorreta!");
                }
            } else  if (conta == contaCliente2) {
                System.out.print("Digite sua senha: ");
                String senha = scanner.nextLine();
                if (senha.equals(senhaCliente2)) {
                    while (saidaInterna) {
                        limparTela();
                        System.out.println("****************************************");
                        System.out.println("Seja bem vindo " + cliente2);
                        System.out.println("Tipo de conta: " + tipoContaCliente2);
                        System.out.println("Seu saldo é R$ " + saldoConta2);
                        System.out.println("Digite a opção desejada: ");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Transferir");
                        System.out.println("3 - Sair");
                        int opcao = scanner.nextInt();
                        if (opcao == 1) {
                            System.out.println("Qual valor deseja depositar: ");
                            double deposito = scanner.nextDouble();
                            System.out.println("Depósito realizado com sucesso!");
                            saldoConta2 = saldoConta2 + deposito;
                            System.out.println("Seu novo saldo é: R$" + saldoConta2);
                        } else if (opcao == 2) {
                            System.out.println("Para qual conta deseja transferir: ");
                            int contaDestino = scanner.nextInt();

                            if (contaDestino == contaCliente1) {
                                System.out.println("Quanto deseja transferir: ");
                                double valorTransferido = scanner.nextDouble();
                                if (valorTransferido <= saldoConta2) {
                                    saldoConta2 = saldoConta2 - valorTransferido;
                                    saldoConta1 = saldoConta1 + valorTransferido;
                                    System.out.println("Transferência realizada com sucesso, seu novo saldo é R$ " + saldoConta2);
                                } else {
                                    System.out.println("Saldo insuficiente!");
                                }
                            } else {
                                System.out.print("Conta não encontrada!");
                            }
                        } else if (opcao == 3) {
                            saidaInterna = false;
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                } else {
                    System.out.println("Senha incorreta!");
                }
            } else {
                System.out.println("Conta não encontrada!");
            }
        }
    }
}
