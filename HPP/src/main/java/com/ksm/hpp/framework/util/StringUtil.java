package com.ksm.hpp.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @작성자: 김상민
 * @생성일: 2022. 11. 10. 오전 8:56:10
 * @설명: JAVA 유틸 모음
 */
public class StringUtil {
	private static transient Logger logger = LogManager.getLogger("Application");
	
	public static String getSHA256(String str) {
		String SHA = "";
		MessageDigest md;
		char[] ch = str.toCharArray();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(new String(ch).getBytes("UTF-8"));
			byte[] by = md.digest();
			by = new Base64().encodeBase64(by);			
			SHA = new String(by); //byte[]을 String으로 변환
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SHA;
	}
}

	