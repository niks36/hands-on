package tesco.minprice;

public class Product {
  Long id;

  int[] prices;

  private int lowestPrice(){
    int index = 0;
    int lowestPrice = prices[0];

    for(int i = 0; i<prices.length; i++){
      if(lowestPrice > prices[i]){
        lowestPrice = prices[i];
        index = i;
      }
    }
    return index;
  }
}
