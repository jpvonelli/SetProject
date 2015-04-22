import junit.framework.TestCase;

public class TableTestMilestone extends TestCase
{
  
  public void testConstructorRuns() 
  {
    Table t = new Table();
  }
  
  
  public void testAddRuns()
  {
    Table t = new Table();
    
    t.add(new Card(1, 2, 3, 1));
  }
  
  
  public void testNumCardsNoCards()
  {
    Table t = new Table();
    
    assertEquals(0, t.numCards());
  }
  
  
  public void testNumCardsOneCard()
  {
    Table t = new Table();
    
    t.add(new Card(2, 3, 1, 2));
    
    assertEquals(1, t.numCards());
  }
  
  
  public void testNumCardsTwoCards()
  {
    Table t = new Table();
    
    t.add(new Card(3, 1, 2, 3));
    t.add(new Card(1, 2, 3, 1));
    
    assertEquals(2, t.numCards());
  }
  
  
  public void testGetCardOneCard()
  {
    Table t = new Table();
    
    Card c = new Card(1, 1, 1, 1);
    
    t.add(c);
    
    assertEquals(c, t.getCard(0));
  }
  
  
  public void testGetCardTwoCards()
  {
    Table t = new Table();
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    
    t.add(c1);
    t.add(c2);
    
    assertEquals(c2, t.getCard(0));
    assertEquals(c1, t.getCard(1));
  }
  
  
  public void testGetCardThreeCards()
  {
    Table t = new Table();
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    
    t.add(c1);
    t.add(c2);
    t.add(c3);
    
    assertEquals(c3, t.getCard(0));
    assertEquals(c2, t.getCard(1));
    assertEquals(c1, t.getCard(2));
  }
  
  
  public void testNumSetsEmptyTable()
  {
    Table t = new Table();
    
    assertEquals(0, t.numSets());
  }
  
  
  public void testNumSets3Cards1Set()
  {
    Table t = makeTable("3cards1setMilestone.dat");
    
    assertEquals(1, t.numSets());
  }
  
  
  public void testNumSets3cards0Sets()
  {
    Table t = makeTable("3cards0setsMilestone.dat");
    
    assertEquals(0, t.numSets());
  }
  
  
  public void testNumSets12Cards14Sets()
  {
    Table t = makeTable("12cards14setsMilestone.dat");
    
    assertEquals(14, t.numSets());
  }
  
  
  public void testRemoveSetEmptyTable()
  {
    Table t = new Table();
    
    // Removing a valid set from an empty table shouldn't
    // do anything.
    t.removeSet(new Card(1, 1, 1, 1),
             new Card(2, 2, 2, 2),
             new Card(3, 3, 3, 3));
    
    assertEquals(0, t.numCards());
    assertEquals(0, t.numSets());
  }
  
  
  public void testSmallTable()
  {
    Table t = makeTable("3cards0setsMilestone.dat");
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 2);
    Card c3 = new Card(2, 2, 2, 3);

    assertEquals(3, t.numCards());
    assertEquals(0, t.numSets());
    
    // because we're doing head insertion
    // the Cards are indexed in the reverse
    // order from which they are added
    assertEquals(c3, t.getCard(0));
    assertEquals(c2, t.getCard(1));
    assertEquals(c1, t.getCard(2));
  }
  
  
  public void testSmallTableNoSets()
  {
    Table t = makeTable("3cards0setsMilestone.dat");
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 2);
    Card c3 = new Card(2, 2, 2, 3);

    // trying to remove the cards as a set
    // should do nothing
    t.removeSet(c1, c2, c3);
    
    assertEquals(3, t.numCards());
    assertEquals(0, t.numSets());
    
    assertEquals(c3, t.getCard(0));
    assertEquals(c2, t.getCard(1));
    assertEquals(c1, t.getCard(2));
  }
  
  
  public void testSmallTable1Set()
  {
    Table t = makeTable("3cards1setMilestone.dat");
    
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(2, 2, 2, 2);
    Card c3 = new Card(3, 3, 3, 3);
    
    // This will result in a middle remove, 
    // a tail remove and a head remove
    t.removeSet(c2, c1, c3);
    
    assertEquals(0, t.numCards());
    assertEquals(0, t.numSets());
  } 
  
  
  public void testSetNotOnTable()
  {
    Table t = makeTable("3cards0setsMilestone.dat");
    
    Card c1 = new Card(1, 2, 2, 2);
    Card c2 = new Card(2, 2, 1, 3);
    Card c3 = new Card(3, 2, 3, 1);

    // These cards form a set, but are not on the table
    t.removeSet(c1, c2, c3);
    
    assertEquals(3, t.numCards());
  }
  
  
  public void testNotAllOnTable()
  {
    Table t = makeTable("3cards0setsMilestone.dat");
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 2);
    Card c3 = new Card(1, 1, 1, 3);

    // c1 and c2 are on the table, but c3 is not.  The cards from a set
    t.removeSet(c1, c2, c3);
    
    assertEquals(3, t.numCards());
  }
  
  
  public void testFourteenInTwelve()
  {
    Table t = makeTable("12cards14setsMilestone.dat");
    
    assertEquals(14, t.numSets());
    assertEquals(12, t.numCards());
  }
  
  
  public void testRemoveMiddleMiddleHead()
  {
    Table t = makeTable("12cards14setsMilestone.dat");
    // 1 1 1 3  (3rd to last card)
    // 1 3 1 1  (second card)
    // 1 2 1 2  (first card)
    t.removeSet(new Card(1, 1, 1, 3),
                new Card(1, 3, 1, 1),
                new Card(1, 2, 1, 2));
    
    assertEquals(9, t.numCards());
    // that removed 6 of the 14 sets.
    assertEquals(8, t.numSets());
  }
  
  
  public void testRemoveTailMiddleMiddle()
  {
    Table t = makeTable("12cards14setsMilestone.dat");
    
    // 1 1 1 1 (last card)
    // 1 1 2 1 (middle)
    // 1 1 3 1 (middle)
    t.removeSet(new Card(1, 1, 1, 1),
                new Card(1, 1, 2, 1),
                new Card(1, 1, 3, 1));
    
    assertEquals(9, t.numCards());
  }
  
  
  public void testNoSetsinTwelve()
  {
    Table t = makeTable("12cards0setsMilestone.dat");
    
    assertEquals(12, t.numCards());
    assertEquals(0, t.numSets());
    
    // try to remove first, middle, and last cards
    // which do not form a set so should do nothing
    t.removeSet(new Card(1, 3, 3, 2),
                new Card(1, 3, 1, 3),
                new Card(2, 2, 1, 3));
    
    assertEquals(12, t.numCards());
    assertEquals(0, t.numSets());
  }
  
  private Table makeTable(String filename)
  {
    Deck d = new Deck(filename);
    Table t = new Table();
    
    while(d.hasNext())
      t.add(d.getNext());
    
    return t;
  }
}
