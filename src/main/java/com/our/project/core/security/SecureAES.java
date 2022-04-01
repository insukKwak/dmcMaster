package com.our.project.core.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 *
 */
public class SecureAES {
	/** Î≥??ôò ?òï?ãù */
	private static final String TRANS_FORMATION = "AES/CBC/PKCS5Padding";
	/** Î≥??ôò ?ïåÍ≥†Î¶¨Ï¶? */
	private static final String ALGORITHM = "AES";
	/** Î≥??ôò ?Ç§ */
	private static final String secureKey = "fmf8ffafnf]fA>of";
	/** iv */
	private static final byte[] iv = {52, 8, 76, 111, 64, 57, 32, 124, 55, 17, 82, 93, 51, 14, 58, 21};
	/** AlgorithmParameterSpec */
	private static final AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
	
	/** ?ïî?ò∏?ôî?ö© Chipher */
	private Cipher cipherEnc;
	/** Î≥µÌò∏?ôî?ö© Chiper */
	private Cipher cipherDec;
	/** SecretKeySpec */
	private SecretKeySpec secretKeySpec = null;

	/**
	 * ?Éù?Ñ±?ûê
	 */
	public SecureAES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		secretKeySpec = new SecretKeySpec(secureKey.getBytes(), ALGORITHM);
	}

	/**
	* ?ïî?ò∏?ôî Ï≤òÎ¶¨
	*
	* @param data ?ïî?ò∏?ôî ???ÉÅ
	* @return ?ïî?ò∏?ôî Í≤∞Í≥º
	* @throws NoSuchAlgorithmException
	* @throws NoSuchPaddingException
	* @throws UnsupportedEncodingException
	* @throws InvalidKeyException
	* @throws InvalidAlgorithmParameterException
	* @throws IllegalBlockSizeException
	* @throws BadPaddingException
	*/
	public String encrypt(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		if (cipherEnc == null) {
			cipherEnc = Cipher.getInstance(TRANS_FORMATION);
			cipherEnc.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivSpec);
		}
		
		if (data == null) {
			data = "";
		}
		
		byte[] textBytes = data.getBytes();
		
		byte[] result = null;
		
		result = cipherEnc.doFinal(textBytes);
		
		return Base64.encodeBase64String(result);
	}

	/**
	* Î≥µÌò∏?ôî Ï≤òÎ¶¨
	*
	* @param data Î≥µÌò∏?ôî ???ÉÅ
	* @return Î≥µÌò∏?ôî Í≤∞Í≥º
	* @throws NoSuchAlgorithmException
	* @throws NoSuchPaddingException
	* @throws UnsupportedEncodingException
	* @throws InvalidKeyException
	* @throws InvalidAlgorithmParameterException
	* @throws IllegalBlockSizeException
	* @throws BadPaddingException
	*/
	public String decrypt(String data) throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		if (cipherDec == null) {
			cipherDec = Cipher.getInstance(TRANS_FORMATION);
			cipherDec.init(Cipher.DECRYPT_MODE, secretKeySpec, ivSpec);
		}
		
		if (data == null) {
			return "";
		}
		
		byte[] textBytes = Base64.decodeBase64(data);
		
		byte[] result = null;
		
		result = cipherDec.doFinal(textBytes);
		
		return new String(result);
	}
}
