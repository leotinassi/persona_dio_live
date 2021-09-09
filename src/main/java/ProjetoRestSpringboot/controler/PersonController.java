package ProjetoRestSpringboot.controler;

import ProjetoRestSpringboot.dto.MessageresponseDTO;
import ProjetoRestSpringboot.entity.Person;
import ProjetoRestSpringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired // indica spring injeta uma implemetação do tipo Repository aqui para dentro, vantagem é para criar teste unitario.
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageresponseDTO createPerson(@RequestBody  Person person){
       Person savedPerson=personRepository.save(person);
        return MessageresponseDTO.builder()
                .message("Created person with ID"+ savedPerson.getId())
                .build();
    }
}
