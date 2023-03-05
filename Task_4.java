// *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
//  что его нет.


import java.util.Scanner;
import java.lang.Character;

public class Task_4 {
    static public void main(String[] args) {

        // Очистка консоли и начальный пояснительный текст к задаче

        System.out.print("\033[H\033[J");
        System.out.println(
                "Определяем недостающие цифры в равенстве q + w = e, q, w, e >= 0 или сообщаем, что решения нет");
        System.out.println(
                "q,w и e - 2-значные числа. В q и w - одна цифра задана, вторая неизвестна, e - известны обе цифры ");

        // Вводим исходные числа в виде строковых переменных

        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите первое число q (вместо неизвестной цифры, укажите ?): ");
        String stringNumber1 = iScanner.nextLine();
        System.out.print("Введите второе число w (вместо неизвестной цифры, укажите ?): ");
        String stringNumber2 = iScanner.nextLine();
        System.out.print("Введите итоговое число e: ");
        String stringNumber3 = iScanner.nextLine();
        iScanner.close();

        // Определяем максимальное кол-во знаков в числе (среди введённых чисел)

        int maxLength = stringNumber1.length();
        if (stringNumber2.length() > maxLength)
            maxLength = stringNumber2.length();
        if (stringNumber3.length() > maxLength)
            maxLength = stringNumber3.length();

        // "доукомплектовываем" числа с меньшим кол-вом знаков до длины максимального
        // числа

        String stringNumber1New = "";
        for (int i = 1; i <= (maxLength - stringNumber1.length()); i++) {
            stringNumber1New += "0";
        }
        stringNumber1New += stringNumber1;

        String stringNumber2New = "";
        for (int i = 1; i <= (maxLength - stringNumber2.length()); i++) {
            stringNumber2New += "0";
        }
        stringNumber2New += stringNumber2;

        String stringNumber3New = "";
        for (int i = 1; i <= (maxLength - stringNumber3.length()); i++) {
            stringNumber3New += "0";
        }
        stringNumber3New += stringNumber3;

        // Переводим строки в символьные массивы посимвольно

        char[] arrNumber1 = stringNumber1New.toCharArray();
        char[] arrNumber2 = stringNumber2New.toCharArray();
        char[] arrNumber3 = stringNumber3New.toCharArray();

        // Инициализируем массивы целочисленных значений с кол-вом элементов, равным
        // мкимальному числу знаков

        int[] arrNumber1New = new int[maxLength];
        int[] arrNumber2New = new int[maxLength];
        int[] arrNumber3New = new int[maxLength];

        // Заполняем целочисленные массивы значениями из символьных массивов с
        // преобразованием в численный тип

        for (int i = 0; i < maxLength; i++) {
            arrNumber1New[i] = Character.getNumericValue(arrNumber1[i]);
            arrNumber2New[i] = Character.getNumericValue(arrNumber2[i]);
            arrNumber3New[i] = Character.getNumericValue(arrNumber3[i]);
        }

        // Инициализируем служебные переменные перед началом основного блока алгоритма

        int index = maxLength - 1;
        int transfer = 0;
        boolean flag = true;

        // Основной блок алгоритма

        while (index >= 0) {
            if (arrNumber1New[index] > 0 && arrNumber2New[index] > 0
                    && (((arrNumber1New[index] + arrNumber2New[index]) != arrNumber3New[index]))
                    && (arrNumber1New[index] + arrNumber2New[index] - 10) != arrNumber3New[index]) {
                System.out.println("Задача не имеет решения");
                flag = false;
                break;
            }

            if (arrNumber1New[index] + arrNumber2New[index] >= 10)
                transfer = 1;

            if (arrNumber1New[index] > 0 && arrNumber2New[index] < 0) {
                if ((arrNumber3New[index] - arrNumber1New[index]) > 0) {
                    arrNumber2New[index] = arrNumber3New[index] - arrNumber1New[index] - transfer;
                    transfer = 0;
                } else {
                    arrNumber2New[index] = arrNumber3New[index] - arrNumber1New[index] + 10 - transfer;
                    transfer = 1;
                }
            }
            if (arrNumber1New[index] < 0 && arrNumber2New[index] > 0) {
                if ((arrNumber3New[index] - arrNumber2New[index]) > 0) {
                    arrNumber1New[index] = arrNumber3New[index] - arrNumber2New[index] - transfer;
                    transfer = 0;
                } else {
                    arrNumber1New[index] = arrNumber3New[index] - arrNumber2New[index] + 10 - transfer;
                    transfer = 0;
                }
            }
            if (arrNumber1New[index] < 0 && arrNumber2New[index] == 0) {
                arrNumber1New[index] = arrNumber3New[index] - transfer;
                transfer = 0;
            }

            if (arrNumber1New[index] == 0 && arrNumber2New[index] < 0) {
                arrNumber2New[index] = arrNumber3New[index] - transfer;
                transfer = 0;
            }

            if (arrNumber1New[index] < 0 && arrNumber2New[index] < 0) {
                arrNumber1New[index] = 1;
                arrNumber2New[index] = arrNumber3New[index] - arrNumber1New[index] - transfer;
                transfer = 0;
            }

            index--;

        }

        // Если Решение есть выводим его в консоль:

        if (flag) {
            System.out.println(
                    "Решение есть и равенство выглядит так (первое число в первой строке, второе во второй, результат в третьей):");
            for (int i = 0; i < maxLength; i++) {
                System.out.printf("%d ", arrNumber1New[i]);
            }
            System.out.println();
            for (int i = 0; i < maxLength; i++) {
                System.out.printf("%d ", arrNumber2New[i]);
            }
            System.out.println();
            for (int i = 0; i < maxLength; i++) {
                System.out.printf("%d ", arrNumber3New[i]);
            }
            System.out.println();
        }
    }
}
