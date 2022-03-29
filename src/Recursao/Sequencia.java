package Recursao;

public class Sequencia {
    public static void main(String[] args) {
        int num = 5;
        print_numero(num);
        System.out.println();
        print_numero_inv(num);
    }

    static void print_numero(int num) {
        if (num > 0) {
            print_numero(num - 1);
            System.out.print(num + " ");
        }
    }

    static void print_numero_inv(int num) {
        if (num > 0) {
            System.out.print(num + " ");
            print_numero_inv(num - 1);
        }

    }
}