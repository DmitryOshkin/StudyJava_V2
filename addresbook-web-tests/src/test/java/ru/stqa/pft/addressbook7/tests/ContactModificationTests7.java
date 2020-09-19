package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.ContactData;

public class ContactModificationTests7 extends TestBase {

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
