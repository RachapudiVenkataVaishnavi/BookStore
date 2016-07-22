package com.bookstore.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.model.BillingAddress;
import com.bookstore.model.Customer;
import com.bookstore.model.ShippingAddress;
import com.bookstore.model.Users;
import com.bookstore.service.CustomerService;

@Controller
public class RegisterController {
	
	 @Autowired
	 private CustomerService customerService;
	
	 @RequestMapping("/register")
	    public String registerCustomer(Model model){
		 Customer customer = new Customer();
	        BillingAddress billingAddress = new BillingAddress();
	        ShippingAddress shippingAddress = new ShippingAddress();
	        customer.setBillingAddress(billingAddress);
	        customer.setShippingAddress(shippingAddress);

	        model.addAttribute("customer", customer);
	      
           return "registerCustomer";
	    }
	 
	 
	 @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){

	        if(result.hasErrors()){
	        	System.out.println("has errors");
	            return "registerCustomer";
	        }
	        
	        System.out.println("has errors postttt");
	        System.out.println("cutomer>>>"+customer);

	        ArrayList customerList = new ArrayList();
	        customerList=	customerService.getAllCustomers();
            if(customerList!=null && !customerList.isEmpty() )
            {
	        for (int i=0; i< customerList.size(); i++){
	            if(customer.getCustomerEmail().equals((String)((Customer) customerList.get(i)).getCustomerEmail())){
	                model.addAttribute("emailMsg", "Email already exists");

	                return "registerCustomer";
	            }

	            if(customer.getUsername().equals((String)((Customer) customerList.get(i)).getUsername())){
	                model.addAttribute("usernameMsg", "Username already exists");

	                return "registerCustomer";
	            }
	        }
            }
	 customer.setEnabled(true);
     customerService.addCustomer(customer);
	        return "registerCustomerSuccess";
	    }
	 @RequestMapping(value="/loginCheck",method = RequestMethod.POST)
	 public String validateUser(Model model,@Valid @ModelAttribute("user") Users user,BindingResult result,HttpSession session)
	 {
		 if(result.hasErrors()){
	        	System.out.println("has errors");
	            return "login";
	        }
		 
		 System.out.println("user.getUsername()>>>>"+user.getUsername());
		 if(user.getUsername()=="admin" || user.getUsername().equals("admin"))
		 {
			 session.setAttribute("user",user);
			 return "redirect:/admin";
		 }
		Customer customer= customerService.getCustomerByUsernameAndPassword(user.getUsername(), user.getPassword());

		if(customer!=null)
		{
			session.setAttribute("user",user);
		return "redirect:/product/productList";
		}
		else
		{
			model.addAttribute("logincheckMsg","Invalid Credentials");
			return "login";
		}
		 
	 }

}
