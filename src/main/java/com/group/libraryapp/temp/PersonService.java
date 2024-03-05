package com.group.libraryapp.temp;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    public PersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }
    @Transactional
    public void savePerson() {
        Person person = personRepository.save(new Person());
        Address address = addressRepository.save(new Address());
        person.setAddress(address);
        address.getPerson();
    }




}
