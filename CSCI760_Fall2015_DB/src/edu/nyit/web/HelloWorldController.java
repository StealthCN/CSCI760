package edu.nyit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirect to index on server startup
 *
 */
@Controller
public class HelloWorldController
{
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}