package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

public class GroupModificationTests7 extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test6"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();

  }
}
