import junit.framework.TestCase;

public class testDeck extends TestCase {
  
  public void testHasNextGetNext0Par() {
    // Tests Deck() with hasNext() and getNext
    Deck d = new Deck();
    Card c;
    int sumQuan = 0;
    int sumCo = 0;
    int sumShade = 0;
    int sumShape = 0;
    int sumWhole = 0;
    int total = 0;
    while(d.hasNext()){
      c = d.getNext();
      sumQuan += c.getQuantity();
      sumCo += c.getColor();
      sumShade += c.getShading();
      sumShape += c.getShape();
      total++;
    }
    sumWhole = sumQuan + sumCo + sumShade + sumShape;
    assertEquals(162, sumQuan);
    assertEquals(162, sumCo);
    assertEquals(162, sumShade);
    assertEquals(162, sumShape);
    assertEquals(648, sumWhole);
    assertEquals(81, total);
  }
  public void testDeckHasGetNextDat(){
    // Tests hasNext() and getNext() methods with Deck(file.dat)
    Deck d = new Deck("3cardNew.dat");
    
    assertEquals(true, d.hasNext());
    assertEquals("1GSO", d.getNext().toString());
    assertEquals(true, d.hasNext());
    assertEquals("2RTS", d.getNext().toString());
    assertEquals(true, d.hasNext());
    assertEquals("3RTO", d.getNext().toString());
    assertEquals(false, d.hasNext());
  }
}
