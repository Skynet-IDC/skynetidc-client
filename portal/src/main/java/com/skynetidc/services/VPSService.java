package com.skynetidc.services;

import com.skynetidc.dto.OrderRequest;
import com.skynetidc.model.Hosting;
import com.skynetidc.vo.ResponseResult;

public interface VPSService {

	ResponseResult getVPSById(long id);

	void suspendById(long id);

	ResponseResult<Hosting> listAllVpsByOwner(long ownerId);

	void createVPS(OrderRequest request);

	void createHosting(OrderRequest request);

}
