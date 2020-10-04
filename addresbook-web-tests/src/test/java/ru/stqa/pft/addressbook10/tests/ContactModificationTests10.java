package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
                      .withFirstname("Name1")
                      .withAddress("Moscow, Petrovka 38")
                      .withHomePhone("+7(902)0000000")
                      .withMobilePhone("8 902 000 0001")
                      .withWorkPhone("8-902-000-0002")
                      .withEmail("email1@test.com")
                      .withEmail2("email2@test.com")
                      .withEmail3("email3@test.com")
                      //        .withGroup("test 1")
                      .withPhoto(new File("src/test/resources/sketching_8.jpg"))
              , false);
    }
  }

  @Test //(enabled = false)
  public void testContactModification() {
    Contacts before = app.db().contacts(); //Создаем список всех контактов до начала создания нового контакта
    ContactData modifiedContact = before.iterator().next(); //Возвращает любой элемент из множества
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstname("MName")
            .withLastname("MLastName")
            .withAddress("Moscow, Petrovka 38")
            .withHomePhone("89020000009")
            .withMobilePhone("89020000008")
            .withWorkPhone("89020000007")
            .withEmail("email9@test.com")
            .withEmail2("email8@test.com")
            .withEmail3("email7@test.com")
            .withPhoto(new File("src/test/resources/sketching_7.jpg"));
    app.goTo().homePage();
    app.contact().modify(contact);
    assertThat(app.contact().сount(), equalTo(before.size()));
    Contacts after = app.db().contacts(); //Создаем список всех контактов после создания нового контакта
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }


}
