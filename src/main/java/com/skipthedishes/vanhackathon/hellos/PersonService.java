package com.skipthedishes.vanhackathon.hellos;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class PersonService {

    private Persons persons;

    @Autowired
    PersonService(Persons persons) {
        this.persons = persons;
    }

    public Person create(Person person) {
        if(StringUtils.isEmpty(person.getName())){
            throw new IllegalArgumentException("Invalid argument to person="+person.getName());
        }
        return persons.save(person);
    }

}
