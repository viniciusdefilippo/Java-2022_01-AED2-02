package TabAlunos2;

import java.io.*;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class TesteTabelaAlunos {
    public static void main(String[] args) throws IOException {

        //String fileName = "nomes.csv";
        String fileName = "nomes_ordem.csv";
        // https://www.fakenamegenerator.com/order.php
        TabelaAlunos tab = readFakeData(fileName);
        tab.imprimeTabelaAlunos();

        double soma = 0;
        int cont = 0;
        int numRepeticoes = 10;

        for (int i = 0; i < numRepeticoes; i++) {
            long startTime = System.nanoTime();
            cont += tab.pesquisaAlunoPorNome("Kaua Costa Castro");
            long totalTime = System.nanoTime() - startTime;
            soma += totalTime;
            //double elapsedTimeInSecond = (double) totalTime / 1_000_000_000;
        }
        System.out.printf("Pesquisa Sequencial: Média tempo execução = %.0f\n", soma / numRepeticoes);
        System.out.printf("Numero médio de operações = %d\n", cont / numRepeticoes);
        // para executar este teste com sucesso, os nomes precisam estar ordenados
        soma = 0;
        cont = 0;
        for (int i = 0; i < numRepeticoes; i++) {
            long startTime = System.nanoTime();
            cont += tab.pesquisaBinariaAlunoPorNome("Kaua Costa Castro");
            long totalTime = System.nanoTime() - startTime;
            soma += totalTime;
            //double elapsedTimeInSecond = (double) totalTime / 1_000_000_000;
        }
        System.out.printf("Pesquisa Binaria: Média tempo execução = %.0f\n", soma / numRepeticoes);
        System.out.printf("Numero médio de operações = %d\n", cont / numRepeticoes);
    }

    public static TabelaAlunos readFakeData(String fileName) throws IOException {

        TabelaAlunos tab = new TabelaAlunos(4);
        int numTotalRegistros = 9999;
        BufferedReader arq = new BufferedReader(new FileReader(fileName));

        for (int i = 0; i < numTotalRegistros; i++) {
            String data[] = new String[3];
            data = arq.readLine().split(";");
            String nome = removeAccents(data[1]);
            tab.adicionaAluno(Integer.parseInt(data[0]), nome);
            //tab.adicionaAlunoOrdenado(Integer.parseInt(data[0]), data[1]);
        }
        return tab;
    }

    public static String removeAccents(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
