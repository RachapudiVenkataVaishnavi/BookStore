package com.bookstore.dao;


import java.util.List;

import com.bookstore.model.Cart;
import com.bookstore.model.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
    
   List<CartItem> getCartItemByCartId(int cartId);
   
    CartItem getCartItemByCartItemId(int cartItemId);
}
