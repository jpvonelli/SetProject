public class Table {
  private TableNode head;
  private int length;
  
  public Table() {
    //initialize head
    head = null;
  }
  
  public void add(Card card) {
    TableNode newNode = new TableNode(card);
    newNode.setNext(head);
    head = newNode;
  }
  
  private boolean onTable(Card c){
    TableNode curr = head;
    
    while(curr != null){
      if(c.equals(curr.getCard())){
        return true;
      }
      else{
        curr = curr.getNext();
      }
    }
    return false;
  }
  private void removeCard(Card c){
    TableNode curr = head;
    TableNode prev = null;
    if(head == null)
      return;
    while(curr != null){
      if(!c.equals(curr.getCard()))
        curr.getNext();
      else{
        if(curr == head)
          head = head.getNext();
        else
          prev.setNext(curr.getNext());
      }
      prev = curr;
      curr = curr.getNext();
    }
  }
    
      
  
  public void removeSet(Card c1, Card c2, Card c3) {
    //if 3 cards dont form a set or if any of the cards are not on the table,
    // return.
    //otherwise:
    // remove c1, c2, and c3 preserving the relative order of the rest of the cards.
    if(c1.isSet(c2, c3) == false)
      return;
    if(!onTable(c1))
      return;
    if(!onTable(c2))
      return;
    if(!onTable(c3))
      return;
    removeCard(c1);
    removeCard(c2);
    removeCard(c3);
 
  }
        
  
  public int numCards(){
    //if we havent stored the length of the list, we have to iterate through the
    //list and count the cards.
    TableNode temp = head;
    length = 0;
    if(head == null)
      return 0;
    while(temp != null)
    {
      length++;
      temp = temp.getNext();
    }
    return length;
  }
  
  public Card getCard(int index) {
    //if index is out of bounds, return null.
    //otherwise:
    // iterate through the list index number of times,
    // return the node there
    TableNode curr = head;
    if(head == null)
      return null;
    if(index < numCards())
    {
      for(int i = 0; i<index;i++)
      {
        curr = curr.getNext();
      }
      return curr.getCard();
    }
    else
      return null;
  }
  
  public int numSets() {
    //get all triples of cards on the table, and check isSet(). Create a counter and
    //everytime isSet() == true, update the counter by 1.
    TableNode a = head;
    TableNode b = null;
    TableNode c = null;
    int numSets = 0;
    
    if(head == null)
      return 0;
    
    while(a != null && a.getNext() != null && a.getNext().getNext() != null){
      b = a.getNext();
      while(b != null && b.getNext() != null){
        c = b.getNext();
        while(c != null){
          if(a.getCard().isSet(b.getCard(),c.getCard()))
            numSets++;
          c = c.getNext();
        }
        b = b.getNext();
      }
      a = a.getNext();
    }
    return numSets;
  }
          
          
    
  }