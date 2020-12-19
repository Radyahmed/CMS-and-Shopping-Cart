package com.cms.restclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cms.restclient.models.data.Page;

@Controller
@RequestMapping("/")
public class PagesController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public String home(Model model)

	{
		Page page = restTemplate.getForObject("http://localhost:8080/pages/home", Page.class);
		model.addAttribute("page", page);
		return "page";
	}

	@GetMapping("/{slug}")
	public String page(@PathVariable String slug, Model model)

	{
		try {
			Page page = restTemplate.getForObject("http://localhost:8080/pages/{slug}", Page.class, slug);
			model.addAttribute("page", page);
		} catch (HttpClientErrorException e) {
			return "redirect:/";
		}
		return "page";
	}
}
