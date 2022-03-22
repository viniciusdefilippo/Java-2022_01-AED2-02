package TabAlunos2;

public class TabelaAlunos {

    private int nElem;
    private Aluno alunos[];

    public TabelaAlunos(int nd) {
        this.nElem = 0;
        int nPos = (int) (Math.pow(10, nd) + 0.5);
        alunos = new Aluno[nPos];
    }

    // Insere aluno na primeira posição vazia do vetor
    public void adicionaAluno(int matr, String nome) {
        alunos[nElem] = new Aluno(matr, nome);
        nElem++;
    }

    // Insere aluno de forma ordenada no vetor
    public void adicionaAlunoOrdenado(int matr, String nome) {
        alunos[nElem] = new Aluno(matr, nome);
        for (int i = nElem; i > 0; i--) {
            if (alunos[i - 1].getNome().compareTo(nome) > 0) {
                Aluno aux = alunos[i - 1];
                alunos[i - 1] = alunos[i];
                alunos[i] = aux;
            }
        }
        nElem++;
    }

    // Realiza pesquisa sequencial no vetor
    public String obtemAluno(int matr) {
        int atual = 0;
        while (atual < nElem) {
            if (alunos[atual].getMatr() == matr)
                return alunos[atual].getNome();
            else
                atual++;
        }
        return null;
    }

    // Realiza pesquisa sequencial no vetor
    public boolean pesquisaAlunoPorNome(String nome) {
        boolean encontrado = false;
        for (int i = 0; i < nElem; i++) {
            if (alunos[i].getNome().equals(nome)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public boolean pesquisaBinariaAlunoPorNome(String nome) {

        boolean encontrado = false;
        int inf = 0, sup = nElem - 1, meio = (nElem - 1) / 2;

        while (!encontrado && inf <= sup) {
            meio = (inf + sup) / 2;
            if (alunos[meio].getNome().equals(nome))
                encontrado = true;
            else if (alunos[meio].getNome().compareTo(nome) < 0)
                inf = meio + 1;
            else
                sup = meio - 1;
        }
        return encontrado;
    }

    public void imprimeTabelaAlunos() {
        for (Aluno aluno : alunos) {
            if (aluno != null)
                System.out.println(aluno);
        }
    }
}

