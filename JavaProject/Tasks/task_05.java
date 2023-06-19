package Tasks;

import java.util.ArrayList;

/*Дан произвольный список целых чисел.
> 1) Нужно удалить из него чётные числа
> 2) Найти минимальное значение
> 3) Найти максимальное значение
> 4) Найти среднее значение*/

public class task_05 {
  public static void run() {
    int asize=20;
    int amin=2;
    int amax=250;
    int div=2;
    ArrayList <Integer> alist=new ArrayList<>();
    alist=lib.GetRndArrayList(asize, amin, amax);
    System.out.println("ИСХОДНЫЙ МАССИВ: " + alist);
    alist=lib.GetArrayListItemsWithoutRemainder(alist, div);
    System.out.println("ИЗМЕНЕННЫЙ МАССИВ: " + alist);
    System.out.println("МАКСИМАЛЬНОЕ ЗНАЧЕНИЕ: " + lib.ArrayListMaxValue(alist));
    System.out.println("МИНИМАЛЬНОЕ ЗНАЧЕНИЕ: " + lib.ArrayListMinValue(alist));
    System.out.println("СРЕДНЕЕ ЗНАЧЕНИЕ: " + lib.ArrayListAvgValue(alist));
  }
}
