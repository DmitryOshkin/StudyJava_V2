package ru.stqa.pft.addressbook5.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook5.model.GroupData;

public class GroupCreationTests5 extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();


  }








}
