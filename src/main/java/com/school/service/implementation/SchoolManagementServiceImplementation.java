package com.school.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.domain.ResponseConstants;
import com.school.domain.Student;
import com.school.repository.SchoolManagementRepository;
import com.school.services.SchoolManagementService;

@Service
public class SchoolManagementServiceImplementation implements SchoolManagementService {

	@Autowired
	SchoolManagementRepository repository;

	public List<Student> getAllUsers() {
		return repository.findAll();
	}

	public void addUser(Student a) {
		repository.insert(a);
	}

	@Override
	public boolean deleteUser(int id) {
		if (repository.deleteByUserId(id) == 1)
			return true;
		else
			return false;
	}

	@Override
	public Student fetchUserDataById(int id) {
		return repository.findByUserId(id);

	}

	@Override
	public String updateUser(Student student) {
		if (repository.findByUserId(student.getUserId()) != null) {
			if (repository.save(student) != null) {
				return ResponseConstants.UPDATE_SUCCESS;
			} else {
				return ResponseConstants.UPDATE_FAILURE;
			}
		} else {
			return ResponseConstants.NO_USER_EXISTS;
		}
	}

	@Override
	public List<Student> fetchByUsingRequestParamFilter(Integer id, String country) {
		List<Student> stuList = new ArrayList<Student>();
		List<Student> list = getAllUsers();
		
		for (Student l : list) {
			if (id == null & country == null) {
				return list;
			} else if (country == null) {
				if (id == l.getUserId()) {
					stuList.add(l);
				}
			} else if (id == l.getUserId() || country.equalsIgnoreCase(l.getCountry())) {
				stuList.add(l);
			}
		}
		return stuList;
	}
}
