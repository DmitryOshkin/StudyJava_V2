package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.Set;

public class ContactCreationTests10 extends TestBase {


  @Test //(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData contact = new ContactData().withFirstname("Name1")
            .withLastname("LastName").withAddress("Moscow, Petrovka 38")
            .withMobile("89020000001").withEmail("email1@test.com").withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(before, after);  //сравниваем упорядоченные списки
  }
}
