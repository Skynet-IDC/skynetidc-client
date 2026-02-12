package com.skynetidc.client.payload.g;

import com.skynetidc.client.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation. API documentation
 * can be found at the following URL:
 * https://developers.whmcs.com/api-reference/getticketpredefinedreplies/
 */
public class GetTicketPredefinedRepliesPayload extends Payload {

	public GetTicketPredefinedRepliesPayload() {
		super("GetTicketPredefinedReplies");
	}

	/***
	 * @param catID Obtain predefined replies for a specific category id
	 */
	public GetTicketPredefinedRepliesPayload withCatID(int catID) {
		put("catid", catID);
		return this;
	}

}
