package diet.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Repository;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;

@Repository
public class Apitest {
	private static String Encode(String target) throws UnsupportedEncodingException {
		return URLEncoder.encode(target, "UTF-8");
	}
	String key = "12f21072d2d94cc882af1325c617262c";
	String secret = "1b8d7a0366c64c74a5d723039aab3598";
	public void getapi() throws ServletException, IOException, SignatureException, InvalidKeyException, NoSuchAlgorithmException {
		
		String signature = "";
		
		 StringBuilder urlBuilder = new StringBuilder("http://platform.fatsecret.com/rest/server.api"); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("oauth_consumer_key","UTF-8") + "=" + URLEncoder.encode(key, "UTF-8")); /*Service Key*/
         urlBuilder.append("&" + URLEncoder.encode("oauth_signature_method","UTF-8") + "=" + URLEncoder.encode("HMAC-SHA1", "UTF-8")); /*식품이름*/
         urlBuilder.append("&" + URLEncoder.encode("oauth_timestamp","UTF-8") + "=" + URLEncoder.encode("20181227034011", "UTF-8"));/* 페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("oauth_nonce","UTF-8") + "=" + URLEncoder.encode("abc", "UTF-8")); /*한 페이지 결과 수*/
         urlBuilder.append("&" + URLEncoder.encode("oauth_version","UTF-8") + "=" + URLEncoder.encode("1.0", "UTF-8"));/* 구축년도*/
         urlBuilder.append("&" + URLEncoder.encode("oauth_signature","UTF-8") + "=" +  URLEncoder.encode(signature, "UTF-8")); /*가공업체*/
         urlBuilder.append("&" + URLEncoder.encode("method","UTF-8") + "=" + URLEncoder.encode("Butter", "UTF-8")); /*가공업체*/

         URL url = new URL(urlBuilder.toString());
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Content-type", "application/json");
       /*  System.out.println("Response code: " + conn.getResponseCode());*/
         BufferedReader rd;
         if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
             rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
             rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }
         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
             sb.append(line);
         }
         rd.close();
         conn.disconnect();
         
         
         System.out.println(sb.toString());
         /*request.getRequestDispatcher("/xml.jsp").forward(request, response);*/
		
	}
	
	//인코딩
/*	
	public  String GetNormalizedParamString() throws SignatureException, UnsupportedEncodingException {
		String httpMethod = "GET";
		String encodedURL = Encode("http://platform.fatsecret.com/rest/server.api");
		String normalizedParameter = "aa&";
		
		
		Hashtable<String, String> allParams = new Hashtable<>();
		
		allParams.put("oauth_consumer_key", key);
		allParams.put("oauth_signature_method", "HMAC-SHA1");
		allParams.put("oauth_nonce", "abc");
		allParams.put("oauth_timestamp", "20181227034011");
		allParams.put("oauth_version", "1.0");
		
		Vector<String> keys = new Vector<String>(allParams.keySet());
		Collections.sort(keys);

		for (int i = 0; i < keys.size(); i++) {
			if (i != 0)
				normalizedParameter += "&";
			String key = keys.get(i);
			normalizedParameter += key + "=" + allParams.get(key);
		}

	System.out.println(normalizedParameter);
	
	
	String signatureBaseString = httpMethod + "&" + encodedURL + "&" + normalizedParameter;
	
	 String oauthSignature = calculateRFC2104HMAC(signatureBaseString,key + "&" + secret );
   
	String oauthSignature = encryption(signatureBaseString,
			key + "&" + secret);

	
	System.out.println("인코딩:"+ oauthSignature);
	return oauthSignature;
	
	}

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

	private static String calculateRFC2104HMAC(String data, String key) throws SignatureException {
		String result;
		try {

			// get an hmac_sha1 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);

			// get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);

			// compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(data.getBytes());

			// base64-encode the hmac
			result = EncodeBase64(rawHmac);

		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}

	*//**
	 * Performs base64-encoding of input bytes.
	 *
	 * @param rawData Array of bytes to be encoded.
	 * @return The base64-encoded string representation of rawData.
	 *//*
	private static String EncodeBase64(byte[] rawData) {
	    byte[] byteArray = Base64.encodeBase64(rawData);
        return new String(byteArray);
		return Base64.encodeBytes(rawData);
	}
	*/

	
	public void searchFoodItems() {
		String keys = key;
		String secrets = secret;
		FatsecretService service = new FatsecretService(keys, secrets);
		
		String query = "pasta"; //Your query string
		Response<CompactFood> response = service.searchFoods(query);
		//This response contains the list of food items at zeroth page for your query
		System.out.println("0:  "+response);
		List<CompactFood> results = response.getResults();
		//This list contains summary information about the food items
		System.out.println("0:  "+results);

		Response<CompactFood> responseAtPage3 = service.searchFoods(query, 3);
		//This response contains the list of food items at page number 3 for your query
		//If total results are less, then this response will have empty list of the food items	
		System.out.println("0:  "+responseAtPage3);
	}

}
