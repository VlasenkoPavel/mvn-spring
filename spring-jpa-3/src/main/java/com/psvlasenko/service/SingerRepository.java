package com.psvlasenko.service;

import com.psvlasenko.domain.Singer;
import com.psvlasenko.infrastructure.entities.SingerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SingerRepository implements ISingerRepository {
    final static String ALL_SINGER_NATIVE_QUERY =
        "select id, first_name, last_name, birth_date, version from singer";

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);


    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Singer> findAll() {
        List<SingerRecord> records = em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, SingerRecord.class).getResultList();
        var singers = new ArrayList<Singer>();

        for (SingerRecord record : records) {
            singers.add(new Singer(record));
        }

        return singers;
    }
}
