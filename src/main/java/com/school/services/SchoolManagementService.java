package com.school.services;

import java.util.List;

import com.school.domain.Student;

public interface SchoolManagementService {
	
public List<Student> getSuccessfulLoginMessage();

boolean validateUser(Student stu);

public void addUser(Student a);

public void deleteUser(int id);

public void fetchUserDataById(int id);
	
}
