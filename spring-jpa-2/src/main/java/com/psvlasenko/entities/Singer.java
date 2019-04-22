package com.psvlasenko.entities;
import java.io.Serializable;
import java.util.Date;

public class Singer implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Singer(
        Long id,
        int version,
        String firstName,
        String lastName,
        Date birthDate
    ) {
        this.id = id;
        this.version = version;
        this.lastName = firstName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
