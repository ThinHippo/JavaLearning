package Tasks;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class lib {
  public static int Msb(int a) {
    a = Math.abs(a);
    int n = Integer.toBinaryString(a).length() - 1;
    return n;
  }

  public static int[] ArrayFromRangeByRemainder(int a, int b, int d, boolean withremainder) {
    int first = a;
    int last = b;
    if (a > b) {
      first = b;
      last = a;
    }
    int[] resArray = new int[Math.abs(last - first + 1)];

    if (withremainder == false) {// нет остатка
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

  // Формирование простой строки sql-запроса из одной таблицы
  public static String GetSimpleQueryString(String table, String jsonconditions, boolean withnullcondition) {
    String condition = GetWhereFromJson(table, jsonconditions, withnullcondition);
    StringBuilder sb = new StringBuilder("SELECT ");
    sb
        .append(table + ".* FROM " + table)
        .append(condition)
        .append(";");
    String sql = sb.toString();
    return sql;
  }

  // Формирование условия отбора where для sql-запроса
  public static String GetWhereFromJson(String table, String jsonstring, boolean withnull) {
    String where = "";
    ArrayList<String> tmplist = new ArrayList<String>();
    if (jsonstring.length() > 0) {
      Map<String, String> wherecollection = GetMapFromJson(jsonstring);
      if (wherecollection.size() > 0) {
        for (Map.Entry<String, String> entry : wherecollection.entrySet()) {
          where = GetStringFromKeyAndValue(table, entry.getKey(), entry.getValue());
          if (withnull == true) {
            tmplist.add(GetStringFromKeyAndValue(table, entry.getKey(), entry.getValue()));
          }
          if ((withnull == false) && (where.indexOf(" Is Null") == -1)) {
            tmplist.add(GetStringFromKeyAndValue(table, entry.getKey(), entry.getValue()));
          }
        }
      }
      if (tmplist.size() > 0) {

        where = (" WHERE (" + String.join(" And ", tmplist) + ")");
        // where=(" WHERE (" + String.join(" And ", wherearr) + ")");
      } else {
        where = "";
      }
    }
    return where;
  }

  // Формирование коллекции ключ:значение из json-строки
  private static Map<String, String> GetMapFromJson(String jsonstring) {
    Map<String, String> jsonmap = new HashMap<String, String>(0);
    // correct json
    // System.out.println("Пришло для разбора: " + jsonstring);
    if ((jsonstring.substring(0, 1).toString().equals("{")) &&
        (jsonstring.substring(jsonstring.length() - 1, jsonstring.length()).toString().equals("}"))) {
      jsonstring = jsonstring.substring(1, jsonstring.length() - 1);
      jsonstring = jsonstring.replace("\"", "");
      String[] jsonarr = jsonstring.split(",");
      if (Array.getLength(jsonarr) > 0) {
        String[] keyvalue = new String[2];
        for (int i = 0; i < Array.getLength(jsonarr); i++) {
          keyvalue = jsonarr[i].split(":");
          jsonmap.put(keyvalue[0], keyvalue[1]);
        }
      }
    }
    return jsonmap;
  }

  // Получение форматированного условия из пары ключ(поле):значение
  private static String GetStringFromKeyAndValue(String table, String key, String val) {
    StringBuilder whereitem = new StringBuilder("");
    switch (GetClassName(val)) {
      case "NULL":
        whereitem
            .append("((" + table)
            .append("." + key + ") Is Null)");
        break;
      case "BOOL":
        whereitem
            .append("((" + table)
            .append("." + key + ")=")
            .append(val.toString() + ")");
        break;
      case "NUM":
        whereitem
            .append("((" + table)
            .append("." + key + ")=")
            .append(val.toString() + ")");
        break;
      case "STRING":
        if (val.toString().indexOf("*") != -1) {// Для отбора по не полному совпадению строки
          whereitem
              .append("((" + table)
              .append("." + key + ") Like ")
              .append("\"" + val.toString() + "\")");
        } else {
          whereitem
              .append("((" + table)
              .append("." + key + ") = ")
              .append("\"" + val.toString() + "\")");
        }
        break;
      default:
        break;
    }

    return whereitem.toString();

  }

  public static String GetClassName(String str) {
    String classname = "";
    switch (str) {
      case "null":
        classname = "NULL";
        break;
      case "true":
        classname = "BOOL";
        break;
      case "fauls":
        classname = "BOOL";
        break;
      default:
        if (isNumeric(str) == true) {
          classname = "NUM";
        } else {
          classname = "STRING";
        }
        break;
    }
    return classname;
  }

  // Проверка является ли строковая переменная числом
  public static boolean isNumeric(String str) {
    try {
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static String ReadFile(String logpath) throws IOException {
    StringBuilder txt = new StringBuilder("");
    Path fp = Path.of(logpath);
    txt.append(Files.readString(fp));
    return txt.toString();
  }

  public static void ShowFormatedLog(String format, String jsonlog, String[] keys) {
    StringBuilder res = new StringBuilder("");
    Map<String, String> logcollection = new HashMap<String, String>(0);//
    if ((jsonlog.substring(0, 1).toString().equals("[")) &&
        (jsonlog.substring(jsonlog.length() - 1, jsonlog.length()).toString().equals("]"))) {
      jsonlog = jsonlog.substring(1, jsonlog.length() - 1);
      jsonlog = jsonlog.replace("},{", "}~{");
      String[] logarr = jsonlog.split("~");
      for (int i = 0; i < logarr.length; i++) {
        logcollection = GetMapFromJson(logarr[i]);
        res
            .append(String.format(format, logcollection.get(keys[0]), logcollection.get(keys[1]),
                logcollection.get(keys[2])))
            .append("\n");
      }
      System.out.println(res);
    }
  }

  public static void ReplaceSubstringStringMsDuration(String txt, String target, String replacement) {
    long lentxt = txt.length();
    String stxt = txt;
    System.out.println("*****СТРОКА (String)*****");
    System.out.println("ТЕКСТ ДО ИЗМЕНЕНИЯ: " + stxt.substring(0, 100));
    long msduration = System.nanoTime();
    stxt = stxt.replace(target, replacement);
    msduration = System.nanoTime() - msduration;
    System.out.println("ТЕКСТ ПОСЛЕ ИЗМЕНЕНИЯ: " + stxt.substring(0, 100));
    System.out.println("(* для контроля выведены первые 100 символов)");
    System.out.println("ДЛИНА ТЕКСТА: " + lentxt);
    System.out.println("ВРЕМЯ ИСПОЛНЕНИЯ: " + msduration + " ns\n");
  }

  public static void ReplaceSubstringBuilderMsDuration(String txt, String target, String replacement) {
    long lentxt = txt.length();
    StringBuilder sbtxt = new StringBuilder(txt);
    System.out.println("*****ПОСТРОИТЕЛЬ СТРОКИ (StringBuilder)*****");
    System.out.println("ТЕКСТ ДО ИЗМЕНЕНИЯ: " + sbtxt.toString().substring(0, 100));
    long msduration = System.nanoTime();
    while (sbtxt.lastIndexOf(target) != -1) {
      sbtxt.replace(sbtxt.lastIndexOf(target), sbtxt.lastIndexOf(target) + target.length(), replacement);
    }
    msduration = System.nanoTime() - msduration;
    System.out.println("ТЕКСТ ПОСЛЕ ИЗМЕНЕНИЯ: " + sbtxt.toString().substring(0, 100));
    System.out.println("(* для контроля выведены первые 100 символов)");
    System.out.println("ДЛИНА ТЕКСТА: " + lentxt);
    System.out.println("ВРЕМЯ ИСПОЛНЕНИЯ: " + msduration + " ns\n");
  }

  public static ArrayList<Integer> GetRndArrayList(int size, int minvalue, int maxvalue) {
    ArrayList<Integer> list = new ArrayList<>(0);
    Random rnd = new Random();
    for (int i = 0; i < size; i++) {
      list.add(rnd.nextInt(minvalue, maxvalue + 1));
    }
    return list;
  }

  public static ArrayList<Integer> GetArrayListItemsWithoutRemainder(ArrayList<Integer> arraylist, int div) {
    for (int i = arraylist.size()-1; i >=0; i--) {
      if (arraylist.get(i) % div == 0) arraylist.remove(i);
      }
    arraylist.trimToSize();
    return arraylist;
  }

  public static int ArrayListMaxValue(ArrayList<Integer> arraylist) {
    Collections.sort(arraylist);
    return arraylist.get(arraylist.size() - 1);
  }

  public static int ArrayListMinValue(ArrayList<Integer> arraylist) {
    Collections.sort(arraylist);
    return arraylist.get(0);
  }

  public static double ArrayListAvgValue(ArrayList<Integer> arraylist) {
    double listavg = 0.0;
    if (arraylist.size() != 0) {
      for (int i = 0; i < arraylist.size(); i++) {
        listavg +=arraylist.get(i);
      }
      return listavg / arraylist.size();
    } else {
      System.out.println("Ошибка деления на ноль");
      return 0;
    }
  }
}
