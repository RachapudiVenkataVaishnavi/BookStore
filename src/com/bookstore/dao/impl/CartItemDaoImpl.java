package com.bookstore.dao.impl;

import com.bookstore.dao.CartItemDao;
import com.bookstore.model.Cart;
import com.bookstore.model.CartItem;
import com.bookstore.model.Customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
    	System.out.println("add cart");
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart){
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int productId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
    
    public CartItem getCartItemByCartItemId(int cartItemId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cartItemId = ?");
        query.setInteger(0, cartItemId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
    
    public List<CartItem> getCartItemByCartId(int cartId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where cartId = ?");
        query.setInteger(0, cartId);
        session.flush();

        List<CartItem> cartItemList = query.list();

        return cartItemList;
    }

} // The End of Class;
