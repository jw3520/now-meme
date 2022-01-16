package kr.memers.nowmeme.crawler;

import kr.memers.nowmeme.dto.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class DaumCafeCrawler extends Crawler {

	public DaumCafeCrawler() {
		//다음 카페 TOP, 카페인기글
		setHomeUrl("https://top.cafe.daum.net");
		setArticlesUrl("https://m.cafe.daum.net");
		setName("daumCafe");
		setLogo("css/logo/daumCafe.png");
		try {
			setDoc(Jsoup.connect(getArticlesUrl()).get());
			putArticleList();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void putArticleList() {
		String url = "", title = "", cafeName = "";
		Iterator<Element> elements_url = getDoc().select("a.popular-list__link").iterator();
		Iterator<Element> elements_title = getDoc().select("strong.popular-list__title").iterator();
		Iterator<Element> elements_cafeName = getDoc().select("span.popular-list__cafe-name").iterator();
		
		for(int i = 0; i < 10; i++) {
			if(elements_url.hasNext()) {
				url = elements_url.next().attr("abs:href");
			}
			if(elements_title.hasNext()) {
				title = elements_title.next().text();
			}
			if(elements_cafeName.hasNext()) {
				cafeName = elements_cafeName.next().text();
			}

			getArticleList().add(new Article(url,title,"", cafeName.length() != 0 ? cafeName.substring(3, cafeName.length()) : ""));
		}
	}
}