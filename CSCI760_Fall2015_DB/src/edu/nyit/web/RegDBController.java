package edu.nyit.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.nyit.dto.Post;
import edu.nyit.dto.PostService;
import edu.nyit.dto.User;
import edu.nyit.dto.UserService;

/**
 * Controller for register a user
 *
 */
@org.springframework.stereotype.Controller
public class RegDBController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception
	{
		ModelAndView mv = null;
		mv = new ModelAndView("index");

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		UserService personService = (UserService) context
				.getBean("userService");
		PostService postService = (PostService) context.getBean("postService");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		User u = new User();
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setEmail(email);
		u.setPassword(pass);
		personService.addPerson(u);

		Post p = new Post();
		p.setUser(u);
		p.setContent("I joined LifePiece!");
		u.getPosts().add(p);
		postService.addPost(p);

		mv.addObject("userName", email);
		mv.addObject("password", pass);
		return mv;
	}
}
