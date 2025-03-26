package com.skynetidc.client.payload;

import org.json.JSONObject;

public abstract class Payload extends JSONObject {

	public Payload(String action) {
		super();
		put("action", action);
	}

}
