package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.List;

public class ContactDeletionTests10 extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), false);
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); //Создаем список всех контактов до начала создания нового контакта
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlertAccept();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() -1);  //из первоначального списка убираем тот элемент который удален во время теста.
    Assert.assertEquals(before, after);     //Сравниваем измененный список со списком полученным после удаления группы

  }


}
