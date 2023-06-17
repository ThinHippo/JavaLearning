package Tasks;

import java.io.IOException;

//import java.io.File;
/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
> Данные для фильтрации приведены ниже в виде json-строки.
> Если значение null, то параметр не должен попадать в запрос.
> Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/

public class task_02 {
  public static void run() throws IOException {
    String table = "students";
    String filterpath = "JavaProject/Files/studentsfilter.txt";
    String jsonfilter = lib.ReadFile(filterpath);
    Boolean selectempty = false;
    System.out.println(lib.GetSimpleQueryString(table, jsonfilter, selectempty));
  }

}
