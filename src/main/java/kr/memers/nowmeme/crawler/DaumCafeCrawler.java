package kr.memers.nowmeme.crawler;

import kr.memers.nowmeme.dto.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.util.Iterator;

public class DaumCafeCrawler extends Crawler {

	public DaumCafeCrawler() {
		//다음 카페 TOP, 카페인기글
		setHomeUrl("https://top.cafe.daum.net");
		setArticlesUrl("https://m.cafe.daum.net");
		setName("daum_cafe");
		setLogo("css/logo/daum_cafe.png");
		try {
			System.out.println(Jsoup.connect(getArticlesUrl()).get());
			setDoc(Jsoup.connect(getArticlesUrl()).get());
			putArticleList();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void putArticleList() {
		String url = "", title = "", cafeName = "";
		Iterator<Element> elements_url = getDoc().select(".wrap_thumb").iterator();
		Iterator<Element> elements_title = getDoc().select(".tit_story").iterator();
		Iterator<Element> elements_cafeName = getDoc().select(".txt_cafename").iterator();
		
		for(int i = 0; i < 10; i++) {
			if(elements_url.hasNext())
				url = elements_url.next().parent().attr("abs:href");
			if(elements_title.hasNext())
				title = elements_title.next().text();
			if(elements_cafeName.hasNext())
				cafeName = elements_cafeName.next().text();

			getArticleList().add(new Article(url,title,"", cafeName.length() != 0 ? cafeName.substring(3, cafeName.length()) : ""));
		}
	}
}