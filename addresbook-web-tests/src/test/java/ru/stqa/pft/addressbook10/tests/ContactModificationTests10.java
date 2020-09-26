package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Name1")
              .withAddress("Moscow, Petrovka 38")
              .withHomePhone("89020000000").withMobilePhone("89020000001").withWorkPhone("89020000002")
              .withEmail("email1@test.com").withEmail2("email2@test.com").withEmail3("email3@test.com").withGroup("test1"), false);
    }
  }

  @Test //(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData modifiedContact = before.iterator().next(); //Возвращает любой элемент из множества
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("MName")
            .withLastname("MLastName").withAddress("Moscow, Petrovka 38")
            .withHomePhone("89020000009").withMobilePhone("89020000008").withWorkPhone("89020000007")
            .withEmail("email9@test.com").withEmail2("email8@test.com").withEmail3("email7@test.com");
    app.contact().modify(contact);
    assertThat(app.contact().сount(), equalTo(before.size()));
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
