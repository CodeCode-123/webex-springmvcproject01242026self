package com.code.mvc.controller;

import java.io.IOException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.entity.Users;
import com.code.mvc.services.CategoryService;
import com.code.mvc.services.ItemService;

@Controller
@RequestMapping("/admin/item/")
public class ItemController {
	// add the dependency
	private final ItemService itemService;
	private final CategoryService categoryService;
	@Autowired
	public ItemController(ItemService itemService, CategoryService categoryService) {
		this.itemService=itemService;
		this.categoryService=categoryService;
	}
	
	// root mapping
	@RequestMapping(value = "/")
	public ModelAndView getAllItems(Model model) {
		List<Item> items = itemService.getAll();
		model.addAttribute("items", items);
		return new ModelAndView("manageproduct", "", model);
	}

	@RequestMapping(value = "/add")
	public ModelAndView createItems(Model model) {
		List<Category> categories = categoryService.getAll();
		// add the object to the model
		model.addAttribute("categories", categories);
		model.addAttribute("item", new Item());
		return new ModelAndView("addproduct", "", model);
	}

	@RequestMapping(value = "/save",method=RequestMethod.POST)
	public ModelAndView saveItems(HttpServletRequest request, @ModelAttribute("item") Item item, Model model,
			@RequestParam CommonsMultipartFile[] photo) {

		try {
			if (photo != null && photo.length > 0) {
				for (CommonsMultipartFile fileup : photo) {
					System.out.println("File Name :" + fileup.getOriginalFilename());
					item.setImageData(fileup.getBytes());
				}
			}

			if (item.getItemId() == 0) {
				itemService.add(item);
			} else {
				itemService.update(item);
			}
		} catch (Exception err) {
			model.addAttribute("errmsg", err.getMessage());
			return new ModelAndView("error", "", model);
		}
		// return the view
		return new ModelAndView("redirect:/admin/item/");
	}

	// request mapping to get the image
	@RequestMapping(value = "/image/{id}")
	public void getImage(@PathVariable("id") int id, HttpServletRequest request, Model model,
			HttpServletResponse response) throws IOException {

		// remove the object
		Item item = itemService.getById(id);
		if (item != null & item.getImageData() != null) {
			response.setContentType("image/jpeg");
			response.getOutputStream().write(item.getImageData());
			response.getOutputStream().flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	@RequestMapping("/edit/{itemId}")
	public ModelAndView getEditItem(@PathVariable("itemId") int id, Model model) {
		List<Category> categories = categoryService.getAll();
		// add the object to the model
		model.addAttribute("categories", categories);
		// retrieve item from the database
		Item item = itemService.getById(id);
		// add attribute to the model
		model.addAttribute("category", item.getCategory());
		model.addAttribute("item", item);
		// return the model and view
		return new ModelAndView("editproduct","",model);
	}
	@RequestMapping(value="/editproduct",method=RequestMethod.POST)
	public ModelAndView updateEditItem(HttpServletRequest request, @ModelAttribute("item") Item item, Model model,
			@RequestParam CommonsMultipartFile[] photo) {
		try {
			if (photo != null && photo.length > 0) {
				for (CommonsMultipartFile fileup : photo) {
					System.out.println("File Name :" + fileup.getOriginalFilename());
					item.setImageData(fileup.getBytes());
				}
			}

			if (item.getItemId() == 0) {
				itemService.add(item);
			} else {
				itemService.update(item);
			}
		} catch (Exception err) {
			model.addAttribute("errmsg", err.getMessage());
			return new ModelAndView("error", "", model);
		}
		// return the view
		return new ModelAndView("redirect:/admin/item/");
	}
	@RequestMapping("/delete/{itemId}")
	public ModelAndView deleteItem(@PathVariable("itemId") int id) {
		itemService.delete(id);
		return new ModelAndView("redirect:/admin/item/");
	}
}
