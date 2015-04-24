import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class testTable extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testAddingToTable(){
    Card c1 = new Card(1,1,1,1);
    Card c2 = new Card(2,2,2,2);
    Card c3 = new Card(3,3,3,3);
    
    Table table = new Table();
    table.add(c1);
    table.add(c2);
    table.add(c3);
    
    assertEquals(3, table.numCards());
  }
  public void testRemoveSet(){
    Card c1 = new Card(1,2,3,1);
    Card c2 = new Card(1,2,2,1);
    Card c3 = new Card(1,2,1,1);
    Card c4 = new Card(2,1,3,1);
    Card c5 = new Card(2,1,2,2);
    Card c6 = new Card(3,3,3,1);
    
    
    Table t = new Table();
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
    t.add(c5);
    t.add(c6);
    t.removeSet(c1,c2,c3);
    
    assertEquals(3, t.numCards());
  
  }
  public void testRemoveSetFalse(){
    Card c1 = new Card(2,1,3,1);
    Card c2 = new Card(2,1,2,2);
    Card c3 = new Card(3,3,3,1);
    
    Table t = new Table();
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.removeSet(c1,c2,c3);
  }
  public void testRemoveSetNoTable(){
    Card c1 = new Card(2,1,3,1);
    Card c2 = new Card(2,1,2,2);
    Card c3 = new Card(3,3,3,1);
    Table t = new Table();
    t.removeSet(c1, c2, c3);
    t.removeSet(c1, c2, c3);
  }
  public void testSmallTable(){
    Card c1 = new Card(2,1,3,1);
    Card c2 = new Card(2,1,2,2);
   // Card c3 = new Card(3,3,3,1);
    Table t = new Table();
    
  }
    
  public void testNumCards(){
    Card c1 = new Card(1,2,3,1);
    Card c2 = new Card(1,2,2,1);
    Card c3 = new Card(1,2,1,1);
    
    Table t = new Table();
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals(3, t.numCards());
  }
//  public void testGetCardsTrue(){
//    Card c1 = new Card(1,2,3,1);
//    Card c2 = new Card(1,2,2,1);
//    Card c3 = new Card(1,2,1,1);
//    
//    Table t = new Table();
//    t.add(c1);
//    t.add(c2);
//    t.add(c3);
//    
//    assertEquals("1GOO", t.getCard(1).toString());
//  }
  public void testGetCardsFalse(){
    Card c1 = new Card(1,2,3,1);
    Card c2 = new Card(1,2,2,1);
    Card c3 = new Card(1,2,1,1);
    
    Table t = new Table();
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals(null, t.getCard(5));
  }
  public void testNumSets(){
    Card c1 = new Card(1,2,3,1);
    Card c2 = new Card(1,2,2,1);
    Card c3 = new Card(1,2,1,1);
    Card c4 = new Card(2,1,3,1);
    Card c5 = new Card(2,1,2,2);
    Card c6 = new Card(3,3,3,1);
    
    Table t = new Table();
    t.add(c1);
    t.add(c2);
    t.add(c3);
    t.add(c4);
    t.add(c5);
    t.add(c6);
    
    assertEquals(2, t.numSets());
  }
  
  
  
}
