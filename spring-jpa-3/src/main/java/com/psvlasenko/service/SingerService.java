package com.psvlasenko.service;

import com.psvlasenko.infrastructure.entities.SingerRecord;

import java.util.List;

public interface SingerService {
    List<SingerRecord> findAll();
    List<SingerRecord> findAllWithAlbum();
    SingerRecord findById(Long id);
    SingerRecord save(SingerRecord singer);
    void delete(SingerRecord singer);
    List<SingerRecord> findAllByNativeQuery();
}
