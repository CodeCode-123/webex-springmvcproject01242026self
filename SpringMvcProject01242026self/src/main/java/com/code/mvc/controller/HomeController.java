package com.code.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.services.CategoryService;
import com.code.mvc.services.ItemService;
import com.code.mvc.entity.*;
import com.code.mvc.model.Cart;
import com.code.mvc.model.CartCollection;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ItemService itemService;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response, Model model) throws IOException{
		// get all the categories
		List<Category> categories = categoryService.getAll();
		// get all the items
		List<Item> items = itemService.getAll();
		// add the objects to the model
		model.addAttribute("items", items);
		model.addAttribute("categories", categories);
		return new ModelAndView("home", "", model);
	}
	@RequestMapping("/carts")
	public ModelAndView cart(HttpServletResponse response) throws IOException{
		return new ModelAndView("carts");
	}
	//login.jsp has be replaced by adminlogin.jsp
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	@RequestMapping("/authentication")
	public ModelAndView login_Authentication(HttpServletRequest request, Model model) {
		// request has method getParameter(<name of form element> returns the value as string)
		String username=request.getParameter("uname");
		String password=request.getParameter("upass");
		System.out.println("User Name: " + username);
		System.out.println("Password: " + password);
		// check if the username = Admin and the password = 1234
		if (username.equals("Admin") && password.equals("1234")) {
			model.addAttribute("uname",username);
			return new ModelAndView("dashboard","",model);
		}
		String msg="Invalid User name & password";
		model.addAttribute("error", msg);
		return new ModelAndView("login","",model);
	} 
	@RequestMapping(value="/item/cart/{id}")
	public ModelAndView addToCart(@PathVariable("id") int id, Model model, HttpSession session) {
		// get the item with id
		Item item = itemService.getById(id);
		if (item != null) {
			Cart cart = new Cart();
			cart.setCategoryId(item.getCategory().getCategoryId());
			cart.setCategoryName(item.getCategory().getCategoryName());
			cart.setItemId(id);
			cart.setItemName(item.getItemName());
			cart.setPrice(item.getItemPrice());
			cart.setQty(1);
			// add the cart to my collection
			// we create the object of the collection put it into the session
			// first check the collection object is in session
			CartCollection cartCollection = null;
			if (session.getAttribute("cartCollection")==null) {
				cartCollection = new CartCollection();
			} else {
				cartCollection = (CartCollection) session.getAttribute("cartCollection");
			}
			// we have to add the cart object to the collection object
			cartCollection.addToCart(cart);
			session.setAttribute("cartCollection", cartCollection);
			model.addAttribute("carts", cartCollection.getAll());
			model.addAttribute("totalAmount", cartCollection.getTotalAmount());
			return new ModelAndView("carts","",model);
		}
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/item/cart/update", method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, Model model, HttpSession session) {
		int qty = Integer.parseInt(request.getParameter("qty[]").toString());
		int id = Integer.parseInt(request.getParameter("itemId").toString());
		CartCollection cartCollection = null;
		if (session.getAttribute("cartCollection")==null) {
			// create a new object
			cartCollection = new CartCollection();
		} else {
			cartCollection = (CartCollection) session.getAttribute("cartCollection");
		}
		Cart cart = cartCollection.getCartById(id);
		if (cart != null) {
			cart.setQty(qty);
			// update the cart
			cartCollection.updateCart(cart);
			session.setAttribute("cartCollection", cartCollection);
			model.addAttribute("carts", cartCollection.getAll());
			model.addAttribute("totalAmount", cartCollection.getTotalAmount());
			return new ModelAndView("carts","",model);
		}
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/image/{id}")
	public void getImage(@PathVariable("id") int id, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		Item item = itemService.getById(id);
		if (item != null && item.getImageData() != null) {
			response.setContentType("image/jpeg");
			response.getOutputStream().write(item.getImageData());
			response.getOutputStream().flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
