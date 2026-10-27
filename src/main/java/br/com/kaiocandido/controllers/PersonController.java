package br.com.kaiocandido.controllers;

import br.com.kaiocandido.service.PersonService;
import br.com.kaiocandido.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/findById/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){
        return personService.findAll();
    }

    @RequestMapping(value = "/create",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        personService.delete(id);
    }



}