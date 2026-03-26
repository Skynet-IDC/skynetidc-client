package com.skynetidc.services.impl;

import com.skynetidc.client.WHMCS;
import com.skynetidc.client.payload.Payload;
import com.skynetidc.client.payload.a.AddInvoicePaymentPayload;
import com.skynetidc.client.payload.a.AddOrderPayload;
import com.skynetidc.client.payload.c.CreateInvoicePayload;
import com.skynetidc.client.payload.m.ModuleSuspendPayload;
import com.skynetidc.dto.OrderRequest;
import com.skynetidc.enums.InvoiceStatus;
import com.skynetidc.enums.OrderStatus;
import com.skynetidc.model.Hosting;
import com.skynetidc.model.Invoice;
import com.skynetidc.model.Order;
import com.skynetidc.repository.HostingRepository;
import com.skynetidc.repository.InvoiceRepository;
import com.skynetidc.repository.OrderRepository;
import com.skynetidc.services.VPSService;
import com.skynetidc.util.SecurityUtil;
import com.skynetidc.vo.ResponseResult;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class VPSServiceImpl implements VPSService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private final HostingRepository hostingRepository;

	private final InvoiceRepository invoiceRepository;

	private final OrderRepository orderRepository;

	private final SecurityUtil securityUtil;

	private final WHMCS whmcs;

	public VPSServiceImpl(HostingRepository hostingRepository, InvoiceRepository invoiceRepository,
			OrderRepository orderRepository, SecurityUtil securityUtil, WHMCS whmcs) {
		this.hostingRepository = hostingRepository;
		this.invoiceRepository = invoiceRepository;
		this.orderRepository = orderRepository;
		this.securityUtil = securityUtil;
		this.whmcs = whmcs;
	}

	@Override
	public ResponseResult getVPSById(long id) {
		Optional<Hosting> hosting = hostingRepository.findById(id);
		ResponseResult resultVO = ResponseResult.instance();
		resultVO.setItem(hosting.orElse(new Hosting()));
		return resultVO;
	}

	@Override
	public void suspendById(long id) {
		try {
			Payload payload = new ModuleSuspendPayload(id).withSuspendReason("Suspend server");
			whmcs.submitPayload(payload);
		}
		catch (Exception e) {
			LOGGER.error("Error while suspend service", e);
		}
	}

	@Override
	public ResponseResult<Hosting> listAllVpsByOwner(long ownerId) {
		List<Hosting> hostings = hostingRepository.findByUserid(ownerId, List.of("default"));
		ResponseResult<Hosting> resultVO = ResponseResult.instance();
		resultVO.setItems(hostings);
		return resultVO;
	}

	@Override
	public void createVPS(OrderRequest request) {
		try {
			Payload payloadInvoice = new CreateInvoicePayload(securityUtil.clientIdAuth())
				.withStatus(InvoiceStatus.UNPAID.getCode())
				.withPaymentMethod(request.getPaymentMethod());
			JSONObject result = whmcs.submitPayload(payloadInvoice);

			Order order = new Order();
			order.setOrdernum(getRandomBigInteger());
			order.setUserid(securityUtil.userIdAuth());
			order.setRequestorId(securityUtil.userIdAuth());
			order.setAdminRequestorId(1);
			order.setDate(Instant.now());
			order.setAmount(new BigDecimal("12981"));
			order.setPaymentmethod(request.getPaymentMethod());
			order.setInvoiceid(Integer.parseInt(result.get("invoiceid").toString()));
			order.setStatus(OrderStatus.ACTIVE.getCode());
			order.setIpaddress("2001:ee0:4181:1f92:b9bb:2a8:b909:86cf");

			orderRepository.saveAndFlush(order);
		}
		catch (Exception e) {
			LOGGER.error("Error while signing up", e);
		}
	}

	public static BigInteger getRandomBigInteger() {
		Random rand = new Random();
		// (2^4-1) = 15 is the maximum value
		return new BigInteger(4, rand);
	}

	@Override
	public void createHosting(OrderRequest request) {

	}

}
