package ru.stqa.pft.addressbook10.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))                                 //Проверяем наличие заголовка "h1" на странице
            && wd.findElement(By.tagName("h1")).getText().equals("Groups") //Далее ищем элемент по локатору, берем его текст и сверяем его содержимое методом equals со значением Groups
            && isElementPresent(By.name("new"))) {                         //Проверяем наличие кнопки создания группы
      return;
    }
    click(By.linkText("groups"));
  }

  public void homePage() {
    if (isElementPresent(By.id("maintable"))) { // Проверка наличия элемента таблица на странице
      return;
    }
    click(By.linkText("home"));
  }
}
