package ru.stqa.pft.addressbook5.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook5.model.ContactData;

public class ContactHelper {
  private WebDriver wd;

  public ContactHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  public void gotoAddContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void deleteSelectedContacts() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  public void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }


  public void closeAlertAccept() {
    wd.switchTo().alert().accept();
  }
}
