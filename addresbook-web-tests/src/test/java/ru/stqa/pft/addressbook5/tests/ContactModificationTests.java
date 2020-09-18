package ru.stqa.pft.addressbook5.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook5.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Name", "LastName", "Moscow, Petrovka 38", "89020000001", "email@test.com"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
