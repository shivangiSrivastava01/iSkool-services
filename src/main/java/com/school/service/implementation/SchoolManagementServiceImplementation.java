package com.school.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.school.domain.Admin;
import com.school.repository.SchoolManagementRepository;

public class SchoolManagementServiceImplementation {
	
	@Autowired
	private static SchoolManagementRepository repository;

	private static HashMap<String,String> users = new HashMap<String, String>();
	
	  public HashMap<String, String> getSuccessfulLoginMessage() {
	  
		 
		  return users;
	  
	  
	  }
	 

	public static boolean validateUser(Admin a) {

		Iterator<Map.Entry<String, String>> itr = users.entrySet().iterator();
		while(itr.hasNext()) 
        { 
		if (users.containsKey(a.getLoginName()) && users.containsValue(a.getPassword())) {
			return true;
		}
		else
		{
			return false;
		}
        }
		return false;

	}

	public static void addUser(Admin a) {

		repository.save(a);
		
	}
}
