package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import exercise.beans.Exercise;
import exercise.repository.ExerciseRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 15, 2021
 */
@Controller
public class ExerciseWebController {
	@Autowired
	ExerciseRepository repo;

	@GetMapping("/viewAllExercises")
	public String viewAllExercises(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewExercise(model);
		}
		model.addAttribute("exercises", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputExercise")
	public String addNewExercise(Model model) {
		Exercise e = new Exercise();
		model.addAttribute("newExercise", e);
		return "input";
	}
	
	@PostMapping("/inputExercise")
	public String addNewExercise(@ModelAttribute Exercise e, Model model) {
		repo.save(e);
		return viewAllExercises(model);
	}
	
	@GetMapping("/editExercise/{id}")
	public String showUpdateExercise(@PathVariable("id") long id, Model model) {
		Exercise e = repo.findById(id).orElse(null);
		model.addAttribute("newExercise", e);
		return "input";
	}
	
	@PostMapping("/updateExercise/{id}")
	public String reviseExercise(Exercise e, Model model) {
		repo.save(e);
		return viewAllExercises(model);
	}
	
	@GetMapping("/deleteExercise/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Exercise e = repo.findById(id).orElse(null);
		repo.delete(e);
		return viewAllExercises(model);
	}
}