package TabAlunos3;

// Vetor de pares ( matrícula ,nome), ordenado por matrícula
public class TabelaAlunos {

    private int nElem;
    private Aluno alunos[];

    public TabelaAlunos(int tam) {
        nElem = 0;
        alunos = new Aluno[tam];
    }

    // Insere aluno no vetor de forma ordenada
    public void adicionaAluno(int matr, String nome) {

        alunos[nElem] = new Aluno(matr, nome);
        nElem++;
        ordena();
    }

    // Ordenação com Bubble Sort
    private void ordena() {
        for (int i = 0; i < nElem; i++) {
            for (int j = 0; j < nElem - 1; j++) {
                if (alunos[j].matr > alunos[j + 1].matr) {
                    Aluno aux = alunos[j];
                    alunos[j] = alunos[j + 1];
                    alunos[j + 1] = aux;
                }
            }
        }
    }

    // Realiza pesquisa binária no vetor
    public String obtemAluno(int matr) {
        // Util.valida(matr > 0, "Matrícula  inválida");
        boolean encontrado = false;
        int inf = 0, sup = nElem - 1, meio = (nElem - 1) / 2;

        while (!encontrado && inf <= sup) {
            meio = (inf + sup) / 2;
            if (alunos[meio].matr == matr)
                encontrado = true;
            else if (alunos[meio].matr < matr)
                inf = meio + 1;
            else
                sup = meio - 1;
        }

        if (encontrado)
            return alunos[meio].nome;
        else
            return null;
    }

    public void imprimeTabelaAlunos() {
        for (int i = 0; i < nElem; i++) {
            System.out.printf("%d: %s\n", alunos[i].matr, alunos[i].nome);
        }
    }
}

