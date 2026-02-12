package com.skynetidc.security;

import com.skynetidc.client.WHMCS;
import com.skynetidc.client.payload.Payload;
import com.skynetidc.client.payload.d.DecryptPasswordPayload;
import com.skynetidc.client.payload.e.EncryptPasswordPayload;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.Objects;

public class WhmcsPasswordEncoder implements PasswordEncoder {

	private final Logger LOGGER = LoggerFactory.getLogger(WhmcsPasswordEncoder.class);

	private final WHMCS WHMCS;

	public WhmcsPasswordEncoder(WHMCS whmcs) {
		this.WHMCS = whmcs;
	}

	@Override
	public String encode(CharSequence rawPassword) {
		Payload payload = new EncryptPasswordPayload(rawPassword.toString());
		try {
			JSONObject jsonObject = WHMCS.submitPayload(payload);
			return jsonObject.get("password").toString();
		}
		catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (rawPassword.isEmpty()) {
			throw new IllegalArgumentException("rawPassword cannot be null");
		}
		if (Objects.nonNull(encodedPassword) && !encodedPassword.isEmpty()) {
			Payload payload = new DecryptPasswordPayload(encodedPassword);
			try {
				JSONObject jsonObject = WHMCS.submitPayload(payload);
				return rawPassword.toString().equals(jsonObject.get("password").toString());
			}
			catch (Exception e) {
				return false;
			}
		}
		else {
			LOGGER.warn("Empty encoded password");
			return false;
		}
	}

	@Override
	public boolean upgradeEncoding(String encodedPassword) {
		return PasswordEncoder.super.upgradeEncoding(encodedPassword);
	}

}
