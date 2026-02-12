package com.skynetidc.services.impl;

import com.skynetidc.model.BaseModel;
import com.skynetidc.repository.BaseRepository;
import com.skynetidc.services.BaseService;

import java.util.List;

public class BaseServiceImpl<M extends BaseRepository, E extends BaseModel> implements BaseService<M, E> {

	@Override
	public E add(E entity) {
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		return false;
	}

	@Override
	public List<E> getAllItems() {
		return null;
	}

	@Override
	public List<E> getItemsByPage(E entity, int page, int pageSize) {
		return null;
	}

	@Override
	public List<E> getItems(E record) {
		return null;
	}

	@Override
	public E getItem(E record) {
		return null;
	}

	@Override
	public E getItemById(Object id) {
		return null;
	}

	@Override
	public List<E> getItemsByIds(List ids) {
		return null;
	}

	@Override
	public boolean update(E entity) {
		return false;
	}

	@Override
	public boolean fullUpdate(E entity) {
		return false;
	}

}
