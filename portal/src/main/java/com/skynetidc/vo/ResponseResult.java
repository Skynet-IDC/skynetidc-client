package com.skynetidc.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynetidc.enums.ResultEnum;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ResponseResult<T> implements Serializable {

	private String code;

	private String message;

	private Collection<T> items;

	private T item;

	private Object extra;

	private Integer count = 0;

	private Integer page = 0;

	private Integer pageSize = 0;

	public ResponseResult() {
	}

	public ResponseResult(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}

	public ResponseResult(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseResult(String code, String message, List<T> items) {
		this.code = code;
		this.message = message;
		this.items = items;
	}

	public ResponseResult(String code, String message, T item) {
		this.code = code;
		this.message = message;
		this.item = item;
	}

	public ResponseResult(T item) {
		this.code = ResultEnum.SUCCESS.getCode();
		this.message = ResultEnum.SUCCESS.getMessage();
		this.item = item;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<T> getItems() {
		return items;
	}

	public void setItems(Collection<T> items) {
		this.items = items;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}

	public static ResponseResult success() {
		return new ResponseResult(ResultEnum.SUCCESS);
	}

	public static ResponseResult fail() {
		return new ResponseResult(ResultEnum.FAIL);
	}

	public static ResponseResult instance(String code, String message) {
		return new ResponseResult(code, message);
	}

	public static ResponseResult instance(ResultEnum resultEnum) {
		return new ResponseResult(resultEnum.getCode(), resultEnum.getMessage());
	}

	public static ResponseResult instance() {
		return new ResponseResult();
	}

	public boolean isSuccess() {
		return ResultEnum.SUCCESS.getCode() == this.code;
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this);
	}

}
