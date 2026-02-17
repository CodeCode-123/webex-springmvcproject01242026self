package com.code.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping(value="/cart/{id}")
	public ModelAndView addToCart(@PathVariable("id") int id, Model model) {
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
			CartCollection cartCollection = (CartCollection) model.getAttribute("cartCollection");
			if (cartCollection == null) {
				cartCollection = new CartCollection();
			}
			cartCollection.addToCart(cart);
			model.addAttribute("cartCollection", cartCollection);
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
