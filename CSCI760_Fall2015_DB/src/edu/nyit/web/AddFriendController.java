package edu.nyit.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.nyit.dto.Post;
import edu.nyit.dto.PostComparator;
import edu.nyit.dto.User;
import edu.nyit.dto.UserDAO;

/**
 * Controller for add friend page
 *
 */
@org.springframework.stereotype.Controller
public class AddFriendController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse arg1) throws Exception
	{
		ModelAndView mv = new ModelAndView("newMain");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");

		String friendName = request.getParameter("friend");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		UserDAO template = context.getBean("userDAO", UserDAO.class);
		User friend = template.getUser(
				friendName.substring(friendName.lastIndexOf(" ")).trim());

		System.out.println(friend.getEmail());
		System.out.println(u.getFriends().size());

		u.getFriends().add(friend.getEmail());
		template.updateUser(u);

		mv.addObject("firstName", u.getFirstName());
		Set<Post> postSet = u.getPosts();
		for (String s : u.getFriends())
		{
			User f = template.getUser(s);
			postSet.addAll(f.getPosts());
		}
		List<Post> postList = new ArrayList<Post>();
		postList.addAll(postSet);
		Collections.sort(postList, new PostComparator());
		List<String> l = u.toContentList(postList);
		mv.addObject("postList", l);

		return mv;
	}

}
