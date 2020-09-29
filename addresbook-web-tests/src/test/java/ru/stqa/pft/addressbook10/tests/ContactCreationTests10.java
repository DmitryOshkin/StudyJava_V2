package ru.stqa.pft.addressbook10.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.ContactData;
import ru.stqa.pft.addressbook10.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests10 extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withFirstname(split[0]).withLastname(split[1]).withAddress(split[2])
                .withHomePhone(split[3]).withMobilePhone(split[4]).withWorkPhone(split[5])
                .withEmail(split[6]).withEmail2(split[7]).withEmail3(split[8]).withGroup(split[9])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }


  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());   //List<ContactData>.class
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")//(enabled = false)
  public void testContactCreation(ContactData contact) throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    File photo = new File("src/test/resources/sketching_8.jpg");
   /* ContactData contact = new ContactData()
            .withFirstname("Name1")
            .withLastname("LastName")
            .withAddress("Moscow, Petrovka 38")
            .withHomePhone("+7(902)0000000")
            .withMobilePhone("8 902 000 0001")
            .withWorkPhone("8-902-000-0002")
            .withEmail("email1@test.com")
            .withEmail2("email2@test.com")
            .withEmail3("email3@test.com")
            .withPhoto(photo)
            .withGroup("test1");*/
    app.contact().create(contact, true);
    assertThat(app.contact().сount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreationPhoto() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all(); //Создаем список всех контактов до начала создания нового контакта
    File photo = new File("src/test/resources/sketching_8.jpg");
    ContactData contact = new ContactData()
            .withFirstname("Name1")
            .withLastname("LastName")
            .withAddress("Moscow, Petrovka 38")
            .withHomePhone("+7(902)0000000")
            .withMobilePhone("8 902 000 0001")
            .withWorkPhone("8-902-000-0002")
            .withEmail("email1@test.com")
            .withEmail2("email2@test.com")
            .withEmail3("email3@test.com")
            .withPhoto(photo)
            .withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().сount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all(); //Создаем список всех контактов после создания нового контакта
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());                      //определяем текущую директорию проекта
    File photo = new File("src/test/resources/sketching_8.jpg");
    System.out.println(photo.getAbsolutePath());                           // Определяем путь к файлу
    System.out.println(photo.exists());                                    // Убеждаемся в наличии файла
  }

}
