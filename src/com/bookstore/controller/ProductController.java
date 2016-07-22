package com.bookstore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.model.Customer;
import com.bookstore.model.Product;
import com.bookstore.model.Users;
import com.bookstore.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @RequestMapping("/productList")
	    public String getProductByCategory( Model model){
		
	        List<Product> products = productService.getProductList();
	        for(int i=0;i<products.size();i++)
	        {
	        	System.out.println("product>>"+products.get(i));
	        }
	        model.addAttribute("products", products);
	        
	       // model.addAttribute("searchCondition", searchCondition);

	        return "productList";
	    }

	 
	 
	 @RequestMapping("/productList/all")
	    public String getProducts(Model model,HttpSession session){
		 
		   if(session.getAttribute("user")==null)
		   {
			   
			  return "redirect:/login";
		   }
	        List<Product> products = productService.getProductList();
	        model.addAttribute("products", products);
           
	        return "productList";
	    }

	    @RequestMapping("/viewProduct/{productId}")
	    public String viewProduct(@PathVariable int productId, Model model,HttpServletRequest request) throws IOException{
	        Product product = productService.getProductById(productId);
	        model.addAttribute("product", product);
	        String Msg =(String)request.getAttribute("cartMsg");
      	  System.out.println("cartMsg"+Msg);
          if((String)request.getAttribute("cartMsg")!=null)
          {
        	  String cartMsg =(String)request.getAttribute("cartMsg");
        	  System.out.println("cartMsg"+cartMsg);
        	  model.addAttribute("cartMsg",cartMsg);
          }
          
	        return "viewProduct";
	    }


}
