package Tasks;

import java.io.IOException;

/*Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder. */

public class task_04 {
  public static void run() throws IOException{
    String longreadpath = "JavaProject/Files/longread.txt";
    String longread = lib.ReadFile(longreadpath);
    String target="и";
    String replacement="Ы";
    lib.ReplaceSubstringStringMsDuration(longread,target,replacement);
    lib.ReplaceSubstringBuilderMsDuration(longread,target,replacement);
  }
}
