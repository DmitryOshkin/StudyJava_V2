package ru.stqa.pft.addressbook7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests7 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());    //Вычисление максимального идентификатора через лямбда выражение.                                                          //Присваиваем максимальный элемент в качестве идетификатора новой группы
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));  //Перед сравнением преобразовываем списки в множества
  }
}
