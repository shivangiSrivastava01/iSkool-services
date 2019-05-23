package com.school.service.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.domain.Student;
import com.school.repository.SchoolManagementRepository;
import com.school.services.SchoolManagementService;

@Service
public class SchoolManagementServiceImplementation implements SchoolManagementService {

	private List<Student> studentList = new ArrayList<>();
	@Autowired
	SchoolManagementRepository repository;

	public List<Student> getSuccessfulLoginMessage() {
		return repository.findAll();
	}

	@Override
	public boolean validateUser(Student stu) {
		Iterator<Student> itr = studentList.iterator();
		while (itr.hasNext()) {
			if (studentList.contains(stu.getUserId())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public void addUser(Student a) {
		repository.save(a);
	}

	@Override
	public void deleteUser(int id) {
		repository.deleteByUserId(id);
	}

	@Override
	public void fetchUserDataById(int id) {
		repository.findByUserId(id);
	}
}
