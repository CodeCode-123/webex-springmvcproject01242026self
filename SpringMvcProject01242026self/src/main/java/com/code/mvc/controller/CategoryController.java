package com.code.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.code.mvc.entity.Category;
import com.code.mvc.services.CategoryService;

@Controller
@RequestMapping("/admin/category/")
public class CategoryController {
    //add the dependency
	private final CategoryService categoryService;
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService=categoryService;
	}
	@RequestMapping("/")
	public ModelAndView categoryRoot(Model model) {
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return new ModelAndView("managecategory", "", model);
	}

	@RequestMapping("/add")
	public ModelAndView categoryAdd(Model model) {
		model.addAttribute("category", new Category());
		return new ModelAndView("addcategory", "", model);
	}

	@RequestMapping(value="/savecategory",method=RequestMethod.POST)
	public ModelAndView categorySave(@ModelAttribute("category") Category category, Model model) {
		// save the category object
		// model.addAttribute("category",new Category());
		int id = categoryService.add(category);
		Category tempCategory = categoryService.getById(id);
		model.addAttribute("category", tempCategory);
		return new ModelAndView("redirect:/admin/category/");
	}
	
	@RequestMapping("/edit/{categoryId}")
	public ModelAndView getEditCategory(@PathVariable("categoryId") int id, Model model) {
		// retrieve object from the database
		Category category = categoryService.getById(id);
		// add attribute to the model
		model.addAttribute("category", category);
		// return the view;	
		return new ModelAndView("editcategory","",model);
	}
	
	@RequestMapping(value="/editcategory",method=RequestMethod.POST)
	public ModelAndView updateEditCategory(@ModelAttribute("category") Category category, Model model) {
		// update the category service
		model.addAttribute("category", category);
		categoryService.update(category);
		return new ModelAndView("redirect:/admin/category/");
	}
	
	@RequestMapping("/delete/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId") int id) {
		categoryService.delete(id);
		return new ModelAndView("redirect:/admin/category/");
	}
}
