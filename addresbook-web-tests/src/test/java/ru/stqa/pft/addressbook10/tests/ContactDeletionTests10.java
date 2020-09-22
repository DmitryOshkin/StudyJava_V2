package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.List;

public class ContactDeletionTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Name1", null, "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1"), false);
    }
  }

  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list(); //Создаем список всех контактов до начала создания нового контакта
    int index = before.size() -1;
    app.contact().delete(index);
    app.goTo().homePage();
    List<ContactData> after = app.contact().list(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(index);  //из первоначального списка убираем тот элемент который удален во время теста.
    Assert.assertEquals(before, after);     //Сравниваем измененный список со списком полученным после удаления группы

  }
}
