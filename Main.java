import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== CALCULADORA COMPLETA ===");
        System.out.println("Criada por: Marco Nafalski | Turma: 3P");

        while (continuar) {
            System.out.println("\n1. Operações Básicas");
            System.out.println("2. Percentagens");
            System.out.println("3. Conversor de Unidades");
            System.out.println("4. Calculadora de Idade");
            System.out.println("5. Calculadora de Poupanças");
            System.out.println("6. Calculadora de IMC"); // <- Problema 1
            System.out.println("7. Sair");
            System.out.print("Opção: ");
            int op = sc.nextInt();

            switch (op) {
                case 1: operacoesBasicas(sc);
                case 2: calculadoraPercentagens(sc);
                case 3: conversorUnidades(sc);
                case 4: calculadoraIdade(sc);
                case 5: calculadoraPoupancas(sc);
                case 6: calculadoraIMC(sc); // <- Problema 1
                case 7: {
                    System.out.println("Obrigado por usar a calculadora!");
                    continuar = false;
                }
                default: System.out.println("Opção inválida! Tente novamente.");
            }
        }
        sc.close();
    }

    static void operacoesBasicas(Scanner sc) {
        System.out.print("A: "); double a = sc.nextDouble();
        System.out.print("B: "); double b = sc.nextDouble();
        System.out.println("A+B = " + (a + b));
        System.out.println("A-B = " + (a - b));
        System.out.println("A×B = " + (a * b));
        System.out.println(b != 0 ? "A÷B = " + (a / b) : "Erro: Divisão por zero!");
    }

    static void calculadoraPercentagens(Scanner sc) {
        System.out.print("Valor: "); double v = sc.nextDouble();
        System.out.print("Percentagem (%): "); double p = sc.nextDouble();
        double r = (v * p) / 100;
        System.out.println(p + "% de " + v + " = " + r);
        System.out.println("Com acréscimo: " + (v + r) + " | Com desconto: " + (v - r));
    }

    static void conversorUnidades(Scanner sc) {
        System.out.println("1. Metros para Centímetros");
        System.out.println("2. Quilómetros para Metros");
        System.out.println("3. Horas para Minutos");
        System.out.println("4. Celsius para Fahrenheit"); // <- Problema 2
        System.out.println("5. Quilogramas para Gramas"); // <- Problema 2
        System.out.print("Opção: "); 
        int op = sc.nextInt();
        System.out.print("Valor: "); 
        double x = sc.nextDouble();

        switch (op) {
            case 1: System.out.println(x + " m = " + (x * 100) + " cm");
            case 2: System.out.println(x + " km = " + (x * 1000) + " m");
            case 3: System.out.println(x + " h = " + (x * 60) + " min");
            case 4: { // Celsius para Fahrenheit
                double f = (x * 9.0/5.0) + 32.0;
                System.out.println(x + " °C = " + f + " °F");
            }
            case 5: { // Quilogramas para Gramas
                double g = x * 1000.0;
                System.out.println(x + " kg = " + g + " g");
            }
            default: System.out.println("Opção de conversão inválida.");
        }
    }

    static void calculadoraIdade(Scanner sc) {
        System.out.print("Ano de nascimento: "); int ano = sc.nextInt();
        int anoAtual = 2025; // Ano atualizado
        int idade = anoAtual - ano;
        System.out.println("Você tem aproximadamente " + idade + " anos (cerca de " + (idade * 365) + " dias).");
    }

    static void calculadoraPoupancas(Scanner sc) {
        System.out.print("Poupança mensal (€): "); double m = sc.nextDouble();
        System.out.println("Em 1 ano: " + (m * 12) + " €");
        System.out.println("Em 5 anos: " + (m * 12 * 5) + " €");
        System.out.println("Em 10 anos: " + (m * 12 * 10) + " €");
    }

    // --- Problema 1: Calculadora de IMC ---
    static void calculadoraIMC(Scanner sc) {
        System.out.println("\n=== CALCULADORA DE IMC ===");
        System.out.print("Peso (kg): "); 
        double peso = sc.nextDouble();
        System.out.print("Altura (m): "); 
        double altura = sc.nextDouble();

        if (altura <= 0) {
            System.out.println("Altura inválida. Tente novamente.");
            return;
        }

        double imc = peso / (altura * altura);
        System.out.printf("IMC: %.2f%n", imc);

        String classificacao;
        if (imc < 18.5) classificacao = "Abaixo do peso";
        else if (imc < 25.0) classificacao = "Peso normal";
        else if (imc < 30.0) classificacao = "Sobrepeso";
        else classificacao = "Obesidade";

        System.out.println("Classificação: " + classificacao);
    }
}