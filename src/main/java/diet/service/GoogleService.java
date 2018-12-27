package diet.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Repository;
@Repository
public class GoogleService {
	  @Autowired private GoogleConnectionFactory googleConnectionFactory;
	  @Autowired  private OAuth2Parameters googleOAuth2Parameters;
	  @Autowired  private OAuth2Parameters googleOAuth2Parameters2;	 	//구글 엑센스 취소

	 //googlr로그인url
	public void googlelogin(HttpServletRequest request) {
		
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
	        String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);		      	  	  
	        String url2 = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters2);	//엑센트 취소
	    
	        request.getSession().setAttribute("googleurl",url);	   	       
	        request.getSession().setAttribute("googlesecessionurl",url2);
		
	}
	//로그인 code
	protected Person googlelogin(String code) {
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(),null);
		String accessToken = accessGrant.getAccessToken();
		Long expireTime = accessGrant.getExpireTime();
		if (expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken();
			/*logger.info("accessToken is expired. refresh token = {}", accessToken);*/
		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		PlusOperations plusOperations = google.plusOperations();
		Person profile = plusOperations.getGoogleProfile();
		
		System.out.println("User Uid : " + profile.getId());
        System.out.println("User Name : " + profile.getDisplayName());
        System.out.println("User Email : " + profile.getAccountEmail());
        System.out.println("User Profile : " + profile.getImageUrl());
		 
		return profile;
	}
	
	
	//엑센스 취소
	public void googlesecession(String code) {
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters2.getRedirectUri(),null);
		String accessToken = accessGrant.getAccessToken();
		 // Access Token 취소		
        try {
            System.out.println("Closing Token....");
            String revokeUrl = "https://accounts.google.com/o/oauth2/revoke?token=" + accessToken + "";
            URL url = new URL(revokeUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
 
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }	
	}
	
	
}
