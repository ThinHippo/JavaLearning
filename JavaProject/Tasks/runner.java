package Tasks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class runner {
  public static void main(String[] args) throws IOException {
    int[] ex = { 1, 2, 3, 4};//, 5 };
    System.out.println("Для запуска доступны задачи: " + Arrays.toString(ex));
    Scanner numselect = new Scanner(System.in);
    System.out.print("Введите номер задачи: ");
    int tasknum = numselect.nextInt();
    numselect.close();
    RunTask(tasknum);

  }

  private static void RunTask(int n) throws IOException {
    System.out.println("\033[H\033[J");
    switch (n) {
      case 1:
        task_01.run();
        break;
      case 2:
        task_02.run();
        break;
      case 3:
        task_03.run();
        break;
      case 4:
        task_04.run();
        break;
      default:
        break;
    }

  }

}
