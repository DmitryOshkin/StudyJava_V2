package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.GroupData;

import java.util.Set;

public class GroupCreationTests10 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

   // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());    //Вычисление максимального идентификатора через лямбда выражение.                                                          //Присваиваем максимальный элемент в качестве идетификатора новой группы
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);                                                             //Добавляем в множество уже модифицированный элемент
    Assert.assertEquals(before, after);  //сравнение упорядоченных списков
  }
}
