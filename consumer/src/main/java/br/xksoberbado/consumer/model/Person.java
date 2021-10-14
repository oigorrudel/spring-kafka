package br.xksoberbado.consumer.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {

    private String name;
    private Integer age;

}
