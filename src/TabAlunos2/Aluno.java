package TabAlunos2;

class Aluno {
    private int matr;
    private String nome;

    public Aluno(int matr, String nome) {
        this.matr = matr;
        this.nome = nome;
    }

    public int getMatr() {
        return matr;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return matr + " :" + nome;
    }
}

