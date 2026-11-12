package br.com.kaiocandido.controllers;

import br.com.kaiocandido.data.dto.PersonDtoV1;
import br.com.kaiocandido.data.dto.PersonDtoV2;
import br.com.kaiocandido.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/findById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDtoV1 findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    @GetMapping(value = "/findAll",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDtoV1> findAll(){
        return personService.findAll();
    }

    @PostMapping(value = "/create",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDtoV1 create(@RequestBody PersonDtoV1 person){
        return personService.create(person);
    }

    @PostMapping(value = "/createV2",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDtoV2 create(@RequestBody PersonDtoV2 person){
        return personService.createV2(person);
    }

    @PutMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDtoV1 update(@RequestBody PersonDtoV1 person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personService.delete(id);

        return ResponseEntity.noContent().build();
    }



}