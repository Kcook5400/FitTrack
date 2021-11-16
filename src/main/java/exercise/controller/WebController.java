package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.Session;
import exercise.repository.ExerciseRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */

@Controller
public class WebController {
	@Autowired
	ExerciseRepository repo;
	
	@GetMapping({ "/", "viewAllSessions" })
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
}
