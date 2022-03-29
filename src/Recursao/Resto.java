package Recursao;

public class Resto {
    public static void main(String[] args) {
        int num = 15;// numerador
        int den = 4; // denominador
        System.out.println(resto(num, den));
    }

    static int resto(int num, int den) {
        if (num < den)
            return (num);
        return (resto(num - den, den));
    }

}
