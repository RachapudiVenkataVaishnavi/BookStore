package com.bookstore.controller;

import com.bookstore.model.Cart;
import com.bookstore.model.Customer;
import com.bookstore.model.CustomerOrder;
import com.bookstore.service.CartService;
import com.bookstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId,Model model){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        
        customerOrderService.addCustomerOrder(customerOrder);

        model.addAttribute("order",customerOrder);
        model.addAttribute("cartId",cartId);
      //  return "redirect:/checkout?cartId=" + cartId;
        
        return "orderConfirmation";

    }
    
    @RequestMapping("/checkout/{cartId}")
    public String checkOut(@PathVariable("cartId") int cartId){
        return null;

    }
    
    @RequestMapping("/order/submitOrder")
    public String submitOrder(){
    	System.out.println("in bye");
        return "thankCustomer";

    }


} // The End of Class;
