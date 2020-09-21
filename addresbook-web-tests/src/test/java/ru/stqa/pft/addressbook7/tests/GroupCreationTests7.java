package ru.stqa.pft.addressbook7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests7 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;                                                                   //Найти максимальный идентификатор из всех в списке
    for (GroupData g : after) {                                                    //Проходим по всем элементам списка after
      if (g.getId() > max) {
        max =g.getId();
      }
    }
    group.setId(max);                                                              //Присваиваем максимальный элемент в качестве идетификатора новой группы
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));  //Перед сравнением преобразовываем списки в множества
  }
}
