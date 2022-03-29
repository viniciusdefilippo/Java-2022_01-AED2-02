package Recursao;

public class Fatorial {

    public static void main(String[] args) {
        int num = 5;
        System.out.println("O fatorial de " + num
                + " é " + fatorial(num));
    }

    // Alterar o tipo de retorno (int, long, float, double)
    // para conseguir obter resultados para valores maiores de X
    static int fatorial(int x) {
        if (x == 0)
            return 1;
        else
            return (x * fatorial(x - 1));
    }
}
