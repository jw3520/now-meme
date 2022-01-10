package kr.memers.nowmeme.crawler;

import kr.memers.nowmeme.dto.Article;
import org.junit.Test;

import java.util.ArrayList;

public class CrawlerTest {

    @Test
    public void daumCafeCrawlerTest(){
        Crawler daumCafeCrawler = new DaumCafeCrawler();
        ArrayList<Article> articleList = daumCafeCrawler.getArticleList();
        System.out.println("< " + daumCafeCrawler.getName() + " >");
        for (Article article : articleList) {
            System.out.println(article.getUrl() + " / " + article.getTitle() + " / " + article.getDate());
        }
    }
}
