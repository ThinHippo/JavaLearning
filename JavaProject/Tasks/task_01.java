package Tasks;

import java.util.Random;
import java.util.Arrays;

/**
 * task_01
 */
public class task_01 {

  public static void main(String[] args) {
    int upLimit = 2000;
    Random rnd = new Random();
    int i = rnd.nextInt(0, upLimit + 1);
    int n = lib.Msb(i);
    int[] m1 = lib.ArrayFromRangeByRemainder(i, Short.MAX_VALUE, n, false);
    int[] m2 = lib.ArrayFromRangeByRemainder(i, Short.MIN_VALUE, n, true);
    System.out.println("\033[H\033[J");
    System.out.println("Массив m1 (без остатка): " + Arrays.toString(m1));
    System.out.println("Массив m2 (с остатком): " + Arrays.toString(m2));
    System.out.println("Случайное число i:" + i);
    System.out.println("Бинарное представление числа i:" + Integer.toBinaryString(i));
    System.out.println("Старший значащий бит числа i:" + n);
    System.out.println("Размер массива m1 (без остатка): " + m1.length + "(" + Math.abs(Short.MAX_VALUE - i + 1) + ")");
    System.out.println("Размер массива m2 (с остатком): " + m2.length + "(" + Math.abs(i - Short.MIN_VALUE + 1) + ")");

  }

}