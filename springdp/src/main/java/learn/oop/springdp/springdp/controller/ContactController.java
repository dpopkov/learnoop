package learn.oop.springdp.springdp.controller;

import learn.oop.springdp.springdp.builder.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @GetMapping("/presidents")
    public List<Contact> getPresidents() {
        List<Contact> contacts = new ArrayList<>();

        Contact gw = new Contact();
        gw.setFirstName("George");
        gw.setLastName("Washington");
        contacts.add(gw);

        Contact ja = new Contact("John", "Adams", null);
        contacts.add(ja);

        contacts.add(Contact.builder().firstName("Thomas").lastName("Jefferson").build());

        return contacts;
    }
}
