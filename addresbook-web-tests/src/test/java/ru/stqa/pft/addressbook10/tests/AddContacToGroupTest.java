package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;
import ru.stqa.pft.addressbook10.model.GroupData;
import ru.stqa.pft.addressbook10.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Objects;
import java.io.File;

public class AddContacToGroupTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
                      .withFirstname("Name1")
                      .withAddress("Moscow, Petrovka 38")
                      .withHomePhone("+7(902)0000000")
                      .withMobilePhone("8 902 000 0001")
                      .withWorkPhone("8-902-000-0002")
                      .withEmail("email1@test.com")
                      .withEmail2("email2@test.com")
                      .withEmail3("email3@test.com")
                      .withPhoto(new File("src/test/resources/sketching_8.jpg"))
              , false);
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test 1"));
    }
  }



  @Test
  public void testAddContactToGroup() {
    Contacts beforeContacts = app.db().contacts(); //Создаем список всех контактов до начала создания нового контакта
    ContactData contactForAdd = beforeContacts.iterator().next(); //Возвращает любой элемент из множества
    Groups beforeGroups = app.db().groups();
    GroupData groupForAdd = beforeGroups.iterator().next();

    app.goTo().homePage();
    app.contact().addToGroup(contactForAdd, groupForAdd);
    app.goTo().homePage();
  }


}
