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
	/** �??�� ?��?�� */
	private static final String TRANS_FORMATION = "AES/CBC/PKCS5Padding";
	/** �??�� ?��고리�? */
	private static final String ALGORITHM = "AES";
	/** �??�� ?�� */
	private static final String secureKey = "fmf8ffafnf]fA>of";
	/** iv */
	private static final byte[] iv = {52, 8, 76, 111, 64, 57, 32, 124, 55, 17, 82, 93, 51, 14, 58, 21};
	/** AlgorithmParameterSpec */
	private static final AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
	
	/** ?��?��?��?�� Chipher */
	private Cipher cipherEnc;
	/** 복호?��?�� Chiper */
	private Cipher cipherDec;
	/** SecretKeySpec */
	private SecretKeySpec secretKeySpec = null;

	/**
	 * ?��?��?��
	 */
	public SecureAES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		secretKeySpec = new SecretKeySpec(secureKey.getBytes(), ALGORITHM);
	}

	/**
	* ?��?��?�� 처리
	*
	* @param data ?��?��?�� ???��
	* @return ?��?��?�� 결과
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
	* 복호?�� 처리
	*
	* @param data 복호?�� ???��
	* @return 복호?�� 결과
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
