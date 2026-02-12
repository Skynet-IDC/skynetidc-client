package com.skynetidc.services.impl;

import com.skynetidc.model.Product;
import com.skynetidc.repository.PlanRepository;
import com.skynetidc.repository.ProductRepository;
import com.skynetidc.services.PlanService;
import com.skynetidc.vo.ResponseResult;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

	private final PlanRepository planRepository;

	private final ProductRepository productRepository;

	public PlanServiceImpl(PlanRepository planRepository, ProductRepository productRepository) {
		this.planRepository = planRepository;
		this.productRepository = productRepository;
	}

	@Override
	public ResponseResult getPlanByGroup(String location) {
		Optional<List<Product>> products = productRepository.findByGid(2);
		ResponseResult resultVO = ResponseResult.instance();
		products.ifPresent(resultVO::setItems);
		return resultVO;
	}

}
