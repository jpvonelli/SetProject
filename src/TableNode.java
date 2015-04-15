public class TableNode{
  private Card card;
  private TableNode next;
  
  public TableNode(Card Card){
    card = Card;
    next = null;
  }
  public void setNext(TableNode insertTableNode){
    next = insertTableNode;
  }
  public TableNode getNext(){
    return next;
    
  }
  public Card getCard(){
    return card;
  }
}