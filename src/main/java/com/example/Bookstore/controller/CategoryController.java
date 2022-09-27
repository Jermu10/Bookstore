package com.example.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@GetMapping(value="/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		// model.addAttribute("categories", crepository.findAll());
		return "addcategory";
	}
	
	@PostMapping(value = "/savec")
	public String saveC(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}
	
}
