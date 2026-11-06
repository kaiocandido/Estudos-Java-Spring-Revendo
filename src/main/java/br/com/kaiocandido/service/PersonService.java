package br.com.kaiocandido.service;

import br.com.kaiocandido.data.dto.PersonDto;
import br.com.kaiocandido.exception.ResourceNotFoundException;
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


    public PersonDto findById(Long id){
        logger.info("Finding one Person!!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(entity, PersonDto.class);
    }

    public List<PersonDto> findAll(){
        logger.info("Find all People!!");

        return parseListObject(personRepository.findAll(), PersonDto.class);
    }

    public PersonDto create(PersonDto person){
        logger.info("Create Person!!");

        Person entity = parseObject(person, Person.class);

        return parseObject(personRepository.save(entity), PersonDto.class);
    }

    public PersonDto update(PersonDto person){
        logger.info("Update Person!!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFistName(person.getFistName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDto.class);
    }


    public void delete(Long id){
        logger.info("Delete one Person!!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(entity);
    }

}
