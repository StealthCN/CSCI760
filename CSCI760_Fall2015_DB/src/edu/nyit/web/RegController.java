package edu.nyit.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controller for registration page
 *
 */
@org.springframework.stereotype.Controller
public class RegController implements Controller
{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception
	{
		ModelAndView mv = null;
		mv = new ModelAndView("registerPage");
		return mv;
	}
}
