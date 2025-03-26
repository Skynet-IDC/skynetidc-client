package com.skynetidc.client.payload.d;

import com.skynetidc.client.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation. API documentation
 * can be found at the following URL:
 * https://developers.whmcs.com/api-reference/deletecontact/
 */
public class DeleteContactPayload extends Payload {

	/***
	 * @param contactID The ID of the contact to be deleted
	 */
	public DeleteContactPayload(int contactID) {
		super("DeleteContact");
		put("contactid", contactID);
	}

}
