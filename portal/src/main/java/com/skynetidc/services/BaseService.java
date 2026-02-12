package com.skynetidc.services;

import com.skynetidc.model.BaseModel;
import com.skynetidc.repository.BaseRepository;

import java.util.List;

public interface BaseService<M extends BaseRepository, E extends BaseModel> {

	/**
	 * 添加数据
	 * @param entity
	 * @return
	 */
	E add(E entity);

	/**
	 * 根据 ID 主键删除数据
	 * @param id
	 * @return
	 */
	boolean deleteById(Long id);

	/**
	 * 查询所有的元素
	 * @return
	 */
	List<E> getAllItems();

	/**
	 * 分页查询, 根据实体中的属性查询,查询条件使用等号
	 * @param entity
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<E> getItemsByPage(E entity, int page, int pageSize);

	/**
	 * 根据实体中的属性进行查询列表
	 * @param record
	 * @return
	 */
	List<E> getItems(E record);

	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param record
	 * @return
	 */
	E getItem(E record);

	E getItemById(Object id);

	/**
	 * 根据多个ID查询列表
	 * @param ids
	 * @return
	 */
	List<E> getItemsByIds(List ids);

	/**
	 * 根据主键更新属性不为null的值
	 * @param entity
	 * @return
	 */
	boolean update(E entity);

	/**
	 * 根据主键更新实体全部字段，null值会被更新
	 * @param entity
	 * @return
	 */
	boolean fullUpdate(E entity);

}
