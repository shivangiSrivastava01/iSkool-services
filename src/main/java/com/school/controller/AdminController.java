package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.domain.ResponseConstants;
import com.school.domain.Student;
import com.school.services.SchoolManagementService;

@RestController
public class AdminController {

	@Autowired
	SchoolManagementService sc;

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public List<Student> getMessage() {
		return sc.getAllUsers();
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody Student student) throws Exception {
		try {
			sc.addUser(student);
			return "User Added successfully!!";
		} catch (Exception e) {
			return "Failed to add user";
		}

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public String deleteUser(@RequestBody int id) {
		try {
			if (sc.deleteUser(id)) {
				return ResponseConstants.DELETE_SUCCESS;
			} else {
				return ResponseConstants.DELETE_FAILURE;
			}
		} catch (Exception e) {
			return "Exception Occoured";
		}
	}

	@RequestMapping(value = "/fetchUserById", method = RequestMethod.POST)
	public Student fetchUserById(@RequestBody int id) {
		return sc.fetchUserDataById(id);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public String updateUser(@RequestBody Student student)
	{  
		return sc.updateUser(student);
	}
	@RequestMapping(value = "/fetchUserDetailsById/{id}", method = RequestMethod.GET)
	public Student fetchUserDataByIdUsingPathVariable(@PathVariable int id)
	{
		return sc.fetchUserDataById(id);	
	}
	@RequestMapping(value = "/fetchUserDetailsByRequestParam", method=RequestMethod.GET)
	public Student fetchUserDataByIdUsingRequestParam(@RequestParam("id")int id)
	{
		return sc.fetchUserDataById(id);
	}
	@RequestMapping(value = "/fetchByUsingFilters", method = RequestMethod.GET)
	public List<Student> fetchByUsingFilters(@RequestParam(value = "id" ,required = false)Integer id,@RequestParam(value = "country",required = false)String country )
	{
		return sc.fetchByUsingRequestParamFilter(id,country);
	}
	@RequestMapping(value = "/fetchByPagination",method = RequestMethod.GET)
	public List<Student> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "30") int limit)
	{
		return sc.getUserViaPagination(page,limit);
	}
}