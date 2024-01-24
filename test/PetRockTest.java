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
  /**
   * Set up the time limit
   */
  @Rule
  public Timeout globalTimeut=Timeout.seconds(10);

  /**
   * test the constructer
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    rockey=new PetRock("Rocky",5.0,5.0);
  }

  /**
   * test name(String) using assertEquals
   * @throws Exception
   */
  @Test
  public void getName() throws Exception{
    assertEquals("Rocky",rockey.getName());
  }

  /**
   * test property happy(boolean) using assertFalse
   * @throws Exception
   */
  @Test
  public void testUnHappyToStart() throws  Exception{
    assertFalse(rockey.isHapppy() );
  }

  /**
   * test property happy using assertTrue
   * @throws Exception
   */
  @Test
  public void tsetHappyAfterPlay() throws Exception{
    rockey.playWithRock();
    assertTrue(rockey.isHapppy());
  }

  /**
   * test IllegalStateException
   * @throws Exception
   */
  @Test(expected = IllegalStateException.class)
  public void nameFail() throws Exception{
    rockey.getHappyMessage();
  }

  /**
   * test IllegalStateException
   * @throws Exception
   */
  @Test
  public void name() throws Exception{
    rockey.playWithRock();
    String msg= rockey.getHappyMessage();
    assertEquals("I'm happy!",msg);
  }

  /**
   * test RuntimeException
   * @throws Exception
   */
  @Test(expected = RuntimeException.class)
  public void testUnhappy() throws Exception{
    rockey.playWithRock();
    rockey.getUnHappyMessage();
  }

  /**
   * test number using assertEquals
   * @throws Exception
   */
  @Test
  public void testFavNum() throws Exception{
    assertEquals(42,rockey.getFavNumer());
  }

  /**
   * test IllegalArgumentException
   * @throws Exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception{
    new PetRock("",5.0,5.0);
  }

  /**
   * test timeout
   */
  @Test//(timeout = 100)
  public void waitForHappyTimeut() {
    rockey.waitTillHappy();
  }

  /**
   * test two Double object using assertSame
   */
  @Test
  public void testSame() {
    assertSame(rockey.getNum1(),rockey.getNum2());
  }

  /**
   * test toString
   */
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