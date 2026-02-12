package com.skynetidc.services;

import com.skynetidc.dto.OrderRequest;
import com.skynetidc.vo.ResponseResult;

public interface VPSService {

	ResponseResult getVPSById(long id);

	void suspendById(long id);

	ResponseResult listAllVpsByOwner();

	void createVPS(OrderRequest request);

	void createHosting(OrderRequest request);

}
