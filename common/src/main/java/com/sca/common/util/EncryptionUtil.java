/**
 * 
 */
package com.sca.common.util;

import java.util.Base64;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author subhash
 *
 */
@Component
public class EncryptionUtil {

	@Value("${encryption.key}")
	private String encryptionKey;

	/**
	 * 
	 * @param plainText
	 * @return
	 */
	public String encrypt(String plainText) {
		String key = HashingUtils.md5(encryptionKey);
		String iv = HashingUtils.md5(key);

		return encryptWithAesCBC(plainText, key, iv);
	}

	/**
	 * 
	 * @param encryptedText
	 * @return
	 */
	public String decrypt(String encryptedText) {
		String key = HashingUtils.md5(encryptionKey);
		String iv = HashingUtils.md5(key);

		return decryptWithAesCBC(encryptedText, key, iv);
	}

	private static String encryptWithAesCBC(String plaintext, String key, String iv) {
		try {
			PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
					new CBCBlockCipher(new RijndaelEngine(256)), new ZeroBytePadding());
			CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key.getBytes()), iv.getBytes());
			cipher.init(true, ivAndKey);

			return new String(Base64.getEncoder().encode(cipherData(cipher, plaintext.getBytes())));
		} catch (InvalidCipherTextException e) {
			throw new RuntimeException(e);
		}
	}

	private static String decryptWithAesCBC(String encryptedText, String key, String iv) {
		try {
			byte[] ciphertext = Base64.getDecoder().decode(encryptedText);
			PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(new CBCBlockCipher(new RijndaelEngine(256)),
					new ZeroBytePadding());

			CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key.getBytes()), iv.getBytes());
			aes.init(false, ivAndKey);

			return new String(cipherData(aes, ciphertext));
		} catch (InvalidCipherTextException e) {
			throw new RuntimeException(e);
		}
	}

	private static byte[] cipherData(PaddedBufferedBlockCipher cipher, byte[] data) throws InvalidCipherTextException {
		int minSize = cipher.getOutputSize(data.length);
		byte[] outBuf = new byte[minSize];
		int length1 = cipher.processBytes(data, 0, data.length, outBuf, 0);
		int length2 = cipher.doFinal(outBuf, length1);
		int actualLength = length1 + length2;
		byte[] cipherArray = new byte[actualLength];
		for (int x = 0; x < actualLength; x++) {
			cipherArray[x] = outBuf[x];
		}

		return cipherArray;
	}

}
