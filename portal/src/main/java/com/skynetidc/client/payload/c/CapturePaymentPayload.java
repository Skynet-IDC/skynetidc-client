package com.skynetidc.client.payload.c;

import com.skynetidc.client.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation. API documentation
 * can be found at the following URL:
 * https://developers.whmcs.com/api-reference/capturepayment/
 */
public class CapturePaymentPayload extends Payload {

	/***
	 * @param invoiceID The ID of the pending order
	 */
	public CapturePaymentPayload(int invoiceID) {
		super("CapturePayment");
		put("invoiceid", invoiceID);
	}

	/***
	 * @param CVV The CVV Number for the card being attempted
	 * @return This Payload, for chaining
	 */
	public CapturePaymentPayload withCVV(String CVV) {
		put("cvv", CVV);
		return this;
	}

}
