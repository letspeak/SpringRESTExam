package com.san;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.san.model.EmailRecipient;
import com.san.repository.EmailRecipientRepository;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class EmailRecipientRepositoryTest {

    @Resource
    EmailRecipientRepository repository;
    
    @Test
    public void testAllPerson() {
    	List<EmailRecipient> listPerson = repository.findAll();
        assertThat(listPerson.size(),is(120477));
    }
    
    /*@Test
    public void testSaveAuthor() {
        Person person = new Person();
        person.setFirstName("Bob");
        person.setLastName("Ronald");
        
        repository.save(person);
        List<Person> listPerson = repository.findAll();
        assertThat(listPerson.size(),is(2));
    }*/

}