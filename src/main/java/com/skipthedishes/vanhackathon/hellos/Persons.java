package com.skipthedishes.vanhackathon.hellos;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface Persons extends CrudRepository<Person, Long> {

}
