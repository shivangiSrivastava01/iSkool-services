package com.school.service.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.school.domain.Admin;

public class SchoolManagementServiceImplementation {

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
		
		users.put(a.getLoginName(),a.getPassword());

	}
}
