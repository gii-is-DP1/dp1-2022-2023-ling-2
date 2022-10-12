package org.springframework.samples.endofline.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.samples.endofline.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {


	  @GetMapping({"/","/welcome"})
	  public String welcome(Map<String, Object> model) {
          List<Person> persons = new ArrayList<>();
          Person m1 = new Person();
          m1.setFirstName("Antonio");
          m1.setLastName("Rodríguez Ruiz");
          persons.add(m1);
          Person m2 = new Person();
          m2.setFirstName("Juan Pedro");
          m2.setLastName("Gálvez López");
          persons.add(m2);
          Person m3 = new Person();
          m3.setFirstName("Victoria Eugenia");
          m3.setLastName("Moreno Contreras");
          persons.add(m3);
          Person m4 = new Person();
          m4.setFirstName("Alin");
          m4.setLastName("Bonciu");
          persons.add(m4);
          model.put("persons", persons);
          model.put("title", "Pet Shop");
          model.put("group", "LING2");

	    return "welcome";
	  }
}
