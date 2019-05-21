package com.school.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.school.domain.Admin;

public interface SchoolManagementRepository extends MongoRepository<Admin, String> {

    public Admin findByLoginName(String userName);

}