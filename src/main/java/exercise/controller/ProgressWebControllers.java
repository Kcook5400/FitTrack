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

import exercise.beans.Progress;
import exercise.repository.ProgressRepository;

/**
 * @author Noah Chung - nmchung
 * CIS175 - Fall 2021
 * Dec 3, 2021
 */

@Controller
@SessionAttributes("user_id")
public class ProgressWebControllers {
	@Autowired
	ProgressRepository repo;
	
	@GetMapping("/viewAllProgress")
	public String viewAllProgress(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewProgress(model);
		}
		long id = Long.parseLong(model.getAttribute("user_id").toString());
		LinkedList<Progress> progressList = new LinkedList<Progress>();
		LinkedList<Progress> newList = new LinkedList<Progress>();
		repo.findAll().forEach(progressList::add);
		for (int i = 0; i < progressList.size(); i++) {
			if (progressList.get(i).getUserId() == id) {
				newList.add(progressList.get(i));
			}
		}
		model.addAttribute("progress", newList);
		return "resultsProgress";
	}
	
	@GetMapping("/inputProgress")
	public String addNewProgress(Model model) {
		Progress p = new Progress();
		model.addAttribute("newProgress", p);
		return "inputProgress";
	}
	
	@PostMapping("/inputProgress")
	public String addNewProgress(@ModelAttribute Progress p, Model model) {
		p.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
		repo.save(p);
		return viewAllProgress(model);
	}
	
	@GetMapping("/editProgress/{id}")
	public String showUpdateProgress(@PathVariable("id") long id, Model model) {
		Progress p = repo.findById(id).orElse(null);
		model.addAttribute("newProgress", p);
		return "inputProgress";
	}
	
	@PostMapping("/updateProgress/{id}")
	public String reviseProgress(Progress p, Model model) {
		p.setUserId(Long.parseLong(model.getAttribute("user_id").toString()));
		repo.save(p);
		return viewAllProgress(model);
	}
	
	@GetMapping("/deleteProgress/{id}")
	public String deleteProgress(@PathVariable("id") long id, Model model) {
		Progress p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllProgress(model);
	}
}
