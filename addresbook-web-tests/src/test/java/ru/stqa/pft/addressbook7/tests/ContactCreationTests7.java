package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.ContactData;

public class ContactCreationTests7 extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }


}
