package com.rady.cmsshoppingcart;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rady.cmsshoppingcart.models.CategoryRepository;
import com.rady.cmsshoppingcart.models.PageRepository;
import com.rady.cmsshoppingcart.models.data.Cart;
import com.rady.cmsshoppingcart.models.data.Category;
import com.rady.cmsshoppingcart.models.data.Page;

@ControllerAdvice
@SuppressWarnings("unchecked")
public class Common {
	@Autowired
	private PageRepository pageRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@ModelAttribute
	public void shareDate(Model model, HttpSession session, Principal principal) {
		if (principal != null) {
			model.addAttribute("principal", principal.getName());
		}
		List<Page> pages = pageRepository.findAllByOrderBySortingAsc();
		List<Category> categories = categoryRepository.findAllByOrderBySortingAsc();
		boolean cartActive = false;

		if (session.getAttribute("cart") != null) {

			HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");

			int size = 0;
			double total = 0;

			for (Cart value : cart.values()) {
				size += value.getQuantity();
				total += value.getQuantity() * Double.parseDouble(value.getPrice());
			}

			model.addAttribute("csize", size);
			model.addAttribute("ctotal", total);

			cartActive = true;
		}
		model.addAttribute("cpages", pages);
		model.addAttribute("ccategories", categories);
		model.addAttribute("cartActive", cartActive);

	}
}
