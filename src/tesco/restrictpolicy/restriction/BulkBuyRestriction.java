package tesco.restrictpolicy.restriction;

import tesco.restrictpolicy.model.BasketProduct;

public class BulkBuyRestriction implements Restriction{

  int allowedQuantity;

  public BulkBuyRestriction(int allowedQuantity) {
    this.allowedQuantity = allowedQuantity;
  }

  @Override
  public boolean checkRestriction(BasketProduct basketProduct) {
    return basketProduct.getQuantity() < allowedQuantity;
  }
}
