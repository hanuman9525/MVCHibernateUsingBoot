package com.boot.mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
	@Autowired
	SessionFactory sessionfactory;

	@RequestMapping(value = "/add")
	public ModelAndView addUser(@ModelAttribute User u) {
		Session session = sessionfactory.openSession();
		session.save(u);
		session.beginTransaction().commit();
		session.close();
		ModelAndView m=new ModelAndView();
		m.setViewName("SuccessUser");
		m.addObject("user",u.getName());
		return m;
	}

	@RequestMapping(value = "/")
	public String saveUser() {
		return "AddUser";
	}

}
