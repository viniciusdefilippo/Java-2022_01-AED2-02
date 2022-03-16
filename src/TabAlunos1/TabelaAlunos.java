package TabAlunos1;

// Indice da tabela é o número de matrícula
public class TabelaAlunos {
    private int maxMatric;
    private String alunos[];

    public TabelaAlunos(int nd) {
        //Util.valida (nd > 0, "Número de dígitos inválido");
        int nPos = (int) (Math.pow(10, nd) + 0.5);
        System.out.println("nPos=" + nPos);
        alunos = new String[nPos];
        maxMatric = nPos - 1;
    }

    public void adicionaAluno(int matr, String nome) {
        // Util.valida (matr >= 0 && matr < maxMatric, "Número de matrícula inválido!");
        alunos[matr] = nome;
    }

    public String obtemAluno(int matr) {
        // Util.valida (matr >= 0 && matr < maxMatric, "Número de matrícula inválido!");
        return alunos[matr];
    }

    public void imprimeTabelaAlunos() {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null)
                System.out.printf("%d: %s\n", i, alunos[i]);
        }
    }
}
