package com.movie.myapps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.movie.myapps.dao.MovieDAO;
import com.movie.myapps.dao.ReviewDAO;
import com.movie.myapps.domain.Movie;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	
	public String review(Model model) {
		
		logger.info("Review info");
		
		ReviewDAO reviewdao = new ReviewDAO();
		List reviewlist = reviewdao.getReviewList();
		
		model.addAttribute("reviewlist", reviewlist);
		
		return "review";
	}
	
}
