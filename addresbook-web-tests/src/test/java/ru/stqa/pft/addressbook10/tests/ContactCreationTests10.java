package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests10 extends TestBase {


  @Test //(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData contact = new ContactData().withFirstname("Name1")
            .withLastname("LastName").withAddress("Moscow, Petrovka 38")
            .withMobile("89020000001").withEmail("email1@test.com").withGroup("test1");
    app.contact().create(contact, true);
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
