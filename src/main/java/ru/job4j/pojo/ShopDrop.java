package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null && (i + 1) < products.length) {
              products[i] = products[i + 1];
              products[i + 1] = null;
            }
        }
        return products;
    }
}
