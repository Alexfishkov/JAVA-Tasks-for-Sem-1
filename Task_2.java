// Вывести все простые числа от 1 до 1000

public class Task_2 {
    static public void main(String[] args) {
        System.out.print("\033[H\033[J");
        System.out.println("Выводим на экран все простые числа в интервале от 1 до 1000:");
        for (int i = 2; i <= 1000; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.printf("%d ", i);
            }
        }
    }
}
