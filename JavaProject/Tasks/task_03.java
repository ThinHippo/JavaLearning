package Tasks;

import java.io.IOException;

/*
Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/

public class task_03 {
  public static void run() throws IOException {
    String logpath = "JavaProject/Files/studentslog.txt";
    String jsonlog = lib.ReadFile(logpath);
    System.out.println("Исходная json-строка: " + jsonlog);
    String format = "Студент %s получил %s по предмету %s.";
    System.out.println("Формат вывода: " + format);
    String[] k = { "фамилия", "оценка", "предмет" };
    lib.ShowFormatedLog(format, jsonlog, k);
  }
}
