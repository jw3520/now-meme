package kr.memers.nowmeme.crawler;

import kr.memers.nowmeme.dto.Article;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

@Getter
@Setter
public abstract class Crawler {
	private String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";
	private String homeUrl;
	private String articlesUrl;
	private String name;
	private String logo;
	private Document doc = null;
	private ArrayList<Article> articleList = new ArrayList<>();

	abstract public void putArticleList();
}
