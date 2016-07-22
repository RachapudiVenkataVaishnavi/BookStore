package com.bookstore.service.impl;


import com.bookstore.dao.CartItemDao;
import com.bookstore.model.Cart;
import com.bookstore.model.CartItem;
import com.bookstore.service.CartItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }

    public List<CartItem> getCartItemByCartId(int cartId)
    {
    	return cartItemDao.getCartItemByCartId(cartId);
    }
    
   public CartItem getCartItemByCartItemId(int cartItemId)
   {
	   return cartItemDao.getCartItemByCartItemId(cartItemId);
   }
} // The End of Class;
