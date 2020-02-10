package br.com.temspotify.dao;

import java.util.List;

public interface GenericDao {
	public void create(Object o);

	public List<Object> read(Object o);

	public void update(Object o);

	public void delete(Object o);
}
