/*
package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.ExercisesInSession;
import exercise.repository.ExercisesInSessionRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 19, 2021
 
public class ExercisesInSessionWebController {
	@Autowired
	ExercisesInSessionRepository repo;

	@GetMapping("/viewAllExercisesInSession")
	public String viewAllExercisesInSession(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewExercisesInSession(model);
		}
		model.addAttribute("exercisesInSession", repo.findAll());
		return "resultsExercisesInSession";
	}
	
	@GetMapping("/inputExercisesInSession")
	public String addNewExercisesInSession(Model model) {
		ExercisesInSession e = new ExercisesInSession();
		model.addAttribute("newExercisesInSession", e);
		return "inputExercisesInSession";
	}
	
	@PostMapping("/inputExercisesInSession")
	public String addNewExercisesInSession(@ModelAttribute ExercisesInSession e, Model model) {
		repo.save(e);
		return viewAllExercisesInSession(model);
	}
	
	@GetMapping("/editExercisesInSession/{id}")
	public String showUpdateExercisesInSession(@PathVariable("id") long id, Model model) {
		ExercisesInSession e = repo.findById(id).orElse(null);
		model.addAttribute("newExercisesInSession", e);
		return "inputExercisesInSession";
	}
	
	@PostMapping("/updateExercisesInSession/{id}")
	public String reviseExercisesInSession(ExercisesInSession e, Model model) {
		repo.save(e);
		return viewAllExercisesInSession(model);
	}
	
	@GetMapping("/deleteExercisesInSession/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		ExercisesInSession e = repo.findById(id).orElse(null);
		repo.delete(e);
		return viewAllExercisesInSession(model);
	}
}
*/