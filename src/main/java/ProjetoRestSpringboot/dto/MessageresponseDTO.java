package ProjetoRestSpringboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageresponseDTO {
    private String message;
}
