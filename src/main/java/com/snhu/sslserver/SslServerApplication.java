package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController {

	private static String bytesToHex(byte[] hash) {
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 128) {
			hexString.insert(0, '0');
		}
		return hexString.toString();
	}

	@RequestMapping
	public String myHash(){
		String data = "Hello World Check Sum! - John Swindell";
		String algorithm = "SHA-512";
		String checksum = "";

		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] hashBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));

			checksum = bytesToHex(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "Error";
		}

		return "<p>Data: " + data + "</p>" +
				"<p>Algorithm: " + algorithm + "</p>" +
				"<p>Checksum: " + checksum + "</p>";
	}

}