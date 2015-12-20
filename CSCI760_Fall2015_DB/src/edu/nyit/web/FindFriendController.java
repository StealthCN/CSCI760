package edu.nyit.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.nyit.dto.User;
import edu.nyit.dto.UserDAO;

/**
 * Controller for find friend page
 *
 */
@org.springframework.stereotype.Controller
public class FindFriendController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		ModelAndView mv = new ModelAndView("findFriend");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		UserDAO template = context.getBean("userDAO", UserDAO.class);
		List<User> l = template.listUsers();
		List<String> userNames = new ArrayList<String>();
		for (User u : l)
		{
			userNames.add(u.getFirstName() + " " + u.getLastName() + " "
					+ u.getEmail());
		}
		mv.addObject("userNames", userNames);
		return mv;
	}

}
