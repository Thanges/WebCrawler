import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author TH292310
 *
 */
public class WebCrawlerMain {

	public static void main(String[] args) {
		//Create document variable to hold the links
		Document document = null;
		final String USER_AGENT =
	            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
		String url = "http://wiprodigital.com";
		try {
			Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
			document = connection.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//Getting anchor where ever the links pointing to
		Elements elements = document.select("a[href]");
		for (Element element : elements) {
			//Restricting with the domain (wiprodigital.com) and it will not navigate to any other domain
			if (elements.attr("href").contains("wiprodigital.com"))
			System.out.println(element.attr("href"));
		}
			
		WebCrawler crawler = new WebCrawler();
		crawler.search(url);
	}
}
