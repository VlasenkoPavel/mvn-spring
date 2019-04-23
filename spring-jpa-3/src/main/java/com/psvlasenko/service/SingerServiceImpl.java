package com.psvlasenko.service;

import com.psvlasenko.infrastructure.entities.SingerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service("jpaSingerService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SingerServiceImpl implements SingerService {
    final static String ALL_SINGER_NATIVE_QUERY =
        "select id, first_name, last_name, birth_date, version from singer";

    private static Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);


    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<SingerRecord> findAll() {
        return em.createNamedQuery(SingerRecord.FIND_ALL, SingerRecord.class).getResultList();
    }

    @Transactional(readOnly=true)
    @Override
    public List<SingerRecord> findAllWithAlbum() {
        List<SingerRecord> singers = em.createNamedQuery(SingerRecord.FIND_ALL_WITH_ALBUM, SingerRecord.class).getResultList();
        return singers;
    }

    @Transactional(readOnly=true)
    @Override
    public SingerRecord findById(Long id) {
        TypedQuery<SingerRecord> query = em.createNamedQuery(SingerRecord.FIND_SINGER_BY_ID, SingerRecord.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public SingerRecord save(SingerRecord singer) {
        if (singer.getId() == null) {
            logger.info("Inserting new singer");
            em.persist(singer);
        } else {
            em.merge(singer);
            logger.info("Updating existing singer");
        }

        logger.info("Singer saved with id: " + singer.getId());

        return singer;
    }

    @Override
    public void delete(SingerRecord singer) {
        SingerRecord mergedContact = em.merge(singer);
        em.remove(mergedContact);

        logger.info("Singer with id: " + singer.getId()  + " deleted successfully");
    }

    @Transactional(readOnly=true)
    @Override
    public List<SingerRecord> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_SINGER_NATIVE_QUERY, "singerResult").getResultList();
    }
}
