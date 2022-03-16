package TabAlunos2;

public class TabelaAlunos {
    private int nElem;
    private Aluno alunos[];

    public TabelaAlunos(int tam) {
        nElem = 0;
        alunos = new Aluno[tam];
    }

    // Insere aluno na primeira posição vazia do vetor
    public void adicionaAluno(int matr, String nome) {
        // Util.valida(matr > 0, "Matrícula  inválida");
        // Util.valida(nElem < alunos.length, "Ultrapassou tamanho do vetor");
        alunos[nElem] = new Aluno(matr, nome);
        nElem++;
    }

    // Realiza pesquisa sequencial no vetor
    public String obtemAluno(int matr) {
        // Util.valida(matr > 0, "Matrícula  inválida");
        boolean encontrado = false;
        int atual = 0;
        while (!encontrado && atual < nElem) {
            if (alunos[atual].matr == matr)
                encontrado = true;
            else
                atual++;
        }
        if (encontrado)
            return alunos[atual].nome;
        else
            return null;
    }

    public void imprimeTabelaAlunos() {
        for (int i = 0; i < nElem; i++) {
                System.out.printf("%d: %s\n", alunos[i].matr, alunos[i].nome);
        }
    }
}

