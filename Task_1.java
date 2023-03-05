// Вычислить [n-ое треугольного число](сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Task_1 {
    static public void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.println("Вычисляем значение треугольного числа и факториала введённого вами натурального N");
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите ваше N=> ");
        int yourNumber = iScanner.nextInt();
        if (yourNumber >= 0) {
        System.out.printf("Для числа %d вычислили:\nТреугольное значение: %d\nФакториал: %d\n", yourNumber,
                getTriangleMeaning(yourNumber), getFactorial(yourNumber));
        iScanner.close();
        }
        else{
            System.out.println("Некорректный ввод N");
            iScanner.close();
        }

    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }

    public static int getTriangleMeaning(int f) {
        int result = 0;
        for (int i = 1; i <= f; i++) {
            result += i;
        }
        return result;
    }
}
