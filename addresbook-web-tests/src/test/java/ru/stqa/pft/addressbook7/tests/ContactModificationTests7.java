package ru.stqa.pft.addressbook7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.ContactData;
import ru.stqa.pft.addressbook7.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests7 extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), false);
    }
    List<ContactData> before = app.getContactHelper().getContactList(); //Создаем список всех контактов до начала создания нового контакта
   // app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().initContactModification(before.size() -1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Name", "LastName", "Moscow, Petrovka 38", "89020000001", "email@test.com", null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);                                        //Удаляем из списка элемент который модифицируем
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super ContactData> byId= (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);                // Сортируем список с помощью метода sort
    after.sort(byId);                 //Сортируем список с помощью метода sort
    Assert.assertEquals(before, after);  //Сравниваем 2 отсортированных списка

  }
}
