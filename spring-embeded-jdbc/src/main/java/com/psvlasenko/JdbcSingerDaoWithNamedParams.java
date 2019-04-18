package com.psvlasenko;

import com.psvlasenko.dao.SingerDao;
import com.psvlasenko.entities.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcSingerDaoWithNamedParams implements SingerDao, InitializingBean {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.namedParameterJdbcTemplate = jdbcTemplate;
	}

	@Override public String findNameById(Long id) {
		String sql = "select first_name || ' ' || last_name from singer where id = :singerId";
		Map<String, Object> namedParams = new HashMap<>();
		namedParams.put("singerId", id);

		return namedParameterJdbcTemplate.queryForObject(sql, namedParams, String.class);
	}

	@Override
	public String findFirstNameById(Long id) {
		String sql = "select first_name from singer where id = :singerId";
		Map<String, Object> namedParams = new HashMap<>();
		namedParams.put("singerId", id);

		return namedParameterJdbcTemplate.queryForObject(sql, namedParams, String.class);
	}

	@Override public List<Singer> findAll() {
		throw new NotImplementedException("findAll");
	}

	@Override public List<Singer> findByFirstName(String firstName) {
		throw new NotImplementedException("findByFirstName");
	}



	@Override public String findLastNameById(Long id) {
		throw new NotImplementedException("findLastNameById");
	}

	@Override public void insert(Singer singer) {
		throw new NotImplementedException("insert");
	}

	@Override public void update(Singer singer) {
		throw new NotImplementedException("update");
	}

	@Override public void delete(Long singerId) {
		throw new NotImplementedException("delete");
	}

	@Override public List<Singer> findAllWithAlbums() {
		throw new NotImplementedException("findAllWithAlbums");
	}

	@Override public void insertWithAlbum(Singer singer) {
		throw new NotImplementedException("insertWithAlbum");
	}

	@Override public void afterPropertiesSet() throws Exception {
		if (namedParameterJdbcTemplate == null) {
			throw new BeanCreationException("Null namedParameterJdbcTemplate on SingerDao");
		}
	}

}
