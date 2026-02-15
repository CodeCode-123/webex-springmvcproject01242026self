package com.code.mvc.controller;

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
import com.code.mvc.dto.UsersDto;
import com.code.mvc.entity.Users;
import com.code.mvc.services.IUserService;

@Controller
@RequestMapping("admin/users/")
public class UsersController {
	// add dependency
	private final IUserService userService;
	@Autowired
	public UsersController(IUserService userService) {
		this.userService=userService;
	}
	@RequestMapping("/")
	public ModelAndView getRoot(Model model) {
		// get all the users
		List<Users> lstusers = userService.getAll();
		model.addAttribute("lstusers", lstusers);
		//model.addAttribute("users", new Users());
		// return the view
		return new ModelAndView("manageusers","",model);
	}
	@RequestMapping("/registration")
	public ModelAndView getRegistration(Model model) {
		// create a new users object
		model.addAttribute("users", new Users());
		// return the view
		return new ModelAndView("registration1","",model);
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView getEditRegistration(@PathVariable("id") int id, Model model) {
		// retrieve an object from the database
		Users users = userService.getUserById(id);
		UsersDto userdto= new UsersDto();
		userdto.setCountry(users.getCountry());
		userdto.setFirstName(users.getFirstName());
		userdto.setGender(users.getGender());
		userdto.setId(users.getId());
		userdto.setLanguages(users.getLanguages());
		userdto.setLastName(users.getLastName());
		userdto.setImageData(users.getImageData());
		// add the attribute to the model;
		model.addAttribute("users", userdto);
		// return the view
		return new ModelAndView("editregistration","",model);
	}
	@RequestMapping("/delete/{id}") // don't use method=RequestMethod.DELETE, this might be GET method
	public ModelAndView deleteRegistration(@PathVariable("id") int id, Model model) {
		// delete the object
		userService.deleteUser(id);
		// return the view
		return new ModelAndView("redirect:/admin/users/");
	}
	/*
	@RequestMapping(value="/save", method=RequestMethod.POST) //explicit define POST in the form
	public ModelAndView saveRegistration(HttpServletRequest request, Model model) {
		String firstName=request.getParameter("fname");
		String lastName=request.getParameter("lname");
		String country=request.getParameter("country");
		String languages="";
		if (request.getParameter("lang") != null) {
			languages=request.getParameter("lang");
		}
		if (request.getParameter("lang1") != null) {
			languages+=", " + request.getParameter("lang1");
		}
		if (request.getParameter("lang2") != null) {
			languages+=", " + request.getParameter("lang2");
		}
		String gender=request.getParameter("gender");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Country: " + country);
		System.out.println("Gender: " + gender);
		System.out.println("Languages: " + languages);
		// set values to the model object
		model.addAttribute("name", firstName + " " + lastName);
		model.addAttribute("country", country);
		// return the view
		return new ModelAndView("confirm","",model);
	}*/
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
		System.out.println(users.toString());
		// set values to the model object
		for(String lang: users.getLanguages()) {
			System.out.println(lang);
		}
		users.setRole("Admin");
		model.addAttribute("users", users);
		// save the object
		userService.addUser(users);
		// return the view
		return new ModelAndView("redirect:/admin/users/");
	}
	@RequestMapping(value="/editsave", method=RequestMethod.POST)
	public ModelAndView updateRegistration(@ModelAttribute("users") UsersDto usersDto,
			@RequestParam CommonsMultipartFile[] imagefile,
			Model model) {
		Users users = userService.getUserById(usersDto.getId());
		users.setCountry(usersDto.getCountry());
		users.setFirstName(usersDto.getFirstName());
		users.setGender(usersDto.getGender());
		users.setId(usersDto.getId());
		users.setLanguages(usersDto.getLanguages());
		users.setLastName(usersDto.getLastName());
		users.setImageData(usersDto.getImageData());
		System.out.println("id: " + users.getId());
		if (imagefile!=null && imagefile.length>0) {
			for (CommonsMultipartFile fileup:imagefile) {
				//System.out.println("File Name: " + fileup.getOriginalFilename());
				// convert the image to bytes
				users.setImageData(fileup.getBytes());
			}
		}
		// add attribute to the model
		model.addAttribute("users", users);
		// update the object
		userService.updateUser(users);
		// return the view
		return new ModelAndView("redirect:/admin/users/");
	}
	@RequestMapping(value="/image/{id}")
	public void getImage(@PathVariable("id") int id, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		Users users = userService.getUserById(id);
		if (users != null && users.getImageData() != null) {
			response.setContentType("image/jpeg");
			response.getOutputStream().write(users.getImageData());
			response.getOutputStream().flush();
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session) {
		// clear the session object
		session.invalidate();
		return new ModelAndView("redirect:/admin/");
	}
}
