package ru.stqa.pft.sandbox;

public class Rectangle {

  public double a;
  public double b;

  public Rectangle (double a, double b) { // Конструктор класса
    this.a = a;
    this.b = b;
  }
  public double area () {
    return this.a * this.b;
  }

}
