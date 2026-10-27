package br.com.kaiocandido.service;

import br.com.kaiocandido.exception.ResourceNotFoundException;
import br.com.kaiocandido.model.Person;
import br.com.kaiocandido.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository personRepository;


    public Person findById(Long id){
        logger.info("Finding one Person!!");

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll(){
        logger.info("Find all People!!");

        return personRepository.findAll();
    }

    public Person create(Person person){
        logger.info("Create Person!!");

        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Update Person!!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFistName(person.getFistName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }


    public void delete(Long id){
        logger.info("Delete one Person!!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }

}
