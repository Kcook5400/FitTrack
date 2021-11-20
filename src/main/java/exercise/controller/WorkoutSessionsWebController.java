package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.Exercise;
//import exercise.beans.Session;
//import exercise.repository.SessionRepository;
import exercise.beans.WorkoutSession;
import exercise.repository.WorkoutSessionRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */

@Controller
public class WorkoutSessionsWebController {
	@Autowired
	WorkoutSessionRepository repo;
	
	@GetMapping("/viewAllSessions")
	public String viewAllSessions(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewSession(model);
		}
		model.addAttribute("session", repo.findAll());
		return "resultsSessions";
	}
	
	@GetMapping("/inputSession")
	public String addNewSession(Model model) {
		WorkoutSession ws = new WorkoutSession();
		model.addAttribute("newSession", ws);
		return "inputSessions";
	}
	
	@PostMapping("/inputSession")
	public String addNewSession(@ModelAttribute WorkoutSession ws, Model model) {
		repo.save(ws);
		return viewAllSessions(model);
	}
	
	@GetMapping("/editSession/{id}")
	public String showUpdateSession(@PathVariable("id") long id, Model model) {
		WorkoutSession ws = repo.findById(id).orElse(null);
		model.addAttribute("newSession", ws);
		return "inputSessions";
	}
	
	@PostMapping("/updateSession/{id}")
	public String reviseSession(WorkoutSession ws, Model model) {
		repo.save(ws);
		return viewAllSessions(model);
	}
	
	@GetMapping("/deleteSession/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		WorkoutSession ws = repo.findById(id).orElse(null);
		repo.delete(ws);
		return viewAllSessions(model);
	}
}