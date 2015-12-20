package edu.nyit.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Controller for retry page
 *
 */
@org.springframework.stereotype.Controller
public class RetryController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception 
	{
		ModelAndView mv = null;
		mv = new ModelAndView("index");
		return mv;
	}
}
