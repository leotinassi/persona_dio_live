package ProjetoRestSpringboot.controler;

import ProjetoRestSpringboot.dto.MessageresponseDTO;
import ProjetoRestSpringboot.dto.request.PersonDTO;
import ProjetoRestSpringboot.entity.Person;
import ProjetoRestSpringboot.exception.PersonNotFoundException;
import ProjetoRestSpringboot.repository.PersonRepository;
import ProjetoRestSpringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;
    @Autowired

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageresponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);

    }
    @GetMapping
    public List<PersonDTO> listALL(){
         return personService.listALL();

    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
}
