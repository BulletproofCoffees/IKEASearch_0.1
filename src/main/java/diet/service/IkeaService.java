package diet.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.servlet.ServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Repository;

@Repository
public class IkeaService {

	public String ikeaapi(ServletRequest request) throws IOException {

		
		 StringBuilder urlBuilder = new StringBuilder("https://www.ikea.com/kr/ko/catalog/categories/departments/living_room/39130/"); /*URL*/ 
        /* urlBuilder.append("?" + URLEncoder.encode("query","UTF-8") + "=" + URLEncoder.encode("의자", "UTF-8")); 식품이름*/

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
        request.setAttribute("xml", sb.toString());	           		
	System.out.println(sb.toString());
	
	
	Document doc = Jsoup.parse(sb.toString());
	Element body = doc.body();
	System.out.println(body);
	
		return sb.toString();		
	}
	
}
