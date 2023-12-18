package model.CartDetails;

import model.CartDetails.CartItem;
import java.util.List;
import java.util.ArrayList;

public class CartList {
    private List<CartItem> cartList;

    public CartList() {
        cartList = new ArrayList<>();
    }

    public void addToCart(CartItem cartItem) {
        cartList.add(cartItem);
    }

    public List<CartItem> getCartList() {
        return cartList;
    }
}
