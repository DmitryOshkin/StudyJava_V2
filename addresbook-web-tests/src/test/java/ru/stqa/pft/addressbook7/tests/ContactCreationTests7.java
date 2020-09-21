package ru.stqa.pft.addressbook7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.ContactData;
import ru.stqa.pft.addressbook7.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests7 extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList(); //Создаем список всех контактов до начала создания нового контакта
    ContactData contact = new ContactData("Name1", "LastName", "Moscow, Petrovka 38", "89020000001", "email1@test.com", "test1");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() + 1);

    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());    //Вычисление максимального идентификатора через лямбда выражение.                                                          //Присваиваем максимальный элемент в качестве идетификатора новой группы
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);  //сравниваем упорядоченные списки
  }
}
