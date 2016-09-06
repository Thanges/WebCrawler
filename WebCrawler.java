import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class WebCrawler {

	/**
	 * This program is used to crawl the specific domain (wiprodigital.com)
	 */
	private static final int MAX_PAGES_TO_SEARCH = 10;
	//By using set we can make sure that it contains unique entries
	private Set<String> pagesVisited = new HashSet<String>();
	//By using list we can make sure that it collects all the URL entries
    private List<String> pagesToVisit = new LinkedList<String>();
    String url = "http://wiprodigital.com";
    
    private String nextUrl()
    {
        String nextUrl;
        do
        {
            nextUrl = this.pagesToVisit.remove(0);
        } while(this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }
    
	public  void search(String url){
		while(this.pagesVisited.size() < MAX_PAGES_TO_SEARCH)
	      {
	          String currentUrl;
	          if(this.pagesToVisit.isEmpty())
	          {
	              currentUrl = url;
	              this.pagesVisited.add(url);
	          }
	          else
	          {
	              currentUrl = this.nextUrl();
	          }
	}

}

}
