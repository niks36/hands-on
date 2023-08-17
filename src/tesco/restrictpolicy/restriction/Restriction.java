package tesco.restrictpolicy.restriction;

import tesco.restrictpolicy.model.BasketProduct;

public interface Restriction {

    boolean checkRestriction(BasketProduct basketProduct);
}
