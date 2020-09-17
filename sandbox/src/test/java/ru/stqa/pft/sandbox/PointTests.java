package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void TestDistance1() {
    Point p1 = new Point(7, 7);
    Point p2 = new Point(0, 0);
    Assert.assertEquals((p1.distance(p1, p2)), 25);

  }

  @Test
  public void TestDistance2() {
    Point p1 = new Point(7, 7);
    Point p2 = new Point(0, 0);
    Assert.assertNotEquals((p1.distance(p1, p2)), 25);

  }

  @Test
  public void TestDistance3() {
    Point p1 = new Point(7, 7);
    Point p2 = new Point(0, 0);
    assert((p1.distance(p1, p2))<= 25);

  }
}
