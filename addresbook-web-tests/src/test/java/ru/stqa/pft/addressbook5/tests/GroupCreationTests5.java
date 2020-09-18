package ru.stqa.pft.addressbook5.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook5.model.GroupData;

public class GroupCreationTests5 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();


  }








}
