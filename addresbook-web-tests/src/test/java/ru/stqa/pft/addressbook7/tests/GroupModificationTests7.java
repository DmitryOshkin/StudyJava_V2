package ru.stqa.pft.addressbook7.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests7 extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {   //Добавляем условие для проверки наличия группы
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "test1", "test2", "test6");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size() - 1);                                        //Удаляем из списка элемент который модифицируем
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));  //Перед сравнением преобразовываем списки в множества

  }
}
