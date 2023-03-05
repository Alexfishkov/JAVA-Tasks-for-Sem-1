// Реализовать простой калькулятор

import java.util.Scanner;

public class Task_3 {
    static public void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.println("Реализуем простой калькулятор с возможностью выполнить сложение, вычитание, деление, умножение");
        Scanner iScanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double yourNumber1 = iScanner.nextDouble();

        System.out.print("Укажите арифметическое действие (+,-,*,/): ");
        String operation = System.console().readLine();

        System.out.print("Введите второе число: ");
        double yourNumber2 = iScanner.nextDouble();

        System.out.println("Результат:");

        switch (operation) {
            case "*":
            System.out.printf("%.2f * %.2f = %.2f", yourNumber1,yourNumber2, yourNumber1*yourNumber2);
            break;
            case "/":
            System.out.printf("%.2f / %.2f = %.2f", yourNumber1,yourNumber2, yourNumber1/yourNumber2);
            break;
            case "+":
            System.out.printf("%.2f + %.2f = %.2f", yourNumber1,yourNumber2, yourNumber1+yourNumber2);
            break;
            case "-":
            System.out.printf("%.2f - %.2f = %.2f", yourNumber1,yourNumber2, yourNumber1-yourNumber2);
            break;
            default:
            System.out.println("Ошибка при вводе исходных данных");
            break;
        }

               
        iScanner.close();
        
    }

}
