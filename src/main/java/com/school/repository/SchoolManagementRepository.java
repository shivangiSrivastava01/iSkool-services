package com.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.domain.Student;


public interface SchoolManagementRepository extends MongoRepository<Student, String> {

   public void deleteByUserId(int id);
   
   public void findByUserId(int id);
}