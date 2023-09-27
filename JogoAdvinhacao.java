import java.util.Scanner;
import java.util.Random;

public class JogoAdvinhacao {
    public static void main(String[] args) {
        int tentativas = 5;
        Scanner leitura = new Scanner(System.in);
        int numeroMagico = new Random().nextInt(101);

        while (tentativas > 0){
            System.out.println("Advinhe um número entre 0 e 100");
            int numero = leitura.nextInt();
            if (numero == numeroMagico) {
                System.out.println("Parabéns, você adivinhou o número!");
                break;
            } else {
                System.out.println("Sinto muito, o número não é esse! Você ainda tem " + (tentativas - 1) + " tentativas!");
                if(numero > numeroMagico){
                    System.out.println("O número que você busca é menor!");
                } else{
                    System.out.println("O número que você busca é maior!");
                }
            }
            tentativas -= 1;

        }
        if (tentativas == 0){
            System.out.println("Sinto muito, suas tentativas acabaram e você perdeu! O número era " + numeroMagico);
        }
    }
}
