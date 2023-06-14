package Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class runner {
  public static void main(String[] args) {
    int[] ex = { 1, 2};//, 3, 4, 5 };
    System.out.println("Для запуска доступны задачи: " + Arrays.toString(ex));
    Scanner numselect = new Scanner(System.in);
    System.out.print("Введите номер задачи: ");
    int tasknum = numselect.nextInt();
    numselect.close();
    RunTask(tasknum);

  }

  private static void RunTask(int n) {
    System.out.println("\033[H\033[J");
    switch (n) {
      case 1:
        task_01.run();
        break;
      case 2:
        task_02.run();
        break;
      default:
        break;
    }

  }

}
