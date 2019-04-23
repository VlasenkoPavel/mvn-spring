package com.psvlasenko.domain;

import java.util.Date;

public interface ISingerDto {
    Long getId();
    int getVersion();
    String getFirstName();
    String getLastName();
    Date getBirthDate();
}
