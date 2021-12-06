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

import exercise.beans.Meals;
import exercise.repository.MealsRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Dec 3, 2021
 */

@Controller
@SessionAttributes("user_id")
public class MealsWebController {
	@Autowired
	MealsRepository repo;
	
	@GetMapping("/viewAllMeals")
	public String viewAllMeals(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewMeal(model);
		}
		long id = Long.parseLong(model.getAttribute("user_id").toString());
		LinkedList<Meals> mealsList = new LinkedList<Meals>();
		LinkedList<Meals> newList = new LinkedList<Meals>();
		repo.findAll().forEach(mealsList::add);
		for (int i = 0; i < mealsList.size(); i++) {
			if (mealsList.get(i).getUserId() == id) {
				newList.add(mealsList.get(i));
			}
		}
		model.addAttribute("meal", newList);
		return "resultsMeals";
	}
	
	@GetMapping("/inputMeal")
	public String addNewMeal(Model model) {
		Meals m = new Meals();
		model.addAttribute("newMeal", m);
		return "inputMeals";
	}
	
	@PostMapping("/inputMeal")
	public String addNewMeal(@ModelAttribute Meals m, Model model) {
		m.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
		repo.save(m);
		return viewAllMeals(model);
	}
	
	@GetMapping("/editMeal/{id}")
	public String showUpdateMeal(@PathVariable("id") long id, Model model) {
		Meals m = repo.findById(id).orElse(null);
		model.addAttribute("newMeal", m);
		return "inputMeals";
	}
	
	@PostMapping("/updateMeal/{id}")
	public String reviseMeal(Meals m, Model model) {
		m.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
		repo.save(m);
		return viewAllMeals(model);
	}
	
	@GetMapping("/deleteMeal/{id}")
	public String deleteMeal(@PathVariable("id") long id, Model model) {
		Meals m = repo.findById(id).orElse(null);
		repo.delete(m);
		return viewAllMeals(model);
	}
}
