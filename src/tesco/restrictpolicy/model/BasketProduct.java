package tesco.restrictpolicy.model;

public class BasketProduct {

  String productId;
  Long quantity;

  ProductCategory category;

  public String getProductId() {
    return productId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public ProductCategory getCategory() {
    return category;
  }
}
