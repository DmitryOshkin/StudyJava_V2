package ru.stqa.pft.addressbook10.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.GroupData;

import java.util.Set;

public class GroupModificationTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {   //Добавляем условие для проверки наличия группы
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test6");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());


    before.remove(modifiedGroup);                                        //Удаляем из списка элемент который модифицируем
    before.add(group);                                                             //Добавляем в список уже модифицированный элемент
    Assert.assertEquals(before, after);  //Сравниваем 2 отсортированных списка

  }


}
