package exercise.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import exercise.beans.Exercise;
import exercise.beans.Users;
import exercise.repository.ExerciseRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Nov 15, 2021
 */

@Controller
@SessionAttributes("user_id")
public class ExerciseWebController {
	@Autowired
	ExerciseRepository repo;
	
	@GetMapping("/viewAllExercises")
	public String viewAllExercises(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewExercise(model);
		}
		long id = Long.parseLong(model.getAttribute("user_id").toString());
		LinkedList<Exercise> exerciseList = new LinkedList<Exercise>();
		LinkedList<Exercise> newList = new LinkedList<Exercise>();
		repo.findAll().forEach(exerciseList::add);
		for (int i = 0; i < exerciseList.size(); i++) {
			if (exerciseList.get(i).getUserId() == id) {
				newList.add(exerciseList.get(i));
			}
		}
		model.addAttribute("exercise", newList);
		return "resultsExercise";
	}
	
	@GetMapping("/inputExercise")
	public String addNewExercise(Model model) {
		Exercise e = new Exercise();
		model.addAttribute("newExercise", e);
		return "inputExercise";
	}
	
	@PostMapping("/inputExercise")
	public String addNewExercise(@ModelAttribute Exercise e, Model model) {
		e.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
		repo.save(e);
		return viewAllExercises(model);
	}
	
	@GetMapping("/editExercise/{id}")
	public String showUpdateExercise(@PathVariable("id") long id, Model model) {
		Exercise e = repo.findById(id).orElse(null);
		model.addAttribute("newExercise", e);
		return "inputExercise";
	}
	
	@PostMapping("/updateExercise/{id}")
	public String reviseExercise(Exercise e, Model model) {
		e.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
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