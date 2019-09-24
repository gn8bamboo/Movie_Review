package com.movie.myapps.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.myapps.dao.ActorDAO;
import com.movie.myapps.dao.MovieDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ActorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ActorController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/actor", method = RequestMethod.GET)
	
	public String actor(Model model) {
		
		logger.info("Actor info");
		
		//MovieDAO moviedao = new MovieDAO();
		//List movielist = moviedao.getMovieList();
		
		ActorDAO actordao = new ActorDAO();
		List actorlist = actordao.getActorList();
		
		model.addAttribute("actorlist", actorlist);
		
		return "actor";
	}
	
}
