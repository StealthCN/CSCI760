package edu.nyit.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.nyit.dto.User;

@org.springframework.stereotype.Controller
public class ProfileController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception 
	{
		ModelAndView mv = new ModelAndView("newProfile");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		mv.addObject("firstName", u.getFirstName());
		mv.addObject("lastName", u.getLastName());
		mv.addObject("email", u.getEmail());
		return mv;
	}

}
