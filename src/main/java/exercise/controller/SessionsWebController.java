package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.Exercise;
import exercise.beans.Session;
import exercise.repository.SessionRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */

@Controller
public class SessionsWebController {
	@Autowired
	SessionRepository repo;
	
	@GetMapping("/viewAllSessions")
	public String viewAllSessions(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewSession(model);
		}
		model.addAttribute("sessions", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputSession")
	public String addNewSession(Model model) {
		Session s = new Session();
		model.addAttribute("newSession", s);
		return "input";
	}
	
	@PostMapping("/inputSession")
	public String addNewSession(@ModelAttribute Session s, Model model) {
		repo.save(s);
		return viewAllSessions(model);
	}
	
	@GetMapping("/editSession/{id}")
	public String showUpdateSession(@PathVariable("id") long id, Model model) {
		Session s = repo.findById(id).orElse(null);
		model.addAttribute("newSession", s);
		return "input";
	}
	
	@PostMapping("/updateSession/{id}")
	public String reviseSession(Session s, Model model) {
		repo.save(s);
		return viewAllSessions(model);
	}
	
	@GetMapping("/deleteSession/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Session s = repo.findById(id).orElse(null);
		repo.delete(s);
		return viewAllSessions(model);
	}
}
