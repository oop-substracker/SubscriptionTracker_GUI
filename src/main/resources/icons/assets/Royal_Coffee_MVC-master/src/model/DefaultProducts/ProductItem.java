package model.DefaultProducts;

import javax.swing.*;
import java.awt.*;

public class ProductItem {
    private String productName;
    private double price;
    private Image imagePath;

    public ProductItem(String productName, double price, Image imagePath) {
        this.productName = productName;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Image getImagePath() {
        return imagePath;
    }

    public void setImagePath(Image imagePath) {
        this.imagePath = imagePath;
    }
}
