package com.movie.myapps.controller;

import java.util.ArrayList;
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

import com.movie.myapps.dao.MoviegoerDAO;
import com.movie.myapps.domain.Moviegoer;

/**
 * Handles requests for the application home page.
 */

@Controller
public class MoviegoerController {
	
	private static final Logger logger = LoggerFactory.getLogger(MoviegoerController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String newLogin(Model model) {
		
		logger.info("newLogin");
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	
	public String login(HttpServletRequest request, HttpServletResponse response, 
            @ModelAttribute Moviegoer moviegoer, Model model) {
		
		
		logger.info("Login");
		
		String nametext = request.getParameter("username");
		String pwdtext = request.getParameter("password");
		model.addAttribute("name", nametext);
		
		System.out.println(nametext);
		System.out.println(pwdtext);
		
		MoviegoerDAO moviegoerdao = new MoviegoerDAO();
		boolean z =  moviegoerdao.CheckLogin(nametext, pwdtext);
		
		 if (z==true)
         {
          return "menu";
         }
         else if(z==false)
         {
            return "error";
         }
		 
		return null;
	
		
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		
		logger.info("Menu");
		return "menu";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model) {
		
		logger.info("Error");
		return "error";
	}
	
	
	@RequestMapping(value = "/register1", method = RequestMethod.GET)
	public String register1(Model model) {
		
		logger.info("Register-step1");
		return "register";
	}
	
	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String register2(HttpServletRequest request,Model model) {
		
	
	
		logger.info("Register-step2");
		//System.out.println(nametext);
		//System.out.println(pwdtext);
		
		String nametext = request.getParameter("username");
		String streettext = request.getParameter("street");
		String citytext = request.getParameter("city");
		String statetext = request.getParameter("state");
		String ziptext = request.getParameter("zip");
		String phonetext = request.getParameter("phone");
		String emailtext = request.getParameter("email");
		String pwdtext = request.getParameter("password");
		
		
		if(nametext.equals("")||pwdtext.equals("")){
			return "error_null";
		} 
		
		MoviegoerDAO moviegoerdao = new MoviegoerDAO();
		Moviegoer moviegoer = new Moviegoer();
		
		moviegoer.setMname(nametext);
		moviegoer.setStreet(streettext);
		moviegoer.setCity(citytext);
		moviegoer.setState(statetext);
		moviegoer.setZip(Integer.parseInt(ziptext));
		moviegoer.setPhone(phonetext);
		moviegoer.setEmail(emailtext);
		moviegoer.setPassword(pwdtext);
		
		moviegoerdao.InsertUser(moviegoer);
		
		System.out.println(moviegoer.getMname());
		System.out.println(moviegoer.getPassword());
		model.addAttribute("name", nametext);
		
		return "menu";
		
	}
	
	/*@RequestMapping(value = "/register3", method = RequestMethod.POST)
	public String register3(HttpServletRequest request) {
	logger.info("Register-step3");
		
		
		MoviegoerDAO moviegoerdao = new MoviegoerDAO();
		List<Moviegoer> moviegoerlist = new ArrayList<Moviegoer>();
		moviegoerlist = moviegoerdao.getMoviegoerList();
		
		String nametext = request.getParameter("username");
		System.out.println(nametext);
		
		for(Moviegoer a : moviegoerlist){
			
			System.out.println(a.getMname());
			
				if (nametext.equals(a.getMname())){
					return "error_reg";
				}
				return "register4";
		}
		
		return null;
	}*/
	
	/*@RequestMapping(value = "/register3", method = RequestMethod.POST)
	public String register3(HttpServletRequest request) {
	logger.info("Register-step3");
		
		
		MoviegoerDAO moviegoerdao = new MoviegoerDAO();
		Moviegoer moviegoer = new Moviegoer();
		
		String nametext = request.getParameter("username");
		String streettext = request.getParameter("street");
		String citytext = request.getParameter("city");
		String statetext = request.getParameter("state");
		String ziptext = request.getParameter("zip");
		String phonetext = request.getParameter("phone");
		String emailtext = request.getParameter("email");
		String pwdtext = request.getParameter("password");
		
		moviegoer.setMname(nametext);
		moviegoer.setStreet(streettext);
		moviegoer.setCity(citytext);
		moviegoer.setState(statetext);
		moviegoer.setZip(Integer.parseInt(ziptext));
		moviegoer.setPhone(phonetext);
		moviegoer.setEmail(emailtext);
		moviegoer.setPassword(pwdtext);
		
		moviegoerdao.InsertUser(moviegoer);
		
		
		System.out.println(moviegoer.getMname());
		System.out.println(moviegoer.getPassword());
		
		
		return "menu";
	}*/
	
	
	
	
}
