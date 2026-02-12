package com.skynetidc.services.impl;

import com.skynetidc.model.OperatingSystem;
import com.skynetidc.repository.OperatingSystemRepository;
import com.skynetidc.services.OperatingSystemService;
import com.skynetidc.vo.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatingSystemServiceImpl implements OperatingSystemService {

	private final OperatingSystemRepository operatingSystemRepository;

	public OperatingSystemServiceImpl(OperatingSystemRepository operatingSystemRepository) {
		this.operatingSystemRepository = operatingSystemRepository;
	}

	@Override
	public ResponseResult getByCode(String code) {
		Optional<List<OperatingSystem>> optionalOperatingSystems = operatingSystemRepository.findByCode(code);
		ResponseResult result = ResponseResult.instance();
		result.setItems(optionalOperatingSystems.get());
		return result;
	}

}
