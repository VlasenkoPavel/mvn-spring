package com.psvlasenko.service;

import java.util.List;

import com.psvlasenko.domain.Singer;

public interface ISingerRepository {
    List<Singer> findAll();
    // List<Singer> findAllWithAlbum();
    // Singer findById(Long id);
    // Singer save(Singer singer);
    // void delete(Singer singer);
    // List<Singer> findAllByNativeQuery();
}
