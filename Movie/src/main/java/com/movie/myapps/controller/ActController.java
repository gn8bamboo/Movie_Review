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

import com.movie.myapps.dao.ActDAO;
import com.movie.myapps.domain.Act;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ActController {
	
	private static final Logger logger = LoggerFactory.getLogger(ActController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/moviedetail", method = RequestMethod.GET)
	public String moviedetail(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute Act act, Model model) {
		
		logger.info("Movie detail");
		
		//MovieDAO moviedao = new MovieDAO();
		//List movielist = moviedao.getMovieList();
		
		String titletext = request.getParameter("title");
		System.out.println(titletext);
		
		
		ActDAO actdao = new ActDAO();
		List actlist = actdao.getMovieDetailList(titletext);
		
		
		model.addAttribute("name",titletext);
		model.addAttribute("moviedetaillist", actlist);
		
		return "moviedetails";
	}
	
	
	
	@RequestMapping(value = "/actordetail", method = RequestMethod.GET)
	public String actordetail(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute Act act, Model model) {
		
		logger.info("Movie detail");
		
		//MovieDAO moviedao = new MovieDAO();
		//List movielist = moviedao.getMovieList();
		
		String anametext = request.getParameter("aname");
		System.out.println(anametext);
		
		
		ActDAO actdao = new ActDAO();
		List actorlist = actdao.getActorDetailList(anametext);
		
		
		model.addAttribute("name",anametext);
		model.addAttribute("actordetaillist", actorlist);
		
		return "actordetails";
	}
	
}
