package com.alkemy.challengebackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idRol;

    private String name;

}
