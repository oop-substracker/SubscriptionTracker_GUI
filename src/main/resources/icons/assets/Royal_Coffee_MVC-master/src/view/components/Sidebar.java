package view.components;

import model.CartDetails.CartItem;
import java.awt.*;
import javax.swing.*;
import java.util.List;

public class Sidebar extends JPanel {

    JTextArea orderListViewer;

    public Sidebar() {

        initSidePanel();
        initViewer();
    }

    public void updateOrders(List<CartItem> cartItems) {
        StringBuilder orderText = new StringBuilder();

        // Add header row
        orderText.append(String.format("%-20s%-10s%-10s%n", "Product", "Price", "Quantity\n"));

        // Add cart items
        for (CartItem item : cartItems) {
            orderText.append(String.format("%-20s%-10s%-10s%n",
                    item.getProductName(), item.getPrice(), item.getQuantity()));
        }

        orderListViewer.setFont(new Font("Monospaced", Font.PLAIN, 12));
        orderListViewer.setText(orderText.toString());
    }

    private void initSidePanel() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(300, getHeight()));
    }

    private void initViewer() {
        orderListViewer = new JTextArea(50, 50);
        orderListViewer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        orderListViewer.setPreferredSize(new Dimension(300, 200));
        this.add(orderListViewer, BorderLayout.CENTER);
    }

}
