package com.movie.myapps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.myapps.dao.CommentDAO;
import com.movie.myapps.dao.MovieDAO;
import com.movie.myapps.dao.ReviewDAO;
import com.movie.myapps.domain.Movie;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	
	public String comment(Model model) {
		
		logger.info("Comment info");
		
		CommentDAO commentdao = new CommentDAO();
		List commentlist = commentdao.getCommentList();
		
		model.addAttribute("commentlist", commentlist);
		
		return "comment";
	}
	
}
