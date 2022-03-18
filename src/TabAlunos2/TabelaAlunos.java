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

    public void imprimeTabelaAlunos() {
        for (Aluno aluno : alunos) {
            if (aluno != null)
                System.out.println(aluno);
        }
    }
}

