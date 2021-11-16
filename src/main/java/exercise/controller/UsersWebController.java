package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.Users;
import exercise.repository.UsersRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 15, 2021
 */

@Controller
public class UsersWebController {
	@Autowired
	UsersRepository repo;

	@GetMapping("/viewAllUsers")
	public String viewAllUsers(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		model.addAttribute("users", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputUser")
	public String addNewUser(Model model) {
		Users c = new Users();
		model.addAttribute("newUser", c);
		return "input";
	}
	
	@PostMapping("/inputUser")
	public String addNewUser(@ModelAttribute Users u, Model model) {
		repo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/editUser/{id}")
	public String showUpdateUser(@PathVariable("id") long id, Model model) {
		Users u = repo.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "input";
	}
	
	@PostMapping("/updateUser/{id}")
	public String reviseUser(Users u, Model model) {
		repo.save(u);
		return viewAllUsers(model);
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Users u = repo.findById(id).orElse(null);
		repo.delete(u);
		return viewAllUsers(model);
	}
}
