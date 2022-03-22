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

    // Realiza pesquisa sequencial no vetor - por matricula
    public boolean pesquisaAlunoPorMatricula(int matr) {
        int atual = 0;
        while (atual < nElem) {
            if (alunos[atual].getMatr() == matr) return true;
            else atual++;
        }
        return false;
    }

    // Realiza pesquisa sequencial no vetor - por nome
    public boolean pesquisaAlunoPorNome(String nome) {
        for (int i = 0; i < nElem; i++)
            if (alunos[i].getNome().equals(nome)) return true;
        return false;
    }

    // Realiza pesquisa binária no vetor - por matricula
    public boolean pesquisaBinariaAlunoPorMatricula(int matr) {

        int inf = 0;
        int sup = nElem - 1;
        int meio = (nElem - 1) / 2;

        while (inf <= sup) {
            meio = (inf + sup) / 2;
            if (alunos[meio].getMatr() == matr)
                return true;
            else if (alunos[meio].getMatr() < matr)
                inf = meio + 1;
            else
                sup = meio - 1;
        }
        return false;
    }

    // Realiza pesquisa binária no vetor - por nome
    public boolean pesquisaBinariaAlunoPorNome(String nome) {

        int inf = 0;
        int sup = nElem - 1;
        int meio = (nElem - 1) / 2;

        while (inf <= sup) {
            meio = (inf + sup) / 2;
            if (alunos[meio].getNome().equals(nome))
                return true;
            else if (alunos[meio].getNome().compareTo(nome) < 0)
                inf = meio + 1;
            else
                sup = meio - 1;
        }
        return false;
    }


    public void imprimeTabelaAlunos() {
        for (Aluno aluno : alunos) {
            if (aluno != null)
                System.out.println(aluno);
        }
    }
}

