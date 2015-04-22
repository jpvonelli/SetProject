public class Game {
  Table t = new Table();
  Deck d = new Deck();
  
  public void Game(){
    //initializes deck and puts 12 cards on the table.  For loop, adding one card each to the table (head insertion).
  }
  
  public void Game(String filename){
    
  }
  
  public int numSets(){
    // return numSets through table class method
    return 0;
    
  }
  
  public int numCards(){
    // return numCards through deck class method
    return 0;
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
  }
  
  public boolean isGameOver(){
    // numSets to check if the game is over when there are no more cards in the deck and no sets on the table
    return true;
  }
}