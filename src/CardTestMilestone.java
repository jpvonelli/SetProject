import junit.framework.TestCase;

public class CardTestMilestone extends TestCase {
  
  /* 
   * This helper method makes sure a card has the values specified.
   */
  public void assertCardEqual(Card c, int quantity, int color,
                              int shading, int shape)
  {
    assertEquals(quantity, c.getQuantity());
    assertEquals(color, c.getColor());
    assertEquals(shading, c.getShading());
    assertEquals(shape, c.getShape());
  }

  /* 
   * This helper method makes sure a card has the values specified, or valid
   * values for categories with a 0 value specified.
   */
  public void assertCardValid(Card c, int quantity, int color, int shading,
                              int shape)
  {
    int[] cValues = {c.getQuantity(), c.getColor(), c.getShading(),
                     c.getShape()};
    int[] values = {quantity, color, shading, shape};

    for(int i = 0; i < values.length; i++) {
      if(values[i] == 0)
        assertTrue(cValues[i] >= 1 && cValues[i] <=3);
      else
        assertEquals(values[i], cValues[i]);
    }
  }
  
  public void testInRangeCards() 
  {
    for(int q = 1; q < 4; q++)
    {
      for(int c = 1; c < 4; c++)
      {
        for(int d = 1; d < 4; d++)
        {
          for(int s = 1; s < 4; s++)
          {
            Card card = new Card(q, c, d, s);
            assertCardEqual(card, q, c, d, s);
          }
        }
      }
    }
  }
  
  public void testQuantityValid()
  {
    Card c;

    c = new Card(5, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);

    c = new Card(49, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);

    c = new Card(51, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);

    c = new Card(-1, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);

    c = new Card(-11, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);

    c = new Card(-12, 1, 1, 1);
    assertCardValid(c, 0, 1, 1, 1);
  }
  
  public void testColorValid()
  {
    Card c;

    c = new Card(1, 5, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);

    c = new Card(1, 49, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);

    c = new Card(1, 51, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);

    c = new Card(1, -1, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);

    c = new Card(1, -11, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);

    c = new Card(1, -12, 1, 1);
    assertCardValid(c, 1, 0, 1, 1);
  }
  
  public void testShadingValid()
  {
    Card c;

    c = new Card(1, 1, 5, 1);
    assertCardValid(c, 1, 1, 0, 1);

    c = new Card(1, 1, 49, 1);
    assertCardValid(c, 1, 1, 0, 1);

    c = new Card(1, 1, 51, 1);
    assertCardValid(c, 1, 1, 0, 1);

    c = new Card(1, 1, -1, 1);
    assertCardValid(c, 1, 1, 0, 1);

    c = new Card(1, 1, -11, 1);
    assertCardValid(c, 1, 1, 0, 1);

    c = new Card(1, 1, -12, 1);
    assertCardValid(c, 1, 1, 0, 1);
  }
  
  public void testShapeValid()
  {
    Card c;

    c = new Card(1, 1, 1, 5);
    assertCardValid(c, 1, 1, 1, 0);

    c = new Card(1, 1, 1, 49);
    assertCardValid(c, 1, 1, 1, 0);

    c = new Card(1, 1, 1, 51);
    assertCardValid(c, 1, 1, 1, 0);

    c = new Card(1, 1, 1, -1);
    assertCardValid(c, 1, 1, 1, 0);

    c = new Card(1, 1, 1, -11);
    assertCardValid(c, 1, 1, 1, 0);

    c = new Card(1, 1, 1, -12);
    assertCardValid(c, 1, 1, 1, 0);
  }
  
  public void testIsSetSameSameSameDifferent()
  {
    // same, same, same, different
    Card c1 = new Card(1, 2, 3, 1);
    Card c2 = new Card(1, 2, 3, 3);
    Card c3 = new Card(1, 2, 3, 2);
    assertTrue(c1.isSet(c2, c3));
    assertTrue(c2.isSet(c1, c3));
    assertTrue(c3.isSet(c2, c1));
  }
  
  public void testIsSetDiffSameSameDiff()
  {
    // different, same, same, different
    Card c1 = new Card(1, 2, 3, 1);
    Card c2 = new Card(2, 2, 3, 3);
    Card c3 = new Card(3, 2, 3, 2);
    assertTrue(c1.isSet(c2, c3));
    assertTrue(c2.isSet(c1, c3));
    assertTrue(c3.isSet(c2, c1));
  }
  
  public void testIsSetDiffDiffSameDiff()
  {
    // different, different, same, different
    Card c1 = new Card(1, 3, 3, 1);
    Card c2 = new Card(3, 2, 3, 3);
    Card c3 = new Card(2, 1, 3, 2);
    assertTrue(c1.isSet(c2, c3));
    assertTrue(c2.isSet(c1, c3));
    assertTrue(c3.isSet(c2, c1));
  }
  
  public void testSetDiffDiffDiffDiff()
  {
    // all different
    Card c1 = new Card(1, 2, 3, 1);
    Card c2 = new Card(2, 3, 2, 3);
    Card c3 = new Card(3, 1, 1, 2);
    assertTrue(c1.isSet(c2, c3));
    assertTrue(c2.isSet(c1, c3));
    assertTrue(c3.isSet(c2, c1));
  }
  
  public void testNoSetQuantity()
  {
    // not a set in quantity
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(2, 3, 1, 1);
    assertFalse(c1.isSet(c2, c3));
    assertFalse(c2.isSet(c3, c1));
    assertFalse(c3.isSet(c2, c1));
  }
  
  public void testNoSetColor()
  {
    // not a set in color
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 2, 1, 1);
    assertFalse(c1.isSet(c2, c3));
    assertFalse(c2.isSet(c3, c1));
    assertFalse(c3.isSet(c2, c1));
  }
  
  public void testNoSetShading()
  {
    // not a set in shading
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 3, 2, 1);
    assertFalse(c1.isSet(c2, c3));
    assertFalse(c2.isSet(c3, c1));
    assertFalse(c3.isSet(c2, c1));
  }
  
  public void testNoSetShape()
  {
    // not a set in shape
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 3, 1, 2);
    assertFalse(c1.isSet(c2, c3));
    assertFalse(c2.isSet(c3, c1));
    assertFalse(c3.isSet(c2, c1));
  }
  
  public void testNoSetAllAttribs()
  {
    // not a set in all 4
    Card c1 = new Card(2, 2, 2, 2);
    Card c2 = new Card(1, 2, 1, 1);
    Card c3 = new Card(1, 3, 1, 2);
    assertFalse(c1.isSet(c2, c3));
    assertFalse(c2.isSet(c3, c1));
    assertFalse(c3.isSet(c2, c1));
  }
  
  public void testToString()
  {
    Card c = new Card(1, 1, 1, 1);
    assertEquals("1ROO", c.toString());
    
    c = new Card(2, 2, 2, 2);
    assertEquals("2GTD", c.toString());
    
    c = new Card(3, 3, 3, 3);
    assertEquals("3PSS", c.toString());
    
    c = new Card(1, 2, 3, 1);
    assertEquals("1GSO", c.toString());
  }
  
  public void testEquals()
  {
    Card c1 = new Card(1, 1, 1, 1);
    Card c2 = new Card(1, 1, 1, 1);
    
    assertTrue(c1 != c2);
    assertTrue(c1.equals(c2));
    assertTrue(c2.equals(c1));
    assertEquals(c1, c2);
    assertEquals(c2, c1);
    
    Card c3 = new Card(2, 2, 2, 2);
    
    assertTrue(c1 != c3);
    assertFalse(c1.equals(c3));
    assertFalse(c3.equals(c1));                
  }
}
