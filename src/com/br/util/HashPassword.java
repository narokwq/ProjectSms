package com.br.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {
	public static String convertHash(String hash) throws NoSuchAlgorithmException{

		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		String result = DigestUtils.sha1Hex(mDigest.digest(hash.getBytes()));
		
		return result;
	}
	
	public static String uniqueLink() {
	    final String[] passwords = new String[] {
	        "ALKJVBPIQYTUIWEBVPQALZVKQRWORTUYOYISHFLKAJMZNXBVMNFGAHKJSDFALAPOQIERIUYTGSFGKMZNXBVJAHGFAKX"
	    };
	    final StringBuilder result = new StringBuilder();
	    final long passwordLength = 10;
	    for (int index = 0; index < passwordLength; index += 1) {
	        final int passIndex = (int) (passwords.length * index / passwordLength);
	        final int charIndex = (int) Math.abs(
	            UUID.randomUUID().getLeastSignificantBits() % passwords[passIndex].length());
	        result.append(passwords[passIndex].charAt(charIndex));
	    }
	    return result.toString();
	}
}
	