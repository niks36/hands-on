package tesco.container;

public class BasketProduct {

  Long id;
  Long quantity;
  ProductDetails details;

  public Long getProductVolume(){
    return quantity * details.volume();
  }
}

