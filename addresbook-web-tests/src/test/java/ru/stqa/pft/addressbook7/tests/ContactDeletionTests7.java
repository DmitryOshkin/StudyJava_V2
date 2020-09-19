package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests7 extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlertAccept();
    //app.getNavigationHelper().gotoHomePage();

  }


}
