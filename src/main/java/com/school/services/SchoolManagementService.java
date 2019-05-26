package com.school.services;

import java.util.List;

import com.school.domain.Student;

public interface SchoolManagementService {
	
public List<Student> getAllUsers();

public void addUser(Student a);

public boolean deleteUser(int id);

public Student fetchUserDataById(int id);

public String updateUser(Student student);

public List<Student> fetchByUsingRequestParamFilter(Integer id, String country);

}
