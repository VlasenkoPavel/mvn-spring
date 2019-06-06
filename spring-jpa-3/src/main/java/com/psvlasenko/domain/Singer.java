package com.psvlasenko.domain;

import java.util.Date;

public class Singer {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public class Dto {
        public Long getId() { return id; };
        public int getVersion() { return version; };
        public String getFirstName() { return firstName; };
        public String getLastName() { return lastName; };
        public Date getBirthDate() { return birthDate; };
    }

    public Singer(ISingerDto dto) {
        id = dto.getId();
        version = dto.getVersion();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        birthDate = dto.getBirthDate();
    }

    public Dto dto() {
        return new Dto();
    }

    public String getFulName() {
        return firstName + " " + lastName;
    }
}
