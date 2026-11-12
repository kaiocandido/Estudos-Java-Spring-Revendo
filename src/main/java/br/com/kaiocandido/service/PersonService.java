package br.com.kaiocandido.service;

import br.com.kaiocandido.data.dto.PersonDtoV1;
import br.com.kaiocandido.data.dto.PersonDtoV2;
import br.com.kaiocandido.exception.ResourceNotFoundException;
import br.com.kaiocandido.mapper.Custom.PersonMapper;
import br.com.kaiocandido.model.Person;
import br.com.kaiocandido.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static br.com.kaiocandido.mapper.ObjectMapper.parseListObject;
import static br.com.kaiocandido.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;


    public PersonDtoV1 findById(Long id){
        logger.info("Finding one Person!!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(entity, PersonDtoV1.class);
    }

    public List<PersonDtoV1> findAll(){
        logger.info("Find all People!!");

        return parseListObject(personRepository.findAll(), PersonDtoV1.class);
    }

    public PersonDtoV1 create(PersonDtoV1 person){
        logger.info("Create Person!!");

        Person entity = parseObject(person, Person.class);

        return parseObject(personRepository.save(entity), PersonDtoV1.class);
    }

    public PersonDtoV2 createV2(PersonDtoV2 person){
        logger.info("Create Person V2!!");

        var entity = personMapper.convertDtoToEntity(person);

        return personMapper.convertEntityToDto(personRepository.save(entity));
    }

    public PersonDtoV1 update(PersonDtoV1 person){
        logger.info("Update Person!!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFistName(person.getFistName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDtoV1.class);
    }


    public void delete(Long id){
        logger.info("Delete one Person!!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }

}
