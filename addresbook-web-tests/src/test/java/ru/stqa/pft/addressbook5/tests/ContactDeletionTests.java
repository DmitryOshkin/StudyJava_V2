package ru.stqa.pft.addressbook5.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {



  @Test
  public void testContactDeletionTests() throws Exception {

    app.selectContact();
    app.deleteSelectedContacts();
    app.closeAlertAccept();
    app.gotoHomePage();
  }


}
