package com.skynetidc.client.payload.g;

import com.skynetidc.client.payload.Payload;

public class GetEmailTemplatesPayload extends Payload {

	public GetEmailTemplatesPayload() {
		super("GetEmailTemplates");
	}

	/***
	 * @param type The type of email template to retrieve
	 */
	public GetEmailTemplatesPayload withautype(String type) {
		put("type", type);
		return this;
	}

	/***
	 * @param language The language of the email template to retrieve, if none provided
	 * will return default language templates.
	 */
	public GetEmailTemplatesPayload withaulanguage(String language) {
		put("language", language);
		return this;
	}

}
