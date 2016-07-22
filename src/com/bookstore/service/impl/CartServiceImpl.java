package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.service.CartService;
import com.bookstore.dao.CartDao;
import com.bookstore.model.Cart;
@Service
public class CartServiceImpl implements CartService {
	
	 @Autowired
	    private CartDao cartDao;

	    public Cart getCartById(int cartId){
	        return cartDao.getCartById(cartId);
	    }

	    public void update(Cart cart){
	        cartDao.update(cart);
	    }

}
