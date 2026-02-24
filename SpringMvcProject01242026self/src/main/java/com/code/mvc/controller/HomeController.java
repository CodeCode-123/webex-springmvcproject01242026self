package com.code.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.services.CategoryService;
import com.code.mvc.services.IUserService;
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
	@Autowired
	IUserService userService;

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
	@RequestMapping("/registration")
	public ModelAndView getRegistration(Model model) {
		// create a new users object
		model.addAttribute("users", new Users());
		// return the view
		return new ModelAndView("customerreg","",model);
	}
	@RequestMapping(value="/save1", method=RequestMethod.POST)
	public ModelAndView save1Registration(@ModelAttribute("users") Users users,
			@RequestParam CommonsMultipartFile[] imagefile,
			Model model) {
		if (imagefile!=null && imagefile.length>0) {
			for (CommonsMultipartFile fileup:imagefile) {
				System.out.println("File Name: " + fileup.getOriginalFilename());
				// convert the image to bytes
				users.setImageData(fileup.getBytes());
			}
		}
		model.addAttribute("users", users);
		// save the object
		userService.addUser(users);
		return new ModelAndView("redirect:/login");
	}
	@RequestMapping(value="/authentication",method=RequestMethod.POST)
	public ModelAndView validateLogin(HttpServletRequest request, Model model, HttpSession session) {
		String userName = request.getParameter("uname");
		String password = request.getParameter("upass");
		//System.out.println("User Name: " + userName);
		//System.out.println("Password: " + password);
		Users users = userService.getUserAuthentication(userName, password);
		if (users != null) {
			if (users.getRole().equals("Customer")) {
				// create the new session object and stores the user object into the session
				session.setAttribute("users", users);
				// redirect to dashboard
				return new ModelAndView("redirect:/"); // end / is necessary
			}
		}
		String msg = "Invalid Username or Password";
		model.addAttribute("errmsg", msg);
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
	@RequestMapping(value="/item/cart/delete/{id}")
	public ModelAndView deleteToCart(@PathVariable("id") int id, Model model, HttpSession session) {
		CartCollection cartCollection = null;
		if (session.getAttribute("cartCollection") == null) {
			cartCollection = new CartCollection();
		} else {
			cartCollection = (CartCollection) session.getAttribute("cartCollection");
		}
		cartCollection.deleteFromCart(id);
		session.setAttribute("cartCollection", cartCollection);
		model.addAttribute("carts", cartCollection.getAll());
		model.addAttribute("totalAmount", cartCollection.getTotalAmount());
		return new ModelAndView("carts","",model);
	}
	@RequestMapping(value="/checkout")
	public ModelAndView checkout(Model model, HttpSession session) {
		if (session.getAttribute("users")==null) {
			return new ModelAndView("redirect:/login");
		}
		CartCollection cartCollection=null;
		if (session.getAttribute("cartCollection") == null) {
			cartCollection = new CartCollection();
		} else {
			cartCollection = (CartCollection) session.getAttribute("cartCollection");
		}
		model.addAttribute("carts", cartCollection.getAll());
		model.addAttribute("totalAmount", cartCollection.getTotalAmount());
		return new ModelAndView("invoice","",model);
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
