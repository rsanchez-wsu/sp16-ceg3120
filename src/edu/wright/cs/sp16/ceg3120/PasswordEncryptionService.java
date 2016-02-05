/*
 * Copyright (C) 2016
 * 
 * 
 * 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.wright.cs.sp16.ceg3120;

// Imports for encryption
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * PasswordEncryptionService class handles the password encryption. It uses PBKDF2 to encrypt and
 * decrypt clear text.
 */
public class PasswordEncryptionService {
	
	/**
	 * The authenticate function takes the user inputed password and tests it to see if it matches 
	 * the stored encrypted password.
	 * @param attemptedPassword // Password to test
	 * @param encryptedPassword // Encrypted password
	 * @param salt // Hash
	 * @return // Returns if authentication successful
	 * @throws NoSuchAlgorithmException // Throws if algorithm not found
	 * @throws InvalidKeySpecException // Throws if key is invalid
	 */
	public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt)
		throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
	}

	/**
	 * The getEncryptedPassword function encrypts the clear text password
	 * using PBKDF2.
	 * @param password // Password to encrypt
	 * @param salt // Hash
	 * @return // Returns encrypted password
	 * @throws NoSuchAlgorithmException // Throws if algorithm not found
	 * @throws InvalidKeySpecException // Throws if key is invalid
	 */
	public byte[] getEncryptedPassword(String password, byte[] salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// PBKDF2
		String algorithm = "PBKDF2WithHmacSHA1";

		// SHA-1 generates 160 bit hashes
		int derivedKeyLength = 160;
		
		// Recommended at least 1000 iterations
		int iterations = 20000;
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
		return factory.generateSecret(spec).getEncoded();
	}

	/** 
	 * The generateSalt function generates a salt hash for the encryption.
	 * @return // Returns hash
	 * @throws NoSuchAlgorithmException // Throws if algorithm not found
	 */
	public byte[] generateSalt() throws NoSuchAlgorithmException {
		// VERY important to use SecureRandom instead of just Random
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		// Generate a 8 byte (64 bit) salt as recommended by RSA PKCS5
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return salt;
	}
}