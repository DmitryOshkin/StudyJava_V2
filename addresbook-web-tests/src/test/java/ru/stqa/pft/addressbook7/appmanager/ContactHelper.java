package ru.stqa.pft.addressbook7.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook7.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type (By.name("firstname"), contactData.getFirstname());
    type (By.name("lastname"), contactData.getLastname());
    type (By.name("address"), contactData.getAddress());
    type (By.name("mobile"), contactData.getMobile());
    type (By.name("email"), contactData.getEmail());

  }

  public void gotoAddContactPage() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }


  public void closeAlertAccept() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click (By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
}
