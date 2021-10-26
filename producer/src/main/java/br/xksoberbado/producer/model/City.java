package br.xksoberbado.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class City implements Serializable {

    private String name;
    private String UF;

}
