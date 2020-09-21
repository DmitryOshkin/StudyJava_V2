package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE)); // метод сравнения, сравниваем на значение истина, вызываем класс prime в нем метод isPrime и передаем в него значение MAX_VALUE
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2)); // метод сравнения, сравниваем на значение ложь, вызываем класс prime в нем метод isPrime и передаем в него значение (MAX_VALUE - 2)
  }

  @Test(enabled = false) // аннотация enables = false отключает этот Тест
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n)); // метод сравнения, сравниваем на значение истина, вызываем класс prime в нем метод isPrime и передаем в него значение MAX_VALUE
  }

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE)); // метод сравнения, сравниваем на значение истина, вызываем класс prime в нем метод isPrime и передаем в него значение MAX_VALUE
  }

  @Test
  public void testPrimeMoreFast() {
    Assert.assertTrue(Primes.isPrimeMoreFast(Integer.MAX_VALUE)); // метод сравнения, сравниваем на значение истина, вызываем класс prime в нем метод isPrime и передаем в него значение MAX_VALUE
  }
}
