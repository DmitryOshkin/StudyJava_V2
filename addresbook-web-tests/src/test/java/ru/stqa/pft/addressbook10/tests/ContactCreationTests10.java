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
    ContactData contact = new ContactData()
            .withFirstname("Name1")
            .withLastname("LastName")
            .withAddress("Moscow, Petrovka 38")
            .withHomePhone("+7(902)0000000")
            .withMobilePhone("8 902 000 0001")
            .withWorkPhone("8-902-000-0002")
            .withEmail("email1@test.com")
            .withEmail2("email2@test.com")
            .withEmail3("email3@test.com")
            .withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().сount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
