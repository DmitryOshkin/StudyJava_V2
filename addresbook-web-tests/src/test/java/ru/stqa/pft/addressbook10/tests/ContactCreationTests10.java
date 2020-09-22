package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests10 extends TestBase {


  @Test //(enabled = false)
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list(); //Создаем список всех контактов до начала создания нового контакта
    ContactData contact = new ContactData().withFirstname("Name1")
            .withLastname("LastName").withAddress("Moscow, Petrovka 38")
            .withMobile("89020000001").withEmail("email1@test.com").withGroup("test1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list(); //Создаем список всех контактов после создания нового контакта
    Assert.assertEquals(after.size(), before.size() + 1);

    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());    //Вычисление максимального идентификатора через лямбда выражение.                                                          //Присваиваем максимальный элемент в качестве идетификатора новой группы
    before.add(contact);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(), c2.getId());;
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);  //сравниваем упорядоченные списки
  }
}
