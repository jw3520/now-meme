package kr.memers.nowmeme.crawler;

import kr.memers.nowmeme.dto.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class DcInsideCrawler extends Crawler {

	public DcInsideCrawler() {
		//디시인사이드, 초개념 갤러리
		setHomeUrl("https://www.dcinside.com");
		setArticlesUrl("https://gall.dcinside.com/board/lists/?id=superidea");
		setName("dcinside");
		setLogo("css/logo/dcinside.png");
		try {
			setDoc(Jsoup.connect(getArticlesUrl()).get());
			putArticleList();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void putArticleList() {
		String url = "", title = "", commentCount = "", date = "";
		Iterator<Element> elements_title = getDoc().select(".icon_toprecomimg").iterator();
		Iterator<Element> elements_commentCount = getDoc().select(".reply_num").iterator();
		Iterator<Element> elements_date = getDoc().select(".gall_date").iterator();
		Element element_title = null;
		
		for(int i = 0; i < 10; i++) {
			if(elements_title.hasNext()) {
				element_title = elements_title.next().parent();
			}
			if(elements_commentCount.hasNext()) {
				commentCount = elements_commentCount.next().text();
			}
			if(elements_date.hasNext()) {
				date = elements_date.next().attr("title");
			}
			if(element_title != null) {
				url = element_title.attr("abs:href");
				title = element_title.text();
			}

			getArticleList().add(new Article(url,title,commentCount,date));
		}
	}
}