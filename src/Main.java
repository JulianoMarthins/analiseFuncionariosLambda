import entities.Funcionarios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String frase = """
                Exercício final do Capitulo 20
                Expressões Lambdas
                
                Aluno: Juliano Martins de Souza
                
                """;
        System.out.println(frase);

        Scanner sc = new Scanner(System.in);

        String path = "d:\\workspace\\arquivo\\funcionarios.txt";

        try(BufferedReader ler = new BufferedReader(new FileReader(path))){

            String linha = ler.readLine();
            List<Funcionarios> func = new ArrayList<>();

            while(linha != null){
                String[] vetor = linha.strip().split(",");
                String nome = vetor[0];
                String email = vetor[1];
                Double salario = Double.parseDouble(vetor[2]);

                func.add(new Funcionarios(nome, email, salario));
                linha = ler.readLine();
            }

            System.out.print("Digite o salário: ");
            double sal = sc.nextDouble();

            Double media = func.stream().map(x -> x.getSalario()).reduce(0.0, (x, y) -> x + y) / func.size();

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = func.stream().filter(x -> x.getSalario() > sal).map(x -> x.getEmail())
                    .sorted(comp).toList();

            Double soma = func.stream().filter(x -> x.getNome().toUpperCase().charAt(0) == 'L').map(x -> x.getSalario())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.printf("\nEmails dos funcionários que recebem acima de %.2f: \n", sal);
            emails.forEach(System.out::println);

            System.out.printf("\nSoma do salario dos funcinários com a letra 'L': R$ %.2f", soma);



        } catch (FileNotFoundException e) {
            System.out.println("ERROR => " + e);;
        } catch (IOException e) {
            System.out.println("ERROR => " + e);
        }

        sc.close();
    }
}