public class MonteCarloGame{
  public static void main(String[] args){
    float setTotal = 0;
    float numCardEndTotal = 0;
    for(int x = 0; x < 1000000; x++){
      Game g = new Game();
      setTotal += g.numSets();
      while(!g.isGameOver()){
        g.playRound();
      }
      numCardEndTotal += g.numCards();
    }
    setTotal = setTotal / 1000000;
    numCardEndTotal = numCardEndTotal / 1000000;
    System.out.println("Finished");
    System.out.println("Average numSets at beginning: " + setTotal);
    System.out.println("Average numCardEndTotal at end: " + numCardEndTotal);
  }
}
      