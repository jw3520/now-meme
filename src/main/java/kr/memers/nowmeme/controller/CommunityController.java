package kr.memers.nowmeme.controller;

import kr.memers.nowmeme.crawler.DaumCafeCrawler;
import kr.memers.nowmeme.dto.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CommunityController {

    @GetMapping("/community/{name}")
    public ArrayList<Article> getCommunity(@PathVariable String name) {
        ArrayList<Article> articleList = null;
        if(name.equals("daumCafe")) {
            articleList = new DaumCafeCrawler().getArticleList();
        }
        return articleList;
    }
}
