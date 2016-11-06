package com.sz.et.interfaces;

import java.util.List;

import com.sz.et.models.Word;

public interface IDao<T> {
	T get(int id);
	void save(T entity);
	void update(Word entity);
	void delete(int id);
	List<T> getAll();
}
