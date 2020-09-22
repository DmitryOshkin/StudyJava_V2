package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.List;

public class ContactDeletionTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), false);
    }
  }

  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); //Создаем список всех контактов до начала создания нового контакта
    int index = before.size() -1;
    app.getContactHelper().selectContact(index);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlertAccept();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), index);

    before.remove(index);  //из первоначального списка убираем тот элемент который удален во время теста.
    Assert.assertEquals(before, after);     //Сравниваем измененный список со списком полученным после удаления группы

  }


}
