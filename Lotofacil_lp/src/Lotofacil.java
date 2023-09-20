import java.util.Random;
import java.util.Scanner;

public class Lotofacil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int opcao;
        do {
            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL:");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int numeroAposta = lerNumeroAposta(scanner);
                    int numeroSorteado = random.nextInt(101);
                    verificarResultadoNumero(numeroAposta, numeroSorteado);
                    break;
                case 2:
                    char letraAposta = lerLetraAposta(scanner);
                    char letraPremiada = 'N';
                    verificarResultadoLetra(letraAposta, letraPremiada);
                    break;
                case 3:
                    int numeroParImpar = lerNumeroAposta(scanner);
                    verificarResultadoParImpar(numeroParImpar);
                    break;
                case 0:
                    System.out.println("Saindo do jogo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int lerNumeroAposta(Scanner scanner) {
        int numeroAposta;
        do {
            System.out.print("Digite um número de 0 a 100: ");
            numeroAposta = scanner.nextInt();
            if (numeroAposta < 0 || numeroAposta > 100) {
                System.out.println("Aposta inválida.");
            }
        } while (numeroAposta < 0 || numeroAposta > 100);
        return numeroAposta;
    }

    private static char lerLetraAposta(Scanner scanner) {
        char letraAposta;
        do {
            System.out.print("Digite uma letra de A à Z: ");
            letraAposta = Character.toUpperCase(scanner.next().charAt(0));
            if (!Character.isLetter(letraAposta) || letraAposta < 'A' || letraAposta > 'Z') {
                System.out.println("Aposta inválida.");
            }
        } while (!Character.isLetter(letraAposta) || letraAposta < 'A' || letraAposta > 'Z');
        return letraAposta;
    }

    private static void verificarResultadoNumero(int numeroAposta, int numeroSorteado) {
        if (numeroAposta == numeroSorteado) {
            System.out.println("Você ganhou R$ 1.000,00 reais.");
        } else {
            System.out.println("Que pena! O número sorteado foi: " + numeroSorteado + ".");
        }
    }

    private static void verificarResultadoLetra(char letraAposta, char letraPremiada) {
        if (letraAposta == letraPremiada) {
            System.out.println("Você ganhou R$ 500,00 reais.");
        } else {
            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada + ".");
        }
    }

    private static void verificarResultadoParImpar(int numeroParImpar) {
        if (numeroParImpar % 2 == 0) {
            System.out.println("Você ganhou R$ 100,00 reais.");
        } else {
            System.out.println("Que pena! Você digitou um número ímpar.");
        }
    }
}