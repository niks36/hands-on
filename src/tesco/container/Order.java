package tesco.container;

import java.util.List;

public class Order {

  List<BasketProduct> list;

  public Long getTotalVolume(){
   return  list.stream().map(BasketProduct::getProductVolume).reduce(0L, Long::sum);
  }
}
