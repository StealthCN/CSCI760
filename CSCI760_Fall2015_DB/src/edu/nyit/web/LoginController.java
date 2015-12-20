package edu.nyit.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.nyit.dto.Post;
import edu.nyit.dto.PostComparator;
import edu.nyit.dto.User;
import edu.nyit.dto.UserDAO;

@org.springframework.stereotype.Controller
public class LoginController implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ModelAndView mv = null;

		if (userName != null && !password.isEmpty())
		{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"spring.xml");
			UserDAO template = context.getBean("userDAO", UserDAO.class);
			User u = template.getUser(userName);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", u);

			if ((userName.compareTo(u.getEmail()) == 0)
					&& (password.compareTo(u.getPassword())) == 0)
			{
				mv = new ModelAndView("newMain");
				mv.addObject("firstName", u.getFirstName());
				Set<Post> postSet = u.getPosts();
				for(String s : u.getFriends())
				{
					User f = template.getUser(s);
					postSet.addAll(f.getPosts());
				}
				List<Post> postList = new ArrayList<Post>();
				postList.addAll(postSet);
				Collections.sort(postList, new PostComparator());
				List<String> l = u.toContentList(postList);
				mv.addObject("postList", l);
			}
			else
			{
				mv = new ModelAndView("wrongPass");
				mv.addObject("msg", "Error");
			}
		}
		else
		{
			mv = new ModelAndView("wrongPass");
			mv.addObject("msg", "Error");
		}
		return mv;
	}
}
