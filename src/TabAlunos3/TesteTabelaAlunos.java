package TabAlunos3;

public class TesteTabelaAlunos {
    public static void main(String[] args) {

        TabelaAlunos tab = new TabelaAlunos(10);

        tab.adicionaAluno(2, "Beatriz Miranda de Oliveira");
        tab.adicionaAluno(1, "Maria Cláudia Santos");
        tab.adicionaAluno(5, "João Fernando Silva");
        tab.adicionaAluno(9, "Ana Paula Souza");
        tab.adicionaAluno(7, "Pedro Cardoso Queiroz");

        tab.imprimeTabelaAlunos();

        System.out.println(tab.obtemAluno(1));

    }
}