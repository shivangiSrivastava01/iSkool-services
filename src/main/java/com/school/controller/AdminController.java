package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.domain.Student;
import com.school.services.SchoolManagementService;

@RestController
public class AdminController {

	@Autowired
	SchoolManagementService sc;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public List<Student> getMessage() {
		return sc.getSuccessfulLoginMessage();
	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public boolean validation(@RequestBody Student a) {
		return sc.validateUser(a);

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody Student student) throws 	Exception {
		try
		{
			sc.addUser(student);
			return "User Added successfully!!";
		}
		catch(Exception e)
		{
			return "Failed to add user";
		}
		
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public String deleteUser(@RequestBody int id)
	{
		try
		{
			sc.deleteUser(id);
			return "Deleted user successfully";
		}
		catch(Exception e)
		{
			return "Failed to delete user";
		}
	}
	
	@RequestMapping(value = "/fetchUserById", method = RequestMethod.POST)
	public String fetchUserById(@RequestBody int id)
	{
		try
		{
			sc.fetchUserDataById(id);
			return "Sucessfully Displayed user data";
		}
		catch(Exception e)
		{
			return "Failure";
		}
	}

}