package ProjetoRestSpringboot.dto.request;

import ProjetoRestSpringboot.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


//classe criada para clonar e fazer transferencia de objetos dados
@Data //vem da depencencia Lombok, adiciona automatico getters e setters
@Builder // padrão de projetos de construção  de objetos
@AllArgsConstructor // insere construtor
@NoArgsConstructor //insere construtor
public class PhoneDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}
