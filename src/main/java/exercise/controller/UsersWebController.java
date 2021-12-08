package exercise.controller;

import java.time.LocalDate;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import exercise.beans.Users;
import exercise.repository.UsersRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 15, 2021
 */

@Controller
@SessionAttributes("user_id")
public class UsersWebController {
	private LocalDate date = LocalDate.now();
	@Autowired
	UsersRepository repo;
	
	@GetMapping("mainmenu")
	public String mainMenu() {
		return "mainmenu";
	}

	@GetMapping("/login")
	public String loginUser(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		Users u = new Users();
		model.addAttribute("newUser", u);
		
		return "login";
	}
	
	@PostMapping("/login/{id}")
	public String loginUser(@ModelAttribute Users u, Model model) {
		LinkedList<Users> usersList = new LinkedList<Users>();
		repo.findAll().forEach(usersList::add);
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getUserName().equals(u.getUserName())) {
				if (u.getPassword().equals(usersList.get(i).getPassword())) {
					model.addAttribute("user_id", usersList.get(i).getId());
					return mainMenu();
				}
			}
		}
		return loginUser(model);
	}
	
	@GetMapping("/viewAllUsers")
	public String viewAllUsers(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		long id = Long.parseLong(model.getAttribute("user_id").toString());
		LinkedList<Users> usersList = new LinkedList<Users>();
		LinkedList<Users> newList = new LinkedList<Users>();
		repo.findAll().forEach(usersList::add);
		for (int i = 0; i < usersList.size(); i++) {
			if (usersList.get(i).getId() == id) {
				newList.add(usersList.get(i));
			}
		}
		
		model.addAttribute("user", newList);
		return "resultsUsers";
	}
	
	@GetMapping("/inputUser")
	public String addNewUser(Model model) {
		System.out.println("Test2");
		Users c = new Users();
		model.addAttribute("newUser", c);
		return "inputUsers";
	}
	
	@PostMapping("/inputUser")
	public String addNewUser(@ModelAttribute Users u, Model model) {
		repo.save(u);
		return loginUser(model);
	}
	
	@GetMapping("/editUser/{id}")
	public String showUpdateUser(@PathVariable("id") long id, Model model) {
		Users u = repo.findById(id).orElse(null);
		date = u.getDayJoined();
		model.addAttribute("newUser", u);
		return "inputUsers";
	}
	
	@PostMapping("/updateUser/{id}")
	public String reviseUser(Users u, Model model) {
		u.setDayJoined(date);
		repo.save(u);
		return loginUser(model);
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Users u = repo.findById(id).orElse(null);
		repo.delete(u);
		return loginUser(model);
	}
}
