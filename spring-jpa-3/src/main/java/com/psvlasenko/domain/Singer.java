package com.psvlasenko.domain;

import java.util.Date;

public class Singer {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Singer(ISingerDto dto) {
        id = dto.getId();
        version = dto.getVersion();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        birthDate = dto.getBirthDate();
    }
}
