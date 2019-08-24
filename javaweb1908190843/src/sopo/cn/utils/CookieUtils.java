package sopo.cn.utils;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	private static final String KEY = "3.14159443055";

	public static void createCookie(HttpServletRequest request, HttpServletResponse response, String username, int sec) {
		Cookie usercookie = new Cookie("userKey", username);
		Cookie ssidcookie = new Cookie("ssid", md5EncryptSelf(username));
		usercookie.setMaxAge(sec);
		ssidcookie.setMaxAge(sec);
		response.addCookie(usercookie);
		response.addCookie(ssidcookie);
	}
	
	public static String md5EncryptSelf(String in) {
		String ss = in == null ? "" : in + KEY;
		char[] md5digest = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'x'};
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] ssarr = ss.getBytes();

//			for(int i = 0; i< ssarr.length; i++) {
//				System.out.println(ssarr[i]);
//			}

			md.update(ssarr);
			byte[] mssarr = md.digest();

//			System.out.println(mssarr);
//			System.out.println(mssarr[20]);

			int len = mssarr.length;
			char[] ch = new char[len * 2];
			int j = 0;

			for (int i = 0; i < len; i++) {
				byte b = mssarr[i];
				ch[j++] = md5digest[b >>> 4 & 0xf];
				ch[j++] = md5digest[b >>> 4 & 0xa];
			}

			System.out.println("---------------------" + new String(ch));
			return new String(ch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
