package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  /*  1
    public static void main(String[] args) {
      String[] langs = new String[4];             //Объявлена переменная lang типа массив строк String[] и создан новый объект типа массив размером 4
      langs[0] = "Java";                           //Заполняем элементы массива по порядковому номеру
      langs[1] = "C#";
      langs[2] = "Pyton";
      langs[3] = "PHP";
    }
  */
  /*  2
  Другая запись и заполнение массива элементами
  */
 /*
  public static void main(String[] args) {
    String[] langs = { "Java", "C#", "Pyton", "PHP"};                         //Заполняем элементы массива значениями

    for (int i = 0; i < langs.length; i++){                                    //Проходим по всем элементам массива, определяем длину массива методом length и используем значения по индексу
      System.out.println("Я хочу выучить " + langs[i]);
    }
  }
  */
  /*  3
  Другая запись и заполнение массива элементами с конструкцией цикла предназначенной для перебора элементов коллекций
  */
  /*
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Pyton", "PHP"};                         //Заполняем элементы массива значениями

    for (String l : langs) {                                    //Проходим по всем элементам массива (Для каждого элемента l входящего в коллекцию выполнить действие)
      System.out.println("Я хочу выучить " + l);
    }
  }
  */
/*  4
Классы для работы с коллекциями
Списки - упорядоченные
Множества  - не упорядоченные
*/
 /*
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Pyton", "PHP"};                         //Заполняем элементы массива значениями

    List<String> languages = new ArrayList<String>();                   //Создаем список
    languages.add("Java");                                              //ЗАполняем список значениями
    languages.add("C#");
    languages.add("Python");

    for (String l : languages) {                                    //Проходим по всем элементам массива (Для каждого элемента l входящего в коллекцию выполнить действие)
      System.out.println("Я хочу выучить " + l);
    }
  }
*/
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Pyton", "PHP"};                         //Заполняем элементы массива значениями

    List<String> languages = Arrays.asList("Java", "C#", "Pyton", "PHP");                   //Преобразуем массив в список

    for (String l : languages) {                                    //Проходим по всем элементам массива (Для каждого элемента l входящего в коллекцию выполнить действие)
      System.out.println("Я хочу выучить " + l);
    }
  }
}
