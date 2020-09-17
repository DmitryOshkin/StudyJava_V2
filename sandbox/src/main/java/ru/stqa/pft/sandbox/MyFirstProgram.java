package ru.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("Humans"); //Вызываем функцию передавая в нее параметр
    hello("world");
    hello("Dmitry");
    double l = 11;
    System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(4 ,6 );

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));

  }

  public static void hello(String somebody) { //Создаем функцию с параметром somebody
    System.out.println("Hello, " + somebody + "!");

  }

  public static double area (double len) {
    return len * len;

  }
  public static double area (double a, double b) {
    return a * b;
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area (Rectangle r) {
    return r.a * r.b;
  }

}