package com.san.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.san.model.EmailRecipient;

@RepositoryRestResource(path = "emailfrom")
public interface EmailRecipientRepository extends MongoRepository<EmailRecipient, String> {
	List<EmailRecipient> findAll();
}