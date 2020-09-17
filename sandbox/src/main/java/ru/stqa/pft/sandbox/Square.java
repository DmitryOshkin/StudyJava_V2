package ru.stqa.pft.sandbox;

public class Square {

  public double l;

  public Square(double l)  { //Конструктор класса

    this.l = l;

  }

  public double area() {
    return this.l * this.l;
  }

}
