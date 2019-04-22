package com.psvlasenko.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

@NamedNativeQuery(
    name=SingerCfg.FIND_ALL,
    query=SingerCfg.baseSql,
    resultSetMapping = "singerResult"
)

@NamedNativeQuery(
    name=SingerCfg.FIND_SINGER_BY_ID,
    query=SingerCfg.baseSql + "where s.id = :id",
    resultSetMapping = "singerResult"
)

@SqlResultSetMapping(name="singerResult",
    classes = {
        @ConstructorResult(targetClass = Singer.class, columns = {
        @ColumnResult(name="id", type = Long.class),
        @ColumnResult(name="version", type = Integer.class),
        @ColumnResult(name="firstName", type = String.class),
        @ColumnResult(name="lastName", type = String.class),
        @ColumnResult(name="birthDate", type = Date.class)
    }
)})

@Entity
public class SingerCfg implements Serializable {
    private static final String ID2 = "id";
    public static final String baseSql = "select s.Id AS id, s.VERSION AS version,"
    + "s.FIRST_NAME AS firstName, s.LAST_NAME AS lastName, BIRTH_DATE AS birthDate "
    + "from SINGER s";
	public static final String FIND_ALL = "Singer.findAll";
	public static final String FIND_SINGER_BY_ID = "Singer.findById";

    @Id
    private Long id;
}
