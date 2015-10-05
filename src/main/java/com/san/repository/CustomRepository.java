package com.san.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.san.model.EmailHeader;

public interface CustomRepository extends MongoRepository<EmailHeader, String> {

    public List<EmailHeader> findAll(Sort sort);

}