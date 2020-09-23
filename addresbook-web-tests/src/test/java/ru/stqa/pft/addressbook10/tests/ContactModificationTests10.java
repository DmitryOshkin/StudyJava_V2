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
              .withAddress("Moscow, Petrovka 38").withMobile("89020000001")
              .withEmail("email1@test.com").withGroup("test1"), false);
    }
  }

  @Test //(enabled = false)
  public void testContactModification() {
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData modifiedContact = before.iterator().next(); //Возвращает любой элемент из множества
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Name")
            .withLastname("LastName").withAddress("Moscow, Petrovka 38")
            .withMobile("89020000001").withEmail("email@test.com");
    app.contact().modify(contact);
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
