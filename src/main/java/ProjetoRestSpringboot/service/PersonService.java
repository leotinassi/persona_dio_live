package ProjetoRestSpringboot.service;

import ProjetoRestSpringboot.mapper.PersonMapper;
import ProjetoRestSpringboot.dto.MessageresponseDTO;
import ProjetoRestSpringboot.dto.request.PersonDTO;
import ProjetoRestSpringboot.entity.Person;
import ProjetoRestSpringboot.repository.PersonRepository;
import ProjetoRestSpringboot.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageresponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson=personRepository.save(personToSave);
        return MessageresponseDTO.builder()
                .message("Created person with ID"+ savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listALL() { //metodo para listar todas pessoas salvas.
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        //optional  evita verificções como nula

        return personMapper.toDTO(person);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public void delete(Long id) throws PersonNotFoundException{
        verifyIfExists(id);
        
        personRepository.deleteById(id);
    }

    public MessageresponseDTO uptadeById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpate = personMapper.toModel(personDTO);

        Person savedPerson=personRepository.save(personToUpate);
        return createMessageResponse(savedPerson);
    }

    private MessageresponseDTO createMessageResponse(Person savedPerson) {
        return MessageresponseDTO.builder()
                .message("Update person with ID"+ savedPerson.getId())
                .build();
    }
}
