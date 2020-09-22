package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests10 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

   // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());    //Вычисление максимального идентификатора через лямбда выражение.                                                          //Присваиваем максимальный элемент в качестве идетификатора новой группы
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);  //сравнение упорядоченных списков
  }
}
