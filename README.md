# JavaLearning
## Содержание

[Урок 1. Знакомство с языком программирования Java](#урок-1-знакомство-с-языком-программирования-java)

[Урок 2. Почему вы не можете не использовать API](#урок-2-почему-вы-не-можете-не-использовать-api)


## Урок 1. Знакомство с языком программирования Java
### Задача 1
> 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i;
> 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа;
> 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1;
> 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2;

Пункты реализовать в методе main
*Пункты реализовать в разных методах

[Решение задачи 1](JavaProject/Tasks/task_01.java "Нажмите для перехода к файлу с решением")

*[наверх к содержанию](#содержание)*

## Урок 2. Почему вы не можете не использовать API
### Задача 2

> Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
> Данные для фильтрации приведены ниже в виде json-строки.
> Если значение null, то параметр не должен попадать в запрос.
> Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

### Задача 3

> Дана json-строка (можно сохранить в файл и читать из файла)
> [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
> Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
> Студент [фамилия] получил [оценка] по предмету [предмет].
> Пример вывода:
> Студент Иванов получил 5 по предмету Математика.
> Студент Петрова получил 4 по предмету Информатика.
> Студент Краснов получил 5 по предмету Физика.

### Задача 4

> Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.

[Решение задачи 2](JavaProject/Tasks/task_02.java "Нажмите для перехода к файлу с решением")

*[наверх к содержанию](#содержание)*
