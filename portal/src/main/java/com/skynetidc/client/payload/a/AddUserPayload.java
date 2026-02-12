package com.skynetidc.client.payload.a;

import com.skynetidc.client.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation. API documentation
 * can be found at the following URL:
 * https://developers.whmcs.com/api-reference/addclient/
 */
public class AddUserPayload extends Payload {

	/***
	 * @param firstName The first name of this client
	 * @param lastName The last name of this client
	 * @param email The email address of this client
	 * @param password The password of this client
	 * @param language The phone number of this client
	 *
	 */
	public AddUserPayload(String firstName, String lastName, String email, String password, String language) {
		super("AddUser");
		put("firstname", firstName);
		put("lastname", lastName);
		put("email", email);
		put("password2", password);
		put("language", language);
	}

}
