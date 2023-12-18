package controller;

import model.CartDetails.CartItem;
import model.CartDetails.CartList;
import model.DefaultProducts.ProductItem;
import view.components.Sidebar;
import view.MainFrame;
import view.components.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {

    MainFrame mainFrame;
    Menu menu;
    Sidebar sidebar;
    // business data logic
    CartList cartList;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.menu = mainFrame.getMenu();
        this.sidebar = mainFrame.getSidebar();
        this.cartList = new CartList();

        menu.addRadioListener(new ListenToClick());
    }

    class ListenToClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Access the selected item from the menu
            if (e.getSource() instanceof ProductItem) {
                ProductItem selectedProduct = (ProductItem) e.getSource();
                int quantity = Integer.parseInt(e.getActionCommand());
                CartItem item = new CartItem(selectedProduct.getProductName(), selectedProduct.getPrice(), selectedProduct.getImagePath(), quantity);
                cartList.addToCart(item);
                sidebar.updateOrders(cartList.getCartList());
            }
        }
    }

}
