package tesco.restrictpolicy.restriction;

import java.util.HashMap;
import tesco.restrictpolicy.model.BasketProduct;
import tesco.restrictpolicy.model.ProductCategory;

public class BulkCategoryRestriction implements Restriction{
  
  HashMap<ProductCategory, Integer> categoryIntegerHashMap;

  public BulkCategoryRestriction(HashMap<ProductCategory, Integer> categoryIntegerHashMap) {
    this.categoryIntegerHashMap = categoryIntegerHashMap;
  }

  @Override
  public boolean checkRestriction(BasketProduct basketProduct) {
    Integer allowedQuantityForProductCategory = categoryIntegerHashMap.getOrDefault(basketProduct.getCategory(),
        Integer.MAX_VALUE);
    return basketProduct.getQuantity() < allowedQuantityForProductCategory;
  }
}
