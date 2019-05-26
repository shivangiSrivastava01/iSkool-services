package com.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.domain.Student;


public interface SchoolManagementRepository extends MongoRepository<Student, String> {

   public Long deleteByUserId(int id);
   
   public Student findByUserId(int id);
}