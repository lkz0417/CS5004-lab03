import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PetRockTest {
  private PetRock rockey;

  @Rule
  public Timeout globalTimeut=Timeout.seconds(10);

  @Before
  public void setUp() throws Exception {
    rockey=new PetRock("Rocky",5.0,5.0);
  }


  @Test
  public void getName() throws Exception{
    assertEquals("Rocky",rockey.getName());
  }

  @Test
  public void testUnHappyToStart() throws  Exception{
    assertFalse(rockey.isHapppy() );
  }

  @Test
  public void tsetHappyAfterPlay() throws Exception{
    rockey.playWithRock();
    assertTrue(rockey.isHapppy());
  }

  @Test(expected = IllegalStateException.class)
  public void nameFail() throws Exception{
    rockey.getHappyMessage();
  }

  @Test
  public void name() throws Exception{
    rockey.playWithRock();
    String msg= rockey.getHappyMessage();
    assertEquals("I'm happy!",msg);
  }

  @Test(expected = RuntimeException.class)
  public void testUnhappy() throws Exception{
    rockey.playWithRock();
    rockey.getUnHappyMessage();
  }

  @Test
  public void testfavNum() throws Exception{
    assertEquals(42,rockey.getFavNumer());
  }
  @Test(expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception{
    new PetRock("",5.0,5.0);
  }

  @Test//(timeout = 100)
  public void waitForHappyTimeut() {
    rockey.waitTillHappy();
  }

  @Test
  public void testSame() {
    assertSame(rockey.getNum1(),rockey.getNum2());
  }
  @Test
  public void testString() {
    String msg="PetRock{" +
        "name='" + rockey.getName() + '\'' +
        ", happy=" + rockey.isHapppy() +
        ", num1=" + rockey.getNum1() +
        '}';
    assertEquals(rockey.toString(),msg);
  }
}