package ru.stqa.pft.sandbox;



public class Equality {

  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = s1;
    String s3 = new String(s1); //Создаем новый объект в который копируется значение из старого
    String s4 = "firefox";// Копирование ссылки нет
    String s5 = "fire" + "fox";// Копирование ссылки нет
    String s6 = "firefox 2.0";
    String s7 = "firefox " + Math.sqrt(4.0);// Компилятор не высчитывает на этапе компиляции значение выражения

    System.out.println(s1 == s2); //Сравнение ссылок на объект (Физическое сравнение)
    System.out.println(s1.equals(s2)); // Сравнение содержимого объектов (Логическое сравнение)
    System.out.println(s1 == s3); //Сравнение ссылок на объект (Физическое сравнение)
    System.out.println(s1.equals(s3)); // Сравнение содержимого объектов (Логическое сравнение)
    System.out.println(s1 == s4); //Сравнение ссылок на объект (Физическое сравнение)
    System.out.println(s1.equals(s4)); // Сравнение содержимого объектов (Логическое сравнение)
    System.out.println(s1 == s5); //Сравнение ссылок на объект (Физическое сравнение)
    System.out.println(s1.equals(s5)); // Сравнение содержимого объектов (Логическое сравнение)
    System.out.println(s6 == s7); //Сравнение ссылок на объект (Физическое сравнение)
    System.out.println(s6.equals(s7)); // Сравнение содержимого объектов (Логическое сравнение)


  }

}
