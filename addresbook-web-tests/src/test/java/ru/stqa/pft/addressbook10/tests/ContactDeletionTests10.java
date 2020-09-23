package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.Set;

public class ContactDeletionTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Name1")
              .withAddress("Moscow, Petrovka 38").withMobile("89020000001")
              .withEmail("email1@test.com").withGroup("test1"), false);
    }
  }

  @Test //(enabled = false)
  public void testContactDeletion() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    ContactData deletedContact = before.iterator().next(); //Возвращает любой элемент из множества
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);  //из первоначального списка убираем тот элемент который удален во время теста.
    Assert.assertEquals(before, after);     //Сравниваем измененный список со списком полученным после удаления группы

  }
}
