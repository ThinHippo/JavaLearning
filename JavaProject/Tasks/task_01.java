package Tasks;

import java.util.Random;
import java.util.Arrays;

/*task_01
/*Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i;
/*Посчитать и сохранить в n номер старшего значащего бита выпавшего числа;
/*Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1;
/*Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2; */

public class task_01 {

  public static void run() {
    int upLimit = 2000;
    Random rnd = new Random();
    int i = rnd.nextInt(0, upLimit + 1);
    int n = lib.Msb(i);
    int[] m1 = lib.ArrayFromRangeByRemainder(i, Short.MAX_VALUE, n, false);
    int[] m2 = lib.ArrayFromRangeByRemainder(i, Short.MIN_VALUE, n, true);
    System.out.println("Массив m1 (без остатка): " + Arrays.toString(m1));
    System.out.println("Массив m2 (с остатком): " + Arrays.toString(m2));
    System.out.println("Случайное число i:" + i);
    System.out.println("Бинарное представление числа i:" + Integer.toBinaryString(i));
    System.out.println("Старший значащий бит числа i:" + n);
    System.out.println("Размер массива m1 (без остатка): " + m1.length + "(" + Math.abs(Short.MAX_VALUE - i + 1) + ")");
    System.out.println("Размер массива m2 (с остатком): " + m2.length + "(" + Math.abs(i - Short.MIN_VALUE + 1) + ")");
    
  }

  }