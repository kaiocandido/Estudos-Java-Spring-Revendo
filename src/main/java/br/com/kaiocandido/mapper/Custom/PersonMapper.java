package br.com.kaiocandido.mapper.Custom;

import br.com.kaiocandido.data.dto.PersonDtoV2;
import br.com.kaiocandido.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDtoV2 convertEntityToDto(Person person) {
        PersonDtoV2 dto = new PersonDtoV2();

        dto.setFistName(person.getFistName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBirthDay(new Date());

        return dto;
    }


    public Person convertDtoToEntity(PersonDtoV2 person) {
        Person dto = new Person();

        dto.setFistName(person.getFistName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        //dto.setBirthDay(new Date());

        return dto;
    }
}
