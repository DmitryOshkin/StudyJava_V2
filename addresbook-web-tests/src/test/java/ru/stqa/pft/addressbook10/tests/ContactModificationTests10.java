package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.Set;

public class ContactModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Name1")
              .withAddress("Moscow, Petrovka 38").withMobile("89020000001")
              .withEmail("email1@test.com").withGroup("test1"), false);
    }
  }

  @Test //(enabled = false)
  public void testContactModification() {
    Set<ContactData> before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData modifiedContact = before.iterator().next(); //Возвращает любой элемент из множества
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Name")
            .withLastname("LastName").withAddress("Moscow, Petrovka 38")
            .withMobile("89020000001").withEmail("email@test.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);                                        //Удаляем из списка элемент который модифицируем
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(before, after);  //Сравниваем 2 отсортированных списка

  }


}
