package br.com.kaiocandido;

import br.com.kaiocandido.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one Person!!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("Kaio");
        person.setLastName("Candido");
        person.setAddress("Rua dos bobos");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll(){
        logger.info("Find all People!!");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        logger.info("Finding one Person!!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFistName("FirstName " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Address " + i);
        if(i % 2 == 0) {
            person.setGender("Male");
        }else {
            person.setGender("Female");
        }

        return person;
    }

    public Person create(Person person){
        logger.info("Create Person!!");
        return person;
    }

    public Person update(Person person){
        logger.info("Update Person!!");

        return person;
    }


    public void delete(String id){
        logger.info("Delete one Person!!");
    }

}
