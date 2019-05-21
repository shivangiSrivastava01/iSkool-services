package com.school.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.domain.Admin;
import com.school.service.implementation.SchoolManagementServiceImplementation;



@RestController
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public HashMap<String, String> getMessage() {
       
    	SchoolManagementServiceImplementation sc = new SchoolManagementServiceImplementation();
    	return sc.getSuccessfulLoginMessage();
    }
    @RequestMapping(value = "/validateUser", method = RequestMethod.POST)
    public static boolean validation(@RequestBody Admin a)
    {
    	boolean flag = SchoolManagementServiceImplementation.validateUser(a);
    	if(flag == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public static void addUser(@RequestBody Admin a)
    {
    	SchoolManagementServiceImplementation.addUser(a);
    }

}