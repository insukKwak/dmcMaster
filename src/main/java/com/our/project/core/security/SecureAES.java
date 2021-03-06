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
	/** ëł?? ?? */
	private static final String TRANS_FORMATION = "AES/CBC/PKCS5Padding";
	/** ëł?? ?ęł ëŚŹěŚ? */
	private static final String ALGORITHM = "AES";
	/** ëł?? ?¤ */
	private static final String secureKey = "fmf8ffafnf]fA>of";
	/** iv */
	private static final byte[] iv = {52, 8, 76, 111, 64, 57, 32, 124, 55, 17, 82, 93, 51, 14, 58, 21};
	/** AlgorithmParameterSpec */
	private static final AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
	
	/** ??¸??Š Chipher */
	private Cipher cipherEnc;
	/** ëłľí¸??Š Chiper */
	private Cipher cipherDec;
	/** SecretKeySpec */
	private SecretKeySpec secretKeySpec = null;

	/**
	 * ??ą?
	 */
	public SecureAES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
		secretKeySpec = new SecretKeySpec(secureKey.getBytes(), ALGORITHM);
	}

	/**
	* ??¸? ě˛ëŚŹ
	*
	* @param data ??¸? ???
	* @return ??¸? ę˛°ęłź
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
	* ëłľí¸? ě˛ëŚŹ
	*
	* @param data ëłľí¸? ???
	* @return ëłľí¸? ę˛°ęłź
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
