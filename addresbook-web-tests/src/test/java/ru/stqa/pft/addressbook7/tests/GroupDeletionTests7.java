package ru.stqa.pft.addressbook7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook7.model.GroupData;

public class GroupDeletionTests7 extends TestBase {


  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {   //Добавляем условие для проверки наличия группы
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }


}
