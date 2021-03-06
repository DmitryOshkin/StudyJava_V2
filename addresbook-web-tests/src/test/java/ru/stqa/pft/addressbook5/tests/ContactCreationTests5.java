package ru.stqa.pft.addressbook5.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook5.model.ContactData;

public class ContactCreationTests5 extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.getContactHelper().gotoAddContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Name1", "LastName2", "Moscow, Petrovka 38", "89020000001", "email1@test.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();

  }


}
