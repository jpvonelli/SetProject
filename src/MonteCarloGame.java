public class MonteCarloGame{
  public static void main(String[] args){
    int setTotal = 0;
    int numCardEndTotal = 0;
    for(int x = 0; x < 1000000; x++){
      Game g = new Game();
      setTotal += g.numSets();
      while(!g.isGameOver()){
        g.playRound();
      }
      numCardEndTotal += g.numCards();
    }
    System.out.println("Finished");
    System.out.println("numSets at beginning: " + setTotal);
    System.out.println("numCardEndTotal at end: " + numCardEndTotal);
  }
}
      