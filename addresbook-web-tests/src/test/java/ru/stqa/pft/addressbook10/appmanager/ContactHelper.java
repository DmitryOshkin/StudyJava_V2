package ru.stqa.pft.addressbook10.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup()); //Выбираю значение из выпадающего списка
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group"))); //Проверка того что элемента не должно быть
    }
  }

  public void gotoAddContactPage() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void closeAlertAccept() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contact, boolean creation) {
    gotoAddContactPage();
    fillContactForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();                                   //Создаем список который будет заполняться
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name = 'entry']"));             //Создаем список объектов типа WebElement
    for (WebElement element : elements) {                                                   //Проходим по всемм элементам списка elements
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String firstname = cells.get(2).getText();                                                     //Получаем значение из каждого элемента методом getText
      String lastname = cells.get(1).getText();


      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));    //Получаем значение элемента внутри другого элемента
      ContactData contact = new ContactData(id, firstname, lastname, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1");                  //Создаем объект типа GroupData
      contacts.add(contact);                                                                   //Добавляем созданный объект в список
    }
    return contacts;
  }
}
