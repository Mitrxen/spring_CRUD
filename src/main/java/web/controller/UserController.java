package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
    @GetMapping(value = "/")
    public String redirectExample() {
        return "redirect:/users";
    }
    
    @GetMapping(value = "/users")
	public String printAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
    
	@GetMapping(value = "/{id}")
	public String printWelcome(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}
	
	@GetMapping(value = "/add")
	public String addNewUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "add";
	}
	
	@PostMapping(value = "/add")
	public String addNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/users";
	}
	
	
	@GetMapping("/{id}/edit")
	public String editUser(ModelMap model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}
	
	
	@PatchMapping("/{id}")
	public String edit(@ModelAttribute("user") User user, @PathVariable("id") int id) {
		userService.editUser(id, user);
		return "redirect:/users";
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.removeUser(id);
		return "redirect:/users";
	}
	
	
	
	
	
}