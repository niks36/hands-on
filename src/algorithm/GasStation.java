package algorithm;

public class GasStation {

  public static void main(String[] args){
    GasStation gasStation = new GasStation();
    gasStation.canCompleteCircuit(new int[]{2,3,4,5,1}, new int[]{4,5,1,2,3});
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int currRemaining = 0;
    int totalRemaining = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i ++){
      int remaining = gas[i] - cost[i];
      if (currRemaining < 0){
        start = i;
        currRemaining = remaining;
      }
      else{
        currRemaining += remaining;
      }
      totalRemaining += remaining;
    }//for i
    if (totalRemaining < 0)
      return -1;
    else
      return start;
  }
}
