package com.san.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.san.model.EmailFromRecipient;
import com.san.model.EmailHeader;

@RequiredArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

	private MongoOperations operations;
	@Autowired
	MongoTemplate template;
	@Override
	public List<EmailHeader> findAll(Sort sort) {

		AggregationResults<EmailHeader> results = operations.aggregate(newAggregation(EmailHeader.class, //
				unwind("From"), //
				project("id", "Headers", "From"), //
				group("id") //
						.sum("From").as("FromCnt") //
				), EmailHeader.class);
		return results.getMappedResults();
	}
	public List<EmailFromRecipient> findAll() {
		Query q = new Query(new Criteria("messages"));
		return template.find(q, EmailFromRecipient.class);
	}
	public <S extends EmailHeader> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public <S extends EmailHeader> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public <S extends EmailHeader> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public Page<EmailHeader> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void delete(EmailHeader arg0) {
		// TODO Auto-generated method stub
		
	}
	public void delete(Iterable<? extends EmailHeader> arg0) {
		// TODO Auto-generated method stub
		
	}
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public Iterable<EmailHeader> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public EmailHeader findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public <S extends EmailHeader> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}