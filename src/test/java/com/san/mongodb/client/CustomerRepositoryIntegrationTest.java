package com.san.mongodb.client;

import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.san.config.ApplicationConfiguration;
import com.san.model.EmailHeader;
import com.san.repository.CustomRepository;
import com.san.util.MongoDBTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
public class CustomerRepositoryIntegrationTest {

	@ClassRule public static MongoDBTestUtil mongodbAvailable = MongoDBTestUtil.anyVersion();
	@Autowired CustomRepository repository;

	EmailHeader emailHeader;

	@Before
	public void setUp() {

		//nothing to do
	}
	@Test
	public void findCustomersUsingQuerydslSort() {
		List<EmailHeader> result = repository.findAll();
		assertThat(result, not(hasSize(0)));
	}
}