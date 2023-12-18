package model.CartDetails;

import java.awt.*;

public class CartItem {
    private String productName;
    private double price;
    private Image imagePath;
    private int quantity;

    public CartItem(String productName, double price, Image imagePath, int quantity) {
        this.productName = productName;
        this.price = price;
        this.imagePath = imagePath;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
