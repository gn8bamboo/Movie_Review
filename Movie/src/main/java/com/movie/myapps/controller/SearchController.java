package com.movie.myapps.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.movie.myapps.dao.MovieDAO;
import com.movie.myapps.dao.SearchDAO;
import com.movie.myapps.domain.Act;
import com.movie.myapps.domain.Movie;
import com.movie.myapps.domain.Search;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/moviesearch", method = RequestMethod.POST)
	
	public String moviesearch(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute Search search, Model model) {
		
		logger.info("Movie search rs");
		
		String text = request.getParameter("search");
		System.out.println(text);
		
		SearchDAO searchdao = new SearchDAO();
		List movierslist = searchdao.getMovieSearchList(text);
		
		model.addAttribute("name", text);
		model.addAttribute("movierslist", movierslist);
		
		return "moviers";
	}
	
	
@RequestMapping(value = "/actorsearch", method = RequestMethod.POST)
	
	public String actorsearch(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute Search search, Model model) {
		
		logger.info("Actor search rs");
		
		String text = request.getParameter("search");
		System.out.println(text);
		
		SearchDAO searchdao = new SearchDAO();
		List actorrslist = searchdao.getActorSearchList(text);
				
				
		model.addAttribute("name", text);
		model.addAttribute("actorrslist", actorrslist);
		
		return "actorrs";
	}
	
}
