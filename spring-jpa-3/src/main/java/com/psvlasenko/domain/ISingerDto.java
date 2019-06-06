package com.psvlasenko.domain;

import java.util.Date;

public interface ISingerDto {
    default Long getId() { return new Long(0); };
    default int getVersion() { return 0; };
    default String getFirstName() { return ""; };
    default String getLastName() { return ""; };
    default Date getBirthDate() { return new Date(); };
}
