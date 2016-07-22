package com.bookstore.service;


import java.util.List;

import com.bookstore.model.Cart;
import com.bookstore.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
    
    public List<CartItem> getCartItemByCartId(int cartId);
    
     CartItem getCartItemByCartItemId(int cartItemId);
}
