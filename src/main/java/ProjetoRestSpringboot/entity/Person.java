package ProjetoRestSpringboot.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Person")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)//Obrigando o preencher e o "unique significa que é unico".
    private String cpf;

    @Column
    private String birthData;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})// relacionamento de 1xn utilizando fetch
    private List<Phone> phones;

}
