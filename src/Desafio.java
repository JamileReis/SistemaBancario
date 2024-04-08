import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        double saldo = random.nextDouble() * 1000; // Ajuste o limite máximo conforme necessário
        String nome;
        String tipoConta = null;
        int opcao;
        double deposito;
        double transferirValor;
        double novoSaldo;

        System.out.print("Informe o nome do titular da conta:");
        nome = scanner.nextLine();

        System.out.println("Informe o tipo da sua conta:");
        System.out.println("1- Conta corrente");
        System.out.println("2- Conta poupança");
        int escolhaTipoConta = scanner.nextInt();
        if (escolhaTipoConta == 1) {
            tipoConta = "Conta Corrente";
        } else if (escolhaTipoConta == 2) {
            tipoConta = "Conta Poupança";
        }

        while (true) {
            System.out.println("""
                    **Digite sua opção**
                    1- Consultar saldo
                    2- Transferir valor
                    3- Receber valor
                    4- Sair
                    """);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("*********");
                System.out.println("Nome do titular:\n" + nome);
                System.out.println("Tipo de conta:\n" + tipoConta);
                System.out.println("Seu saldo é:\nR$ " + df.format(saldo)); // Formata o saldo com R$ e duas casas decimais
                System.out.println("*********");
            } else if (opcao == 2) {
                System.out.println("Digite o valor que deseja transferir:");
                transferirValor = scanner.nextDouble();
                if (saldo >= transferirValor) {
                    saldo -= transferirValor;
                    System.out.println("Transferência feita com êxito!");
                } else {
                    System.out.println("Valor indisponível para transferência!");
                }
            } else if (opcao == 3) {
                System.out.println("Digite o valor a ser depositado:");
                deposito = scanner.nextDouble();
                saldo += deposito;
                System.out.println("Seu saldo atual é de: R$ " + df.format(saldo));
            } else if (opcao == 4) {
                System.out.println("Obrigado pela preferência!");
                break; // Encerra o loop e finaliza o programa
            } else {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
