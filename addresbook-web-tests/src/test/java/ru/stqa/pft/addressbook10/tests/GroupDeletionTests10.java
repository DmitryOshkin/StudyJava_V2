package ru.stqa.pft.addressbook10.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook10.model.GroupData;
import ru.stqa.pft.addressbook10.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests10 extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {   //Добавляем условие для проверки наличия группы
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().сount(), equalTo(before.size() - 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
