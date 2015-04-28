public class Game {
  Table t;
  Deck d;
  
  public Game(){
    //initializes deck and puts 12 cards on the table.  For loop, adding one card each to the table (head insertion).
    d = new Deck();
    t = new Table();
    for(int i = 0; i<12; i++){
      t.add(d.getNext());
    }
      
  }
  
  public Game(String filename){
    int count = 0;
    d = new Deck(filename);
    t = new Table();
    while(d.hasNext() != false && count != 12){
      count ++;
      t.add(d.getNext());
    }
  }
  
  public int numSets(){
    // return numSets through table class method
    return t.numSets();
    
  }
  
  public int numCards(){
    // return numCards through deck class method
    return t.numCards();
  }
  
  public void playRound(){
    // removes a set, uses getCard from table and then uses isSet from Card
    // Check 0,1,2 then 0,1,3 and so on, so then when you start again it'll be 0,2,3, then 0,2,4.
    // Very similar to the triple loop used in numSets method in table
    // When true, removeSet from Table method, then add 3 more cards from deck
    // When there are no sets, add 3 more cards
    // When there are no more cards in the deck, but there are more sets on table, just remove sets and dont add more cards
    // When there are no cards in deck and no sets on the table, game is over.
    // Only add cards to the table when there are less than 12 cards, and if there are cards in the deck
    
    if(t.numSets() != 0){
      for (int a = 0; a < t.numCards() - 2; a++) {
        for (int b = a + 1; b < t.numCards() - 1; b++) {
          for (int c = b + 1; c < t.numCards(); c++) {
            if(t.getCard(a).isSet(t.getCard(b), t.getCard(c))){
              t.removeSet(t.getCard(a), t.getCard(b), t.getCard(c));
              if(t.numCards() <= 9){
                if(d.hasNext()){
                  t.add(d.getNext());
                }
                if(d.hasNext()){
                  t.add(d.getNext());
                }
                if(d.hasNext()){
                  t.add(d.getNext());
                }
              }
              return;
            }
          }
        }
      }
    }
    if(t.numSets() == 0){
      if(d.hasNext()){
        t.add(d.getNext());
      }
      if(d.hasNext()){
        t.add(d.getNext());
      }
      if(d.hasNext()){
        t.add(d.getNext());
      }
    }
  }

    
  public boolean isGameOver(){
    // numSets to check if the game is over when there are no more cards in the deck and no sets on the table
    if(t.numSets() == 0 && d.hasNext() == false){
      return true;
    }
    else{
      return false;
    }
  }
}