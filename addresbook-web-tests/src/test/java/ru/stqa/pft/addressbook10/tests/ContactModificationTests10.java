package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), false);
    }
  }

  @Test (enabled = false)
  public void testContactModification() {
    List<ContactData> before = app.contact().list(); //Создаем список всех контактов до начала создания нового контакта
    int index = before.size() -1;
    ContactData contact = new ContactData(before.get(index).getId(),"Name", "LastName", "Moscow, Petrovka 38", "89020000001", "email@test.com", null);
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);                                        //Удаляем из списка элемент который модифицируем
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super ContactData> byId= (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);                // Сортируем список с помощью метода sort
    after.sort(byId);                 //Сортируем список с помощью метода sort
    Assert.assertEquals(before, after);  //Сравниваем 2 отсортированных списка

  }


}
