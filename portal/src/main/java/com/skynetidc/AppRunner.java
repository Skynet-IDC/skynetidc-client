package com.skynetidc;

import com.skynetidc.client.WHMCS;
import com.skynetidc.client.payload.Payload;
import com.skynetidc.client.payload.d.DecryptPasswordPayload;
import com.skynetidc.client.payload.e.EncryptPasswordPayload;
import com.skynetidc.model.User;
import com.skynetidc.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final WHMCS whmcs;

	public AppRunner(UserRepository userRepository, PasswordEncoder passwordEncoder, WHMCS whmcs) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.whmcs = whmcs;
	}

	@Override
	public void run(String... args) throws Exception {

		// RestTemplate restTemplate = new RestTemplate();
		// HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// headers.add("Authorization", "Basic aG9hZHFAc2t5bmV0aWRjLmNvbTo/QiFTejkzKnlI");
		// HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		// ResponseEntity<String> response =
		// restTemplate.exchange("https://support.trumvps.vn/api/payment",
		// HttpMethod.GET, entity, String.class);

		// User user = userRepository.findByEmail("hoadq@skynetidc.com").get();
		// System.out.println(passwordEncoder.encode("?B!Sz93*yH"));

		// Payload payload = new DecryptPasswordPayload(user.getPassword());
		// JSONObject jsonObject = whmcs.submitPayload(payload);
		//
		// Payload payload1 = new EncryptPasswordPayload("12345678".toString());
		// JSONObject jsonObject1 = whmcs.submitPayload(payload1);
		// userRepository.findByEmail("hoadq@skynetidc.com");
		// System.out.println("hahaha");
	}

}
