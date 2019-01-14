package diet.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//파서테스트
public class test {

	public static void main(String[] args) throws IOException {

		Document url = Jsoup.connect("https://www.ikea.com/kr/ko/catalog/categories/departments/living_room/39130/").get();

		Elements tagVal = url.select("div#allContent div#mainPadding div#main div#filtersAndProductsDiv div.productLists ");

		/*
		 * System.out.println( "tagVal : " + tagVal );
		 */

		/*
		 * String text= tagVal.select("div").html(); System.out.println( "text : " +
		 * text );
		 */

		/*
		 * String a = null; String[] array =
		 * text.split("<a href=\"/kr/ko/catalog/products/");
		 * 
		 * for(int i=0;i<array.length;i++) { a = array[i]; System.out.println(a);
		 * 
		 * 
		 * 
		 * }
		 */

		// 가구코드
		Elements select = tagVal.select("a[class=productLink]");
		List<String> href = new ArrayList<>();
		for (Element a : select) {
			String target = "/kr/ko/catalog/products/";
			int of = target.length();
			href.add(a.attr("href").substring(of));
		}
		System.out.println("가구코드 : " + href);

		// 가구명
		Elements img = tagVal.select("img[class=prodImg]");
		List<String> alt = new ArrayList<>();
		for (Element a : img) {
			alt.add(a.attr("alt"));
		}
		System.out.println("가구명 : " + alt);
		// 이미지
		List<String> imglest = new ArrayList<>();
		for (Element elem : img) {
			if (!elem.attr("src").equals(elem.attr("abs:src"))) {				
				imglest.add(elem.attr("src", elem.attr("abs:src")).toString());			
			}
		}
		System.out.println("이미지: " + imglest);	
		
		
		// 가격
		List<String> pricelist = new ArrayList<>();
		Elements price = tagVal.select("span.price");
		for (Element element : price) {
			pricelist.add(element.text());
		}
		System.out.println("가격: " + pricelist);
		
        



	}


}
