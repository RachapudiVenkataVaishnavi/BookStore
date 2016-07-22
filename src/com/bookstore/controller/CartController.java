package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.model.CartItem;
import com.bookstore.model.Customer;
import com.bookstore.model.Users;
import com.bookstore.service.CartItemService;
import com.bookstore.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping
    public String getCart(HttpSession session){
    	Users user = (Users)session.getAttribute("user");
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        System.out.println("in get cart");
        int cartId = customer.getCart().getCartId();
        System.out.println("cartId>>>>"+cartId);
        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);
        System.out.println("cartId>>>>>>>>>>>>>>>>>>>>>>>>>"+cartId);
        List<CartItem>  cartItemList =cartItemService.getCartItemByCartId(cartId);
        double grandTotal = 0;
        for(int i=0;i<cartItemList.size();i++)
        {
         CartItem cartItem=	(CartItem)cartItemList.get(i);
         System.out.println("cartitemsss...."+cartItem);
         System.out.println("cartitemsss.pro id..."+cartItem.getProduct().getProductId());
         System.out.println("cartitemsss.pro id..."+cartItem.getProduct().getProductName());
         System.out.println("cartitemsss.pro id..."+cartItem.getProduct().getProductPrice());
         System.out.println("cartitemsss..cart id.."+cartItem.getCart().getCartId());
         grandTotal=grandTotal+cartItem.getTotalPrice();
        }
       

        model.addAttribute("grandTotal",grandTotal);
        model.addAttribute("cartItemList",cartItemList);
        return "cart";
    }
    
    @RequestMapping("/removeFromCart/{cartItemId}")
    public String removeFromCart(@PathVariable (value = "cartItemId")  int cartItemId, Model model){
      System.out.println("cartItemId"+cartItemId);
      CartItem cartItem =cartItemService.getCartItemByCartItemId(cartItemId);
      int cartId =cartItem.getCart().getCartId();
      System.out.println("cartId>>>>>>>>>:::::::"+cartId);
      cartItemService.removeCartItem(cartItem);
      System.out.println("2222222222222222222cartId>>>>>>>>>:::::::"+cartId);
      return "redirect:/customer/cart/"+cartId;
    }


}
