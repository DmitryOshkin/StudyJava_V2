package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

public class GroupCreationTests7 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));
  }
}
