package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
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
                      //         .withGroup("test1")
                      .withPhoto(new File("src/test/resources/sketching_8.jpg"))
              , false);
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next(); //Создаем список всех контактов и возвращает любой элемент из него
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    /*
    assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    */
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private <T> String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}
