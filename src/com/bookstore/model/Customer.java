package com.bookstore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bookstore.model.BillingAddress;
import com.bookstore.model.Cart;
import com.bookstore.model.ShippingAddress;





@Entity
public class Customer implements Serializable {
	 

	    @Id
	    @GeneratedValue
	    private int customerId;

	    

		@NotEmpty
	    private String customerName;

	    @NotEmpty
		@Pattern(regexp=".*\\@.*\\..*", message="This does not appear to be a valid email address")
	    private String customerEmail;
	    

		@NotEmpty
	    private String customerPhone;

	    @NotEmpty
	    private String username;

	    @NotEmpty
	    private String password;
	    
	 
	    private boolean enabled;

		
	    @OneToOne
	    @JoinColumn(name = "billingAddressId")
	    private BillingAddress billingAddress;

		
	    @OneToOne
	    @JoinColumn(name = "shippingAddressId")
	    private ShippingAddress shippingAddress;
	    
	    @OneToOne
	    @JoinColumn(name = "cartId")
	    private Cart cart;

        public Customer() {
			
		}
        
      

	    



		public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int cutomerId) {
	        this.customerId = cutomerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getCustomerEmail() {
	        return customerEmail;
	    }

	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }

	    public String getCustomerPhone() {
	        return customerPhone;
	    }

	    public void setCustomerPhone(String customerPhone) {
	        this.customerPhone = customerPhone;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public boolean isEnabled() {
	        return enabled;
	    }

	    public void setEnabled(boolean enabled) {
	        this.enabled = enabled;
	    }


	    

		public BillingAddress getBillingAddress() {
	        return billingAddress;
	    }

	    public void setBillingAddress(BillingAddress billingAddress) {
	        this.billingAddress = billingAddress;
	    }

	    public ShippingAddress getShippingAddress() {
	        return shippingAddress;
	    }

	    public void setShippingAddress(ShippingAddress shippingAddress) {
	        this.shippingAddress = shippingAddress;
	    }

	    public Cart getCart() {
	        return cart;
	    }

	    public void setCart(Cart cart) {
	        this.cart = cart;
	    }

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
					+ customerEmail + ", customerPhone=" + customerPhone + ", username=" + username + ", password="
					+ password + ", enabled=" + enabled + ", billingAddress=" + billingAddress + ", shippingAddress="
					+ shippingAddress + ", cart=" + cart + "]";
		}
	   
	    

}
