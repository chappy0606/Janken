package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	public String toPassCode(String pass) {
		String hashed = "";

		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(pass.getBytes());
			
			BigInteger bi = new BigInteger(1, hash);
			pass = String.format("%0" + (hash.length << 1) + "x", bi);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return pass;

	}
}
