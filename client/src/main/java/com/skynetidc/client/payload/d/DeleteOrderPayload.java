package com.skynetidc.client.payload.d;

import com.skynetidc.client.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation. API documentation
 * can be found at the following URL:
 * https://developers.whmcs.com/api-reference/deleteorder/
 */
public class DeleteOrderPayload extends Payload {

	/***
	 * @param orderID The ID of the order to be deleted
	 */
	public DeleteOrderPayload(int orderID) {
		super("DeleteOrder");
		put("orderid", orderID);
	}

}
