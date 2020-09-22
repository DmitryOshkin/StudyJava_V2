package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {   //Добавляем условие для проверки наличия группы
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test6");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());


    before.remove(index);                                        //Удаляем из списка элемент который модифицируем
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);                // Сортируем список с помощью метода sort
    after.sort(byId);                 //Сортируем список с помощью метода sort
    Assert.assertEquals(before, after);  //Сравниваем 2 отсортированных списка

  }


}
