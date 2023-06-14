package Tasks;

import java.util.Arrays;

public class lib {
  public static int Msb(int a) {
    a=Math.abs(a);
    int n = Integer.toBinaryString(a).length() - 1;
    return n;
  }

  public static int[] ArrayFromRangeByRemainder(int a, int b, int d, boolean rem) {
    int first = a;
    int last = b;
    if (a > b) {
      first = b;
      last = a;
    }
    int[] resArray = new int[Math.abs(last - first + 1)];

    if (rem == false) {// нет остатка
      resArray = ArrayWithoutRemainder(first, last, d);
    } else {// есть остаток
      resArray = ArrayWithRemainder(first, last, d);
    }

    return resArray;
  }

  private static int[] ArrayWithoutRemainder(int f, int l, int d) {
    int[] tmp = new int[Math.abs(l - f + 1)];
    int counter = 0;
    for (int i = f; i <= l; i++) {
      if (i % d == 0) {
        tmp[counter] = i;
        counter++;
      }
    }
    int[] res = new int[counter];
    if (counter > 0) {
      res = Arrays.copyOfRange(tmp, 0, counter - 1);
    }
    return res;
  }

  private static int[] ArrayWithRemainder(int f, int l, int d) {
    int[] tmp = new int[Math.abs(l - f + 1)];
    int counter = 0;
    for (int i = f; i <= l; i++) {
      if (i % d != 0) {
        tmp[counter] = i;
        counter++;
      }
    }
    int[] res = new int[counter];
    if (counter > 0) {
      res = Arrays.copyOfRange(tmp, 0, counter - 1);
    }
    return res;
  }

  public static String GetQueryString(String table, String fields, String where) {
    StringBuilder sb=new StringBuilder("select ");
    sb
    //.append(GetFields(table, fields))
    .append(" from " + table)
    .append(table);
    String sql="";
    return sql;
  }

  /*private static String GetFields(String table, String fields){
  //String [] arrf=fields.split(fields);
  StringBuilder fb=new StringBuilder(f);
  if(fields.length()>0){
    for(int i=0;i<fields.length;i++){
    fb.append(table +"."+fields[i]+", ");
    }
    fb.delete(fb.length()-2, fb.length()+1);
    }
    else{
      //f="*";
    }

}
return f;
  }*/
}
