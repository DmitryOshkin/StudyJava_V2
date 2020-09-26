package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests10 extends TestBase {

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
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData deletedContact = before.iterator().next(); //Возвращает любой элемент из множества
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
