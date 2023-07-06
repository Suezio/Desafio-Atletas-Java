import java.util.Locale;
import java.util.Scanner;

public class Atletas {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? ");
        int quantidadeAtletas = sc.nextInt();

        String nomeAtletaMaisAlto = "";
        double alturaAtletaMaisAlto = 0.0;
        double somaPesos = 0.0;
        int quantidadeMulheres = 0;
        int quantidadeHomens = 0;
        double somaAlturasMulheres = 0.0;

        for (int i = 1; i <= quantidadeAtletas; i++) {
            System.out.printf("%nDigite os dados do atleta número %d:%n", i);

            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Sexo (F/M): ");
            char sexo = sc.next().charAt(0);
            while (sexo != 'F' && sexo != 'M') {
                System.out.print("\nValor inválido! Favor digitar F ou M: ");
                sexo = sc.next().charAt(0);
            }

            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            while (altura <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
            }

            System.out.print("Peso: ");
            double peso = sc.nextDouble();
            while (peso <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
            }

            if (altura > alturaAtletaMaisAlto) {
                nomeAtletaMaisAlto = nome;
                alturaAtletaMaisAlto = altura;
            }

            somaPesos += peso;

            if (sexo == 'F') {
                quantidadeMulheres++;
                somaAlturasMulheres += altura;
            } else {
                quantidadeHomens++;
            }
        }

        System.out.printf("%nRELATÓRIO:%n");
        System.out.printf("Peso médio dos atletas: %.2f%n", somaPesos / quantidadeAtletas);
        System.out.printf("Atleta mais alto: %s%n", nomeAtletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %% %n", ((double) quantidadeHomens / quantidadeAtletas) * 100);

        if (quantidadeMulheres > 0) {
            System.out.printf("Altura média das mulheres: %.2f%n", somaAlturasMulheres / quantidadeMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas");
        }

        sc.close();
    }
}
