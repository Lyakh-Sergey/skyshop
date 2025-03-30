package org.skypro.skyshop.product.fixpriceproduct;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private final static int FIXED_PRICE = 99;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
