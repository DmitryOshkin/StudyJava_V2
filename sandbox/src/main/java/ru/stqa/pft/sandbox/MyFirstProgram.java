package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class MyFirstProgram {

  public static void main(String[] args) {
    System.out.println("Hello world!");

    System.out.println(2 + 2);
    System.out.println(2 * 2);
    System.out.println(2 / 2);
    System.out.println(2 - 2);

    System.out.println(1 / 2);
    System.out.println(1.0 / 2);
    System.out.println(1 / 2.0);
    System.out.println(2.0 / 2);

    System.out.println("2" + "2"); //конкатенация
    System.out.println("2" + 2);
    System.out.println(2 + "2");

    System.out.println(2 + 2 * 2);
    System.out.println((2 + 2) * 2);
    System.out.println("2 + 2 = " + 2 +2);
    System.out.println("2 + 2 = " + (2 +2));

    System.out.println("Hello, " + "world!");

    System.out.println("Площадь квадрата со стороной " + 5 + " = " + (5 * 5));
    System.out.println("Площадь квадрата со стороной " + 6 + " = " + (6 * 6));
    int l = 8;
    System.out.println("Площадь квадрата со стороной " + l + " = " + (l * l));
    int s = l * l;
    System.out.println("Площадь квадрата со стороной " + l + " = " + s);

  }

}