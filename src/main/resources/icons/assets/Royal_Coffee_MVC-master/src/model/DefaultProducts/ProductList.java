package model.DefaultProducts;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList {
    private static final List<ProductItem> productList = new ArrayList<>();

    public ProductList() {

        initDefaultProducts();
    }

    private void initDefaultProducts() {
        productList.add(createProduct("Cold coffee", 3.0, "coldcoffee.jpg"));
        productList.add(createProduct("Cappuccino Coffee", 5.0, "cappuccinocoffee.jpg"));
        productList.add(createProduct("Chocolate coffee", 3.0, "chocolatecoffee.jpg"));
        productList.add(createProduct("Green Tea", 4.0, "greentea.jpg"));
        productList.add(createProduct("Mineral Water Tea", 4.0, "mineralswater.png"));
        productList.add(createProduct("Strawberry Cake", 4.0, "strawberrycake.jpg"));
        productList.add(createProduct("Chocolate Cake", 4.0, "chocolatecake.jpg"));
        productList.add(createProduct("Fruits Cake", 4.0, "fruitscake.jpg"));
        productList.add(createProduct("Rainbow Cake", 4.0, "rainbow.jpg"));
        productList.add(createProduct("Coca Cola", 4.0, "coke.jpg"));
        productList.add(createProduct("Vegetable Pizza", 4.0, "vegetarianpizza.jpg"));
        productList.add(createProduct("Chicken Burger", 4.0, "chickenburger.jpg"));
        productList.add(createProduct("Chicken Noodles", 4.0, "chickennoodles.jpg"));
        productList.add(createProduct("7 UP", 4.0, "7up.jpg"));
        productList.add(createProduct("Orange Juice", 4.0, "orange_juice.jpg"));
    }

    private ProductItem createProduct(String name, double price, String imagePath) {
        ImageIcon image = new ImageIcon((Objects.requireNonNull(getClass().getResource(imagePath))));

        return new ProductItem(name, price, image.getImage().getScaledInstance(300, 180, Image.SCALE_SMOOTH));
    }

    public static List<ProductItem> getProductList() {
        return productList;
    }
}
