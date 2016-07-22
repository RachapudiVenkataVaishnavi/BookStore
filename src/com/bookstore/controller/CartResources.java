package com.bookstore.controller;

import com.bookstore.model.Cart;
import com.bookstore.model.CartItem;
import com.bookstore.model.Customer;
import com.bookstore.model.Product;
import com.bookstore.model.Users;
import com.bookstore.service.CartItemService;
import com.bookstore.service.CartService;
import com.bookstore.service.CustomerService;
import com.bookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

 
    
    @RequestMapping(value = "/add/{productId}")
   public String addItem (@PathVariable(value = "productId") int productId,Model model,HttpServletRequest request,HttpSession session){
    	System.out.println("add cart>>>>>>"+productId);
    	Users user = (Users)session.getAttribute("user");
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i=0; i < cartItems.size(); i++){
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
             
                request.setAttribute("cartMsg","Product Successfully added to cart");
                return "forward:/product/viewProduct/" + product.getProductId();
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        request.setAttribute("cartMsg","Product Successfully added to cart");
        return "forward:/product/viewProduct/" + product.getProductId();
    }

    


    @RequestMapping(value = "/clearCart/{cartId}")
    public String clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
        return "redirect:/customer/cart/"+cartId;
    }
   


} // The End of Class;
