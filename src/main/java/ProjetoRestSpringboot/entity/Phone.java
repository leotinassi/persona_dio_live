package ProjetoRestSpringboot.entity;

import ProjetoRestSpringboot.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity //esta indicando que  que esta classe é uma entidade
@Data //vem da depencencia Lombok, adiciona automatico getters e setters
@Builder // padrão de projetos de construção  de objetos
@AllArgsConstructor // insere construtor
@NoArgsConstructor //insere construtor

public class Phone {

    @Id // chave primaria pra classe/entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para Gerar automatico os ids com identidade unica
    private Long id;

    @Enumerated(EnumType.STRING) //com isso sera inserido o Phone como foi escrito na Classe Enums
    @Column(nullable = false)//criando regra de constraint no banco, jpa ira criar esse campo com notnull
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
