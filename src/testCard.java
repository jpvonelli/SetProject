import junit.framework.TestCase;

public class testCard extends TestCase {
  
  public void testCardAll1() {
    Card c = new Card(1, 1, 1, 1);
    
    assertEquals(1, c.getQuantity());
    assertEquals(1, c.getColor());
    assertEquals(1, c.getShading());
    assertEquals(1, c.getShape());
    assertEquals("1ROO", c.toString());
    
  }
  public void testCardAll2(){
    Card c = new Card(2, 2, 2, 2);
    
    assertEquals(2, c.getQuantity());
    assertEquals(2, c.getColor());
    assertEquals(2, c.getShading());
    assertEquals(2, c.getShape());
    assertEquals("2GTD", c.toString());
  }
  public void testCardAll3(){
    Card c = new Card(3,3,3,3);
    
    assertEquals(3, c.getQuantity());
    assertEquals(3, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(3, c.getShape());
    assertEquals("3PSS", c.toString());
  }
  public void testRandom(){
    Card c = new Card(1,2,1,3);
    
    assertEquals(1, c.getQuantity());
    assertEquals(2, c.getColor());
    assertEquals(1, c.getShading());
    assertEquals(3, c.getShape());
    assertEquals("1GOS", c.toString());
  }
  public void testisSetQuantity(){
    Card c = new Card(1,2,3,1);
    Card c2 = new Card(1,2,2,1);
    Card c3 = new Card(1,2,1,1);
    
    assertEquals(true, c.isSet(c2,c3));
  }
  public void testisSetColor(){
    Card c = new Card(1,3,3,2);
    Card c2 = new Card(2,3,2,1);
    Card c3 = new Card(3,3,1,3);
    
    assertEquals(true, c.isSet(c2,c3));
  }
  public void testisSetShading(){
    Card c = new Card(1,3,3,2);
    Card c2 = new Card(2,1,3,1);
    Card c3 = new Card(3,2,3,3);
    
    assertEquals(true, c.isSet(c2,c3));
  }
  public void testisSetShape(){
    Card c = new Card(1,3,3,2);
    Card c2 = new Card(2,2,2,2);
    Card c3 = new Card(3,1,1,2);
    
    assertEquals(true, c.isSet(c2,c3));
  }
  public void testisSetFalse(){
    Card c = new Card(2,1,3,1);
    Card c2 = new Card(2,1,2,2);
    Card c3 = new Card(3,3,3,1);
    
    assertEquals(false, c.isSet(c2,c3));
  }
  public void testNeg(){
    Card c = new Card(-1, -2, -1, -3);
    
    assertEquals(3, c.getQuantity());
    assertEquals(2, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(1, c.getShape());
    }
    
  }

