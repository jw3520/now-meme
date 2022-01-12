package kr.memers.nowmeme.controller;

import kr.memers.nowmeme.crawler.DaumCafeCrawler;
import kr.memers.nowmeme.crawler.DcInsideCrawler;
import kr.memers.nowmeme.dto.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CommunityController {

    @Autowired
    DaumCafeCrawler daumCafeCrawler;
    @Autowired
    DcInsideCrawler dcInsideCrawler;

    @GetMapping("/community/{name}")
    public ArrayList<Article> getCommunity(@PathVariable String name) {
        ArrayList<Article> articleList = null;
        if(name.equals("daumCafe")) {
            articleList = daumCafeCrawler.getArticleList();
        } else if(name.equals("dcInside")) {
            articleList = dcInsideCrawler.getArticleList();
        }
        return articleList;
    }
}
